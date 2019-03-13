package cn.lovepet.shops.view.ui.activity.personal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.lovepet.shops.R;
import cn.lovepet.shops.base.BaseActivity;
import cn.lovepet.shops.bean.AppBean;
import cn.lovepet.shops.helper.basequickadapter.BaseQuickAdapter;
import cn.lovepet.shops.helper.basequickadapter.BaseViewHolder;
import cn.lovepet.shops.helper.imageview.DashlineItemDivider;
import cn.lovepet.shops.helper.immersive.title.OnTitleBarListener;
import cn.lovepet.shops.helper.immersive.title.TitleBar;

//import com.github.library.BaseQuickAdapter;
//import com.github.library.BaseViewHolder;

/**
 * @author JSYL-DCL
 * @date 2018/11/6 17:25
 * @des
 */
public class LauncherAllActivity extends BaseActivity{
    private static final java.lang.String TAG1 = LauncherAllActivity.class.getSimpleName();
    @BindView(R.id.launchRecyclerView)
    RecyclerView mLaunchRecyclerView;
    @BindView(R.id.titleBar)
    TitleBar mTitleBar;
    private LauncherAdapter mAdapter;
    private List<AppBean> launcherDatas;//mList的泛型换成AppBean
    private Context mContext;
    private PackageManager packageManager = null;

    public static void getInstance(Context context){
        context.startActivity(new Intent(context,LauncherAllActivity.class));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_launcherall;
    }

    @Override
    protected void init() {
        launcherDatas = new ArrayList<>();
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mContext = LauncherAllActivity.this;
        mTitleBar.setTitle("应用中心");
        initTitleBarStyle();
        setDatas();
    }

    private void setDatas() {
        mLaunchRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mLaunchRecyclerView.setHasFixedSize(true);
        //添加item分割线
        mLaunchRecyclerView.addItemDecoration(new DashlineItemDivider("#B2B2B2"));
//        mLaunchRecyclerView.setItemViewCacheSize(10);
        mAdapter = new LauncherAdapter(R.layout.item_launcher_package,launcherDatas);
        //防止数据错乱
        mAdapter.setHasStableIds(true);
        mLaunchRecyclerView.setAdapter(mAdapter);
        getAllPackageData();
    }


    private void getAllPackageData() {
        packageManager = getPackageManager();
        List<PackageInfo> list = packageManager.getInstalledPackages(0);//获取已安装的全部应用
            for (PackageInfo info : list) {
                if ((info.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
                    AppBean bean = new AppBean();
                    bean.setName(info.applicationInfo.loadLabel(packageManager));
                    bean.setPackageName(info.packageName);
                    bean.setIcon(info.applicationInfo.loadIcon(packageManager));
//                    Drawable d = packageManager.getApplicationIcon(info.applicationInfo);
//                    bean.setIcon(d);
                    launcherDatas.add(bean);
                }
            }
        //拿到数据再刷新列表
        mAdapter.notifyDataSetChanged();
    }




    public class LauncherAdapter extends BaseQuickAdapter<AppBean, BaseViewHolder> {
        public LauncherAdapter(int layoutResId, List<AppBean> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, final AppBean item, int position) {
            ImageView view = (ImageView) helper.getView(R.id.ivPackageIcon);
            view.setImageDrawable(item.getIcon());
            helper.setText(R.id.tvPackageName,item.getName());
            helper.setText(R.id.tvPackageSrc,item.getPackageName());
            helper.getView(R.id.rlPackage).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (packageManager != null) {
                        Intent intent = new Intent(packageManager.getLaunchIntentForPackage(item.getPackageName()));//根据包名启动此应用
                        mContext.startActivity(intent);
                    }
                }
            });
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected void getBundleExtras(Intent intent) {

    }

    @Override
    protected int setImmersiveStatusBarColor() {
        return 0;
    }

    private void initTitleBarStyle() {
        if (setImmersiveStatusBarColor() != 0) {
            mTitleBar.setBackgroundResource(setImmersiveStatusBarColor());
        }else{
            mTitleBar.setBackgroundResource(R.color.white);
        }
        mTitleBar.setTitleColor(mContext.getResources().getColor(R.color.color_super_value_text_sale_price));
        mTitleBar.setBackgroundResource(R.color.white);
        mTitleBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onLeftClick(View v) {
//                Toast.makeText(mContext, "返回", Toast.LENGTH_SHORT).show();
                finish();
            }
            @Override
            public void onTitleClick(View v) {
            }
            @Override
            public void onRightClick(View v) {
            }
        });
    }
}