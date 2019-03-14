package cn.lovepet.shops.view.ui.activity.content;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.umeng.analytics.MobclickAgent;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.lovepet.shops.R;
import cn.lovepet.shops.base.BaseActivity;
import cn.lovepet.shops.helper.customview.BackGroundImage;
import cn.lovepet.shops.util.ToastsUtils;

/**
 * @author JSYL-DCL
 * @date 2018/11/20 10:20
 * @des
 */
public class ScrollTopActivity extends BaseActivity{
    @BindView(R.id.activity_business_district_library_area)
    TextView area1;
    @BindView(R.id.activity_business_district_library_industry)
    TextView area2;
    @BindView(R.id.activity_business_district_library_shangxi)
    TextView area3;
    @BindView(R.id.backGroundImage)
    BackGroundImage backGroundImage;
    private List<Drawable> drawableList;
    private Context mContext;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_scroll_top;
    }

    @Override
    protected void init() {
    }

    @OnClick({
             R.id.activity_business_district_library_area
            ,R.id.activity_business_district_library_industry
            ,R.id.activity_business_district_library_shangxi
    })
    public void bindViewClick(View view){
        switch (view.getId()){
            case  R.id.activity_business_district_library_area:
                ToastsUtils.showShort("TAB1");
                break;
            case  R.id.activity_business_district_library_industry:
                ToastsUtils.showShort("TAB2");
                break;
            case  R.id.activity_business_district_library_shangxi:
                ToastsUtils.showShort("TAB3");
                break;
        }
    }


    @Override
    protected void initView(Bundle savedInstanceState) {
        mContext = ScrollTopActivity.this;
        drawableList = new ArrayList<>();
        final Drawable drawable = ContextCompat.getDrawable(mContext, R.drawable.temp_image2);
        final Drawable drawable1 = ContextCompat.getDrawable(mContext, R.drawable.temp_image3);
        final Drawable drawable2 = ContextCompat.getDrawable(mContext, R.drawable.temp_image4);
        final Drawable drawable3 = ContextCompat.getDrawable(mContext, R.drawable.temp_image5);
        drawableList.add(drawable);
        drawableList.add(drawable1);
        drawableList.add(drawable2);
        drawableList.add(drawable3);
    }

    @Override
    protected void initData() {
        backGroundImage.setmDegree(20);
        backGroundImage.setmDrawableLists(drawableList);
        backGroundImage.setmPosition(1);
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