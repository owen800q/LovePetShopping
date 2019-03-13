package cn.lovepet.shops.view.ui.activity.content;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.lovepet.shops.R;
import cn.lovepet.shops.base.BaseActivity;
import cn.lovepet.shops.base.Constants;
import cn.lovepet.shops.bean.GoodsNewsBean;
import cn.lovepet.shops.helper.basequickadapter.BaseQuickAdapter;
import cn.lovepet.shops.helper.headerview.HeaderView;
import cn.lovepet.shops.helper.headerview.PtrFrameLayout;
import cn.lovepet.shops.helper.headerview.PtrHandler;
import cn.lovepet.shops.helper.zxing.multizxing.Constant;
import cn.lovepet.shops.helper.zxing.multizxing.ZxingConfig;
import cn.lovepet.shops.helper.zxing.multizxing.android.CaptureMultiActivity;
import cn.lovepet.shops.mvp.base.GoodsNewsContract;
import cn.lovepet.shops.mvp.presenter.GoodsNewsPresenterImpl;
import cn.lovepet.shops.util.ILog;
import cn.lovepet.shops.util.ToastsUtils;
import cn.lovepet.shops.view.adapter.GoodsNewsAdapter;
import pub.devrel.easypermissions.EasyPermissions;

import static cn.lovepet.shops.view.ui.activity.content.ZxingQrcodeActivity.RC_READ_PHOTO;

/**
 * @author JSYL-DCL
 * @date 2018/12/29 10:28
 * @des 商品资讯
 */
public class GoodsNewsActivity extends BaseActivity implements GoodsNewsContract.View, PtrHandler, BaseQuickAdapter.RequestLoadMoreListener {
    private static final java.lang.String TAG1 = GoodsNewsActivity.class.getSimpleName();
    @BindView(R.id.scanning_img)
    ImageView mScanningImg;
    @BindView(R.id.advisory_img)
    ImageView mAdvisoryImg;
    @BindView(R.id.adCenter_img)
    ImageView mAdCenterImg;
    @BindView(R.id.newsRecyclerview)
    RecyclerView mNewsRecyclerview;
    @BindView(R.id.refreshHeader)
    HeaderView mRefreshHeader;
    private Context _context;
    private GoodsNewsAdapter mAdapter;
    private GoodsNewsPresenterImpl mPresenter;
    private int REQUEST_CODE_SCAN = 111;

    public static void getInstance(Context context) {
        context.startActivity(new Intent(context, GoodsNewsActivity.class));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_goods_news;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        _context = GoodsNewsActivity.this;
        mPresenter = new GoodsNewsPresenterImpl(this);
//        mRefreshHeader.autoRefresh(true,3000);
        setCurrentNews();
    }

    /**
     * 设置刷新头和数据
     */
    private void setCurrentNews() {
        mRefreshHeader.setPtrHandler(this);
        mNewsRecyclerview.setLayoutManager(new LinearLayoutManager(_context));
        mAdapter = new GoodsNewsAdapter(R.layout.item_goods_news);
        mAdapter.setOnLoadMoreListener(this);
        mAdapter.setEnableLoadMore(true);
        mNewsRecyclerview.setAdapter(mAdapter);
        mRefreshHeader.autoRefresh(true, 1000);
//        getGoodsNewsData();
    }

    /**
     * 填充列表数据
     */
//    private void getGoodsNewsData() {
//        InputStream is = null;
//        try {
//            is = _context.getAssets().open(Constants.ASSET_GOODS_NEWS);
//            String text = FileUtils.readTextFromFile(is);
//            Gson gson = new Gson();
//            GoodsNewsBean goodsNewsBean = gson.fromJson(text, GoodsNewsBean.class);
//            List<GoodsNewsBean.ContentBean> content = goodsNewsBean.content;
//            mAdapter.addData(content);
//            intSize = content.size();
//        } catch (IOException e) {
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
    @Override
    protected void initData() {
//        mPresenter.getGoodsNewsData();
    }

    @Override
    protected void initListener() {

    }

    @OnClick({
            R.id.scanning_img
            , R.id.advisory_img
            , R.id.adCenter_img
    })
    public void bindViewClick(View view) {
        switch (view.getId()) {
            case R.id.scanning_img:
                checkPermissions();
                break;
            case R.id.advisory_img:
                ToastsUtils.showShort("资讯消息");
                break;
            case R.id.adCenter_img:
                ToastsUtils.showShort("浏览设置");
                break;

        }
    }

    /**
     * 检查权限：相机、存储
     */
    private void checkPermissions() {
        String[] perms = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
        if (EasyPermissions.hasPermissions(this, perms)) {//有权限
            Intent intent = new Intent(_context, CaptureMultiActivity.class);
            /**
             * ZxingConfig是配置类
             * 可以设置是否显示底部布局，闪光灯，相册，
             * 是否播放提示音  震动
             * 设置扫描框颜色等
             * 也可以不传这个参数
             **/
            ZxingConfig config = new ZxingConfig();
            config.setPlayBeep(true);//是否播放扫描声音 默认为true
            config.setShake(true);//是否震动  默认为true
            config.setDecodeBarCode(true);//是否扫描条形码 默认为true
            config.setReactColor(R.color.white);//设置扫描框四个角的颜色 默认为白色
            config.setFrameLineColor(R.color.transparent);//设置扫描框边框颜色 默认无色
            config.setScanLineColor(R.color.material_red_300);//设置扫描线的颜色 默认白色
            config.setFullScreenScan(true);//是否全屏扫描  默认为true  设为false则只会在扫描框中扫描
            intent.putExtra(Constant.INTENT_ZXING_CONFIG, config);
            startActivityForResult(intent, REQUEST_CODE_SCAN);
        } else {
            EasyPermissions.requestPermissions(this, getString(R.string.permission_external_storage1), RC_READ_PHOTO, perms);
        }


       /* AndPermission.with(this)
                .permission(Permission.CAMERA, Permission.READ_EXTERNAL_STORAGE)
                .onGranted(new Action() {
                    @Override
                    public void onAction(List<String> permissions) {
                        Intent intent = new Intent(_context, CaptureMultiActivity.class);
                        *//*ZxingConfig是配置类
         *可以设置是否显示底部布局，闪光灯，相册，
         * 是否播放提示音  震动
         * 设置扫描框颜色等
         * 也可以不传这个参数
         * *//*
//                                ZxingConfig config = new ZxingConfig();
//                                config.setPlayBeep(false);//是否播放扫描声音 默认为true
//                                config.setShake(false);//是否震动  默认为true
//                                config.setDecodeBarCode(false);//是否扫描条形码 默认为true
//                                config.setReactColor(R.color.colorAccent);//设置扫描框四个角的颜色 默认为白色
//                                config.setFrameLineColor(R.color.colorAccent);//设置扫描框边框颜色 默认无色
//                                config.setScanLineColor(R.color.colorAccent);//设置扫描线的颜色 默认白色
//                                config.setFullScreenScan(false);//是否全屏扫描  默认为true  设为false则只会在扫描框中扫描
//                                intent.putExtra(Constant.INTENT_ZXING_CONFIG, config);
                        startActivityForResult(intent, REQUEST_CODE_SCAN);
                    }
                })
                .onDenied(new Action() {
                    @Override
                    public void onAction(List<String> permissions) {
                        Uri packageURI = Uri.parse("package:" + getPackageName());
                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageURI);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        Toast.makeText(_context, "没有权限无法扫描呦", Toast.LENGTH_LONG).show();
                    }
                }).start();*/
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


    /**
     * 刷新开始
     *
     * @param frame
     */
    @Override
    public void onRefreshBegin(final PtrFrameLayout frame) {
        frame.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPresenter.getGoodsNewsData();
            }
        }, 1000);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    /**
     * 加载更多数据填充
     *
     * @param find
     */
    @Override
    public void setMoreData(GoodsNewsBean find) {
        mAdapter.getData().addAll(find.content);
        mAdapter.loadMoreComplete();
    }


    /**
     * 加载更多
     */
    @Override
    public void onLoadMoreRequested() {
        mNewsRecyclerview.postDelayed(new Runnable() {
            @Override
            public void run() {
                ILog.e(TAG1, "mAdapter.getData().size():" + mAdapter.getData().size());
                ILog.e(TAG1, "intSize:" + intSize);
                if (mAdapter.getData().size() >= intSize * 2) {
                    mAdapter.loadMoreEnd(false);
                } else {
                    mPresenter.getMoreFindData();
                }
            }
        }, 1000);
    }

    /**
     * 填充列表数据
     *
     * @param find
     */
    private int intSize = 0;

    @Override
    public void setGoodsNewsData(GoodsNewsBean find) {
        mAdapter.getData().clear();
        mAdapter.getData().addAll(find.content);
        mRefreshHeader.refreshComplete();
        mAdapter.notifyDataSetChanged();
        intSize = find.content.size();
        mAdapter.loadMoreComplete();
//        if (mAdapter.isLoadMoreEnable())
//        mAdapter.removeAllData();
//        mAdapter.addData(find.content);

    }


    @Override
    public void onNetError(String e) {

    }

    @Override
    public void onError(String e) {

    }

    @Override
    public void onFailure(String e) {

    }

    @Override
    public void onSuccess(String e) {

    }

    @Override
    public void onShowProgress(String msg) {

    }

    @Override
    public void onCancelProgress(String msg) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 扫描二维码/条码回传
        if (requestCode == REQUEST_CODE_SCAN && resultCode == RESULT_OK) {
            if (data != null) {
                String content = data.getStringExtra(Constants.CODED_CONTENT);
                if (content != null) {
                    ToastsUtils.showShort(content);
                } else {
                    ToastsUtils.showShort("不是标准二维码图片，请试试其他二维码图片");
                }
            }
        }
    }
}