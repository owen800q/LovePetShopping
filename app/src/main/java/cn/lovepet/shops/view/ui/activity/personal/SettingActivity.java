package cn.lovepet.shops.view.ui.activity.personal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import cn.lovepet.shops.R;
import cn.lovepet.shops.base.BaseActivity;
import cn.lovepet.shops.helper.immersive.title.OnTitleBarListener;
import cn.lovepet.shops.helper.immersive.title.TitleBar;
import cn.lovepet.shops.view.ui.activity.content.GoodsNewsActivity;
import cn.lovepet.shops.view.ui.activity.content.albumhomegoods.MainGoodsShopActivity;
import cn.lovepet.shops.view.ui.activity.content.ZxingQrcodeActivity;

/**
 * @author JSYL-DCL
 * @date 2018/12/29 10:28
 * @des 设置
 */
public class SettingActivity extends BaseActivity {
    @BindView(R.id.titleBar)
    TitleBar mTitleBar;
    @BindView(R.id.tvAppstore)
    TextView mTvAppstore;
    @BindView(R.id.tvGoodsNews)
    TextView mTvGoodsNews;
    private Context _context;

    public static void getInstance(Context context) {
        context.startActivity(new Intent(context, SettingActivity.class));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        _context = SettingActivity.this;
        mTitleBar.setTitle("设置");
        initTitleBarStyle();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @OnClick({
             R.id.tvAppstore
            , R.id.tvGoodsNews
            , R.id.tvQrcode
            , R.id.tvGoodsDetail
    })
    public void bindViewClick(View view) {
        switch (view.getId()) {
            case R.id.tvAppstore://应用管理器
                LauncherAllActivity.getInstance(_context);
                break;
            case R.id.tvGoodsNews://商品展示
                GoodsNewsActivity.getInstance(_context);
                break;
            case R.id.tvQrcode://二维码
                ZxingQrcodeActivity.getInstance(_context);
                break;
            case R.id.tvGoodsDetail://商品展览
                MainGoodsShopActivity.getInstance(_context);
                break;
        }
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
        } else {
            mTitleBar.setBackgroundResource(R.color.white);
        }
        mTitleBar.setTitleColor(getResources().getColor(R.color.color_super_value_text_sale_price));
        mTitleBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onLeftClick(View v) {
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