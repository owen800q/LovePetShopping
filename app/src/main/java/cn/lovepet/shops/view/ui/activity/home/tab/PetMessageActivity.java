package cn.lovepet.shops.view.ui.activity.home.tab;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.umeng.analytics.MobclickAgent;

import cn.lovepet.shops.R;
import cn.lovepet.shops.base.BaseActivity;

/**
 * @author JSYL-DCL
 * @date 2018/11/21 14:33
 * @des 宠物消息
 */
public class PetMessageActivity extends BaseActivity {

    public static void getInstance(Context context){
        context.startActivity(new Intent(context,PetMessageActivity.class));
    }
    @Override
    protected int getLayoutId() {
        return R.layout.activity_pet_message;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {

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

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }
}