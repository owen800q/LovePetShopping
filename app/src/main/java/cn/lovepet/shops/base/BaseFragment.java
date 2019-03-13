package cn.lovepet.shops.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.lovepet.shops.helper.immersive.title.TitleBar;
import cn.lovepet.shops.helper.immersive.title.style.TitleBarLightStyle;
import cn.lovepet.shops.util.ApplicationUtil;
import cn.lovepet.shops.util.ToastsUtils;


/**
 * 类名: BaseFragment
 * Fragment基类
 * author：JSYL-DCL on 2017/6/19
 */
public abstract class BaseFragment extends Fragment {
	private View mContentView;
	private Context mContext;
	private Activity mActivity;
	private Unbinder unbinder;
	private boolean canImmersible = true;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
//		bindData(savedInstanceState);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mActivity=activity;

	}
	//得到可靠地Activity
	public Activity getMyActivity(){
		return mActivity;
	}
	@Override
	public void onDetach() {
		super.onDetach();
		mActivity = null;
	}


	@Override
	public void onCreate(Bundle savedInstanceState) {
		//在这里可以初始化样式
		TitleBar.initStyle(new TitleBarLightStyle());
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		//隐藏软键盘
		init();
		canImmersible = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
		getMyActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		mContentView = inflater.inflate(setLayoutResourceID(),container,false);
		ToastsUtils.register(getMyActivity());
//		ButterKnife.bind(this,mContentView);
		//绑定控件
		unbinder = ButterKnife.bind(this,mContentView);
		mContext = getContext();
		bindView();
		//设置沉浸式
		initImmersive();
		bindData(savedInstanceState);
		bindListener();
		return mContentView;
	}


	/**
	 * 初始化沉浸式
	 */
	private void initImmersive() {
		//默认透明
		ApplicationUtil.setImmersible(getActivity(), canImmersible, false,true,setImmersiveStatusBarColor());
	}

	protected abstract int setImmersiveStatusBarColor();

	/**
	 * 此方法用于返回Fragment设置ContentView的布局文件资源ID
	 *
	 * @return 布局文件资源ID
	 */
	protected abstract int setLayoutResourceID();

	/**
	 * 此方法用于初始化成员变量及获取Intent传递过来的数据
	 * 注意：这个方法中不能调用所有的View，因为View还没有被初始化，要使用View在initView方法中调用
	 */
	protected abstract void init();

	/**
	 * 初始化组件
	 **/
	protected abstract void bindView();
	/***
	 * @方法名: initData
	 **/
	protected abstract void bindData(Bundle savedInstanceState);
	/**
	 * 注册监听
	 **/
	protected abstract void bindListener();

	//是否触摸在指定view上面,对某个控件过滤
	public boolean isTouchView(View[] views, MotionEvent ev) {
		if (views == null || views.length == 0) return false;
		int[] location = new int[2];
		for (View view : views) {
			view.getLocationOnScreen(location);
			int x = location[0];
			int y = location[1];
			if (ev.getX() > x && ev.getX() < (x + view.getWidth())
					&& ev.getY() > y && ev.getY() < (y + view.getHeight())) {
				return true;
			}
		}
		return false;
	}
	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	public View getContentView() {
		return mContentView;
	}

	public Context getMContext() {
		return mContext;
	}

	/**
	 * 圆形进度条对话框
	 */
	private ProgressDialog progressDialog;
	public void showProgressesDialog(Context context, String message) {
		if (progressDialog != null && progressDialog.isShowing()){
			return;
		}
		progressDialog = new ProgressDialog(context);
		progressDialog.setMessage(message);
		progressDialog.setCancelable(false);
		progressDialog.show();
	}
	public void cancelProgressesDialog() {
		if (progressDialog != null && progressDialog.isShowing()){
			progressDialog.dismiss();
		}
	}

	public void showTextDialog(final Context context, String content) {
		AlertDialog alertDialog = new AlertDialog.Builder(context)
				.setMessage(content)
				.setCancelable(false)
				.setNegativeButton("确定", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						if (dialog != null) {
							dialog.dismiss();
						}
					}
				})
				.create();
		alertDialog.show();
	}

	private InputMethodManager imm;
	public void hideSoftKeyBoard() {
		View localView = getMyActivity().getCurrentFocus();
		if (imm == null) {
			imm = (InputMethodManager)getMyActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
		}
		if ((localView != null) && (imm != null)) {
			imm.hideSoftInputFromWindow(localView.getWindowToken(), 2);
		}
	}

	@Override
	public void onDestroy() {
		unbinder.unbind();
		super.onDestroy();
	}
}
