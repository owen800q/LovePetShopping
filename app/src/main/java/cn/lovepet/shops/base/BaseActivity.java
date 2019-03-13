package cn.lovepet.shops.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.lovepet.shops.helper.http.HttpHelper;
import cn.lovepet.shops.helper.pemission.PermissionActivity;
import cn.lovepet.shops.mvp.base.DataManager;
import cn.lovepet.shops.mvp.dao.DataBaseHelper;
import cn.lovepet.shops.util.ApplicationUtil;
import cn.lovepet.shops.util.KeyBoardUtils;
import cn.lovepet.shops.util.SharePreferenceHelper;

/**
 * Activity的父类
 */
public abstract class BaseActivity extends PermissionActivity {
    /**
     * 状态栏的默认背景色
     */
    private Context mContext = this;
    private static Context mAppcompatContext;
    protected static String TAG;
    private Unbinder unbinder;
    protected boolean isWhite = true;
    protected boolean isWhite1 = true;
    private boolean canImmersible = true;
    public DataManager mDataManager;
    /**
     * 退出系统广播
     */
    private ExitSysTemBroadCast exitSysTemBroadCast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = this.getClass().getSimpleName();
        mAppcompatContext = getApplicationContext();
        canImmersible = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(getLayoutId());
        init();
        exitSysTemBroadCast = new ExitSysTemBroadCast();
        IntentFilter intentFilter = new IntentFilter(Constants.APK_EXIT);
        registerReceiver(exitSysTemBroadCast, intentFilter);
        //绑定控件
        unbinder = ButterKnife.bind(this);
        MApplication.getAppManager().addActivity(this);
        AppManager.getAppManager().addActivity(this);
        //初始化数据处理管理器
        mDataManager = new DataManager(this,new HttpHelper(this),new SharePreferenceHelper(this),new DataBaseHelper(this));
        initView(savedInstanceState);
        //设置沉浸式
        initImmersive();
        Intent intent = getIntent();
        if (intent != null) {
            Bundle extras = getIntent().getExtras();
            if (null != extras) {
                getBundleExtras(extras);
            }
            getBundleExtras(intent);
        }
        initData();
        initListener();
    }

    private void initImmersive() {
        //默认透明
        ApplicationUtil.setImmersible((Activity) this, canImmersible, false,true,setImmersiveStatusBarColor());
    }

    /**
     * 设置布局ID
     * @return 资源文件ID
     */
    protected abstract @LayoutRes
    int getLayoutId();

    /**
     * 初始化操作
     * @param
     */
    protected abstract void init();
    protected abstract void initView(Bundle savedInstanceState);
    /**
     * 初始化数据源
     */
    protected abstract void initData();

    /**
     * 初始化监听事件
     */
    protected abstract void initListener();

    /**
     * Bundle  传递数据
     * @param extras
     */
    protected abstract void getBundleExtras(Bundle extras);
    protected abstract void getBundleExtras(Intent intent);

    protected abstract int setImmersiveStatusBarColor();

    /**
     * 圆形进度条对话框
     */
    private ProgressDialog progressDialog;
    public void showProgressDialog(String message, Boolean isCanCancelable) {
        if (progressDialog != null && progressDialog.isShowing()){
            return;
        }
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(message);
        progressDialog.setCancelable(isCanCancelable);
        progressDialog.show();
    }
    public void cancelProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()){
            progressDialog.dismiss();
        }
    }

    /**
     * 清除editText的焦点
     * @param v   焦点所在View
     * @param ids 输入框
     */
    public void clearViewFocus(View v, int... ids) {
        if (null != v && null != ids && ids.length > 0) {
            for (int id : ids) {
                if (v.getId() == id) {
                    v.clearFocus();
                    break;
                }
            }
        }
    }

    /**
     * 隐藏键盘
     * @param v   焦点所在View
     * @param ids 输入框
     * @return true代表焦点在edit上
     */
    public boolean isFocusEditText(View v, int... ids) {
        if (v instanceof EditText) {
            EditText tmp_et = (EditText) v;
            for (int id : ids) {
                if (tmp_et.getId() == id) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 是否触摸在指定view上面,对某个控件过滤
     *
     * @param views
     * @param ev
     * @return
     */
    public boolean isTouchView(View[] views, MotionEvent ev) {
        if (views == null || views.length == 0) {
            return false;
        }
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
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            if (isTouchView(filterViewByIds(), ev)) {
                return super.dispatchTouchEvent(ev);
            }
            if (hideSoftByEditViewIds() == null || hideSoftByEditViewIds().length == 0) {
                return super.dispatchTouchEvent(ev);
            }
            View v = getCurrentFocus();
            if (isFocusEditText(v, hideSoftByEditViewIds())) {
                //隐藏键盘
                KeyBoardUtils.hideInputForce(this);
                clearViewFocus(v, hideSoftByEditViewIds());
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 隐藏软键盘过滤
     *
     * @return
     */
    public int[] hideSoftByEditViewIds() {
        return null;
    }

    /**
     * 传入要过滤的View
     * 过滤之后点击将不会有隐藏软键盘的操作
     *
     * @return id 数组
     */
    public View[] filterViewByIds() {
        return null;
    }


    /**
     * 退出程序广播 销毁所有界面
     */
    public class ExitSysTemBroadCast extends BroadcastReceiver {

        @Override
        public void onReceive(Context arg0, Intent intent) {
            //接收发送过来的广播内容
            int closeAll = intent.getIntExtra("systemExit", 0);
            if (closeAll == 1) {
                finish();//销毁BaseActivity
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(null != this.getCurrentFocus()){
            // 点击空白位置 隐藏软键盘
            InputMethodManager mInputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            return mInputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
        }
        return super.onTouchEvent(event);
    }


    @Override
    protected void onPause() {
        super.onPause();
    }
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        if (progressDialog != null && progressDialog.isShowing())progressDialog.dismiss();
        //注销广播
        unregisterReceiver(exitSysTemBroadCast);
        super.onDestroy();
    }
}
