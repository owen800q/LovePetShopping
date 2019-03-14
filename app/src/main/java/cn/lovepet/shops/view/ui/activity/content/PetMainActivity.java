package cn.lovepet.shops.view.ui.activity.content;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.umeng.analytics.MobclickAgent;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.lovepet.shops.R;
import cn.lovepet.shops.base.BaseActivity;
import cn.lovepet.shops.base.Constants;
import cn.lovepet.shops.helper.video.CustomMediaPlayer.JZMediaSystem;
import cn.lovepet.shops.helper.video.CustomMediaPlayer.Jzvd;
import cn.lovepet.shops.view.ui.activity.category.PetCategoryFragment;
import cn.lovepet.shops.view.ui.activity.home.PetHomeFragment;
import cn.lovepet.shops.view.ui.activity.personal.PetPersonalFragment;
import cn.lovepet.shops.view.ui.activity.shopcart.PetShopCartFragment;
import cn.lovepet.shops.view.ui.activity.union.PetUnionFragment;


/**
 * 主界面
 * @author JSYL-DCL
 * @date 2018/8/24 13:58
 * @des
 */
public class PetMainActivity extends BaseActivity implements View.OnClickListener{
    private Context mContext = PetMainActivity.this;
    private final String TAG1 = PetMainActivity.class.getSimpleName();
    Handler handler = new Handler();//这里其实并不需要handler，为了防止播放中切换播放器引擎导致的崩溃，实际使用时一般不会遇到，可以随时调用JZVideoPlayer.setMediaInterface();
    //首页
    PetHomeFragment petHomeFragment;
    //分类
    PetCategoryFragment petCategoryFragment;
    //萌爪联盟
    PetUnionFragment petUnionFragment;
    //购物车
    PetShopCartFragment petShopCartFragment;
    //我的E宠
    PetPersonalFragment petPersonalFragment;
    //作业
    @BindView(R.id.ll_bottom_bar_check)
    LinearLayout llCheck;
    @BindView(R.id.iv_check_image)
    ImageView ivCheckImage;

    //分类
    @BindView(R.id.ll_bottom_bar_profile)
    LinearLayout llProfile;
    @BindView(R.id.iv_profile_image)
    ImageView ivProfileImage;

    //联盟
    @BindView(R.id.ll_bottom_bar_union)
    LinearLayout llUnion;
    @BindView(R.id.iv_union_image)
    ImageView ivUnion;

    //购物车
    @BindView(R.id.ll_bottom_bar_shopcart)
    LinearLayout llShopcart;
    @BindView(R.id.iv_shopcart_image)
    ImageView ivShopcart;

    //我的
    @BindView(R.id.ll_bottom_bar_personal)
    LinearLayout llPersonal;
    @BindView(R.id.iv_personal_image)
    ImageView ivPersonal;
    private List<ImageView> iv_list;

    @Override
    protected void init() {
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected void getBundleExtras(Intent intent) {

    }


    @Override
    protected int setImmersiveStatusBarColor() {
        return R.color.color_customs_txt;
//        return R.color.cu_config_positive_action_solid_color;
//        return 0;
//        return R.color.white;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pet_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        initFragment();
    }

    /**
     * 初始化Fragmet
     **/
    private FragmentManager mFragmentManager;
    private Fragment tempFragment;
    private void initFragment() {
        petHomeFragment = PetHomeFragment.newInstance();
        petCategoryFragment = PetCategoryFragment.newInstance();
        petUnionFragment = PetUnionFragment.newInstance();
        petShopCartFragment = PetShopCartFragment.newInstance();
        petPersonalFragment = PetPersonalFragment.newInstance();

        iv_list = new ArrayList<>();
        iv_list.add(ivCheckImage);
        iv_list.add(ivProfileImage);
        iv_list.add(ivUnion);
        iv_list.add(ivShopcart);
        iv_list.add(ivPersonal);
        changePageSelect(0);
        changePageFragment(R.id.ll_bottom_bar_check);
        mFragmentManager = getSupportFragmentManager();
        tempFragment = petHomeFragment;
        //开启事务
        mFragmentManager.beginTransaction().add(R.id.fragment_records_content,tempFragment).commitAllowingStateLoss();
    }


    @Override
    protected void initData() {
    }

    @Override
    protected void initListener() {
        llCheck.setOnClickListener(this);
        llProfile.setOnClickListener(this);
        llUnion.setOnClickListener(this);
        llShopcart.setOnClickListener(this);
        llPersonal.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_bottom_bar_check:
                switchFragment(petHomeFragment);
                break;
            case R.id.ll_bottom_bar_profile:
                switchFragment(petCategoryFragment);
                break;
            case R.id.ll_bottom_bar_union:
                switchFragment(petUnionFragment);
                break;
            case R.id.ll_bottom_bar_shopcart:
                switchFragment(petShopCartFragment);
                break;
            case R.id.ll_bottom_bar_personal:
                switchFragment(petPersonalFragment);
                break;
        }
        changePageFragment(v.getId());
    }
    /**
     * 选中的tab和没有选中的tab的图标和字体颜色
     * @param index
     */
    public void changePageSelect(int index) {
        for (int i = 0; i < iv_list.size(); i++) {
            if (index == i) {
//                tv_list.get(i).setTextColor(getResources().getColor(R.color.red));
                if (i == 0){
                    iv_list.get(i).setImageResource(R.drawable.main_tab_home_sel);
                }else if ( i== 1){
                    iv_list.get(i).setImageResource(R.drawable.main_tab_category_sel);
                }else if ( i== 2){
                    iv_list.get(i).setImageResource(R.drawable.main_tab_union_sel);
                }else if ( i== 3){
                    iv_list.get(i).setImageResource(R.drawable.main_tab_shopcart_sel);
                }else if ( i== 4){
                    iv_list.get(i).setImageResource(R.drawable.main_tab_personal_sel);
                }
            } else {
//                tv_list.get(i).setTextColor(getResources().getColor(R.color.white));
                if (i == 0){
                    iv_list.get(i).setImageResource(R.drawable.main_tab_home);
                }else if ( i== 1){
                    iv_list.get(i).setImageResource(R.drawable.main_tab_category);
                }else if ( i== 2){
                    iv_list.get(i).setImageResource(R.drawable.main_tab_union);
                }else if ( i== 3){
                    iv_list.get(i).setImageResource(R.drawable.main_tab_shopcart);
                }else if ( i== 4){
                    iv_list.get(i).setImageResource(R.drawable.main_tab_personal);
                }
            }
        }
    }

    /**
     * 当点击导航栏时改变 fragment
     * @param id
     */
    public void changePageFragment(int id) {
        if (id == R.id.ll_bottom_bar_check){
            if (petHomeFragment == null) {//减少new fragmnet,避免不必要的内存消耗
                petHomeFragment = PetHomeFragment.newInstance();
            }
            changePageSelect(0);
        }else  if (id == R.id.ll_bottom_bar_profile){
            if (petCategoryFragment == null) {
                petCategoryFragment = PetCategoryFragment.newInstance();
            }
            changePageSelect(1);
        }else  if (id == R.id.ll_bottom_bar_union){
            if (petUnionFragment == null) {
                petUnionFragment = PetUnionFragment.newInstance();
            }
            changePageSelect(2);
        }else  if (id == R.id.ll_bottom_bar_shopcart){
            if (petShopCartFragment == null) {
                petShopCartFragment = PetShopCartFragment.newInstance();
            }
            changePageSelect(3);
        }else  if (id == R.id.ll_bottom_bar_personal){
            if (petPersonalFragment == null) {
                petPersonalFragment = PetPersonalFragment.newInstance();
            }
            changePageSelect(4);
        }
    }

    /**
     * 切换页签
     **/
    public void switchFragment(Fragment fragment) {
        if (fragment != tempFragment) {
            if (!fragment.isAdded()) {
                mFragmentManager.beginTransaction().hide(tempFragment).add(R.id.fragment_records_content, fragment).commitAllowingStateLoss();
            } else {
                mFragmentManager.beginTransaction().hide(tempFragment).show(fragment).commitAllowingStateLoss();
            }
            tempFragment = fragment;
        }
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
        }
        return super.onOptionsItemSelected(item);
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

    @Override
    protected void onDestroy() {
        // 直接移除，定时器停止
//        handler.removeMessages(0);
        super.onDestroy();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            if (resultCode == Constants.ACTIVITY_RESULT_CODE_1) {
                if (petHomeFragment != null) {//减少new fragmnet,避免不必要的内存消耗
                    petHomeFragment.onActivityResult(requestCode, resultCode, data);
                }
            }
        }

    }

    @Override
    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        Jzvd.releaseAllVideos();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Jzvd.setMediaInterface(new JZMediaSystem());
            }
        }, 1000);
        super.onBackPressed();
    }
}