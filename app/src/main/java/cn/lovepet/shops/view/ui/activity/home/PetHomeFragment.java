package cn.lovepet.shops.view.ui.activity.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import cn.lovepet.shops.R;
import cn.lovepet.shops.base.BaseFragment;
import cn.lovepet.shops.base.Constants;
import cn.lovepet.shops.util.ILog;
import cn.lovepet.shops.view.EpetTypeSwitchView;
import cn.lovepet.shops.view.adapter.MyViewPageAdapter;
import cn.lovepet.shops.view.ui.activity.home.tab.PetMessageActivity;
import cn.lovepet.shops.view.ui.activity.home.tab.SearchQueryActivity;
import cn.lovepet.shops.view.ui.activity.home.tab.SiteAndPositionActivity;
import cn.lovepet.shops.view.ui.activity.home.tab.TabMajorFoodstuffFragment;
import cn.lovepet.shops.view.ui.activity.home.tab.TabHomeFragment;
import cn.lovepet.shops.view.ui.activity.home.tab.TabSnacksFragment;
import cn.lovepet.shops.view.widget.SimpleNoScrollViewPager;


/**
 * 首页
 *
 * @author JSYL-DCL
 * @date 2018/8/24 13:58
 * @des
 */
public class PetHomeFragment extends BaseFragment {

    private final String TAG = PetHomeFragment.class.getSimpleName();
    private Context _context;
    @BindView(R.id.epetTypeSwitchView)
    EpetTypeSwitchView epetTypeSwitchView;
    @BindView(R.id.viewpager22)
    SimpleNoScrollViewPager mViewpager;
    @BindView(R.id.homeTab)
    TabLayout mHomeTab;
    @BindView(R.id.tvAreaResult)
    TextView mTvAreaResult;
    //顶部：站+位置
    @BindView(R.id.llPosition)
    LinearLayout llPosition;

    public PetHomeFragment() {
    }

    public static PetHomeFragment newInstance() {
        PetHomeFragment fragment = new PetHomeFragment();
        return fragment;
    }

    @Override
    protected int setImmersiveStatusBarColor() {
        return 0;
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_pet_home;
    }

    @Override
    protected void init() {
    }

    @Override
    protected void bindView() {
        _context = getActivity();
        epetTypeSwitchView = new EpetTypeSwitchView(getActivity());
//        mViewpager.setScroll(false);
//        String str = "您没有<font color='#03A9F4'>事故报警</font>菜单访问权限";
//        String str1 = "您没有<font color='#03A9F4'>我的工单</font>菜单访问权限";
//        tvHomeText.setText(Html.fromHtml(str) +"\n"+ Html.fromHtml(str1));


        ArrayList<String> titleDatas = new ArrayList<>();
        titleDatas.add("首页");
        titleDatas.add("");
        titleDatas.add("狗狗主粮");
        titleDatas.add("狗狗零食");
        titleDatas.add("医疗保健");
        titleDatas.add("玩具");
        titleDatas.add("外出");

        ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new TabHomeFragment());
        fragmentList.add(new TabMajorFoodstuffFragment());
        fragmentList.add(new TabMajorFoodstuffFragment());
        fragmentList.add(new TabSnacksFragment());
        fragmentList.add(new TabMajorFoodstuffFragment());
        fragmentList.add(new TabMajorFoodstuffFragment());
        fragmentList.add(new TabMajorFoodstuffFragment());
        MyViewPageAdapter myViewPageAdapter = new MyViewPageAdapter(getActivity().getSupportFragmentManager(), titleDatas, fragmentList);
        mViewpager.setAdapter(myViewPageAdapter);
        mViewpager.setOffscreenPageLimit(2);//设置ViewPage缓存界面数
        mHomeTab.setupWithViewPager(mViewpager);
        mHomeTab.setTabsFromPagerAdapter(myViewPageAdapter);
//        tlCoupon.getTabAt(1).set(R.mipmap.d111);
        mHomeTab.getTabAt(1).setCustomView(getTabView(1));
    }

    private View getTabView(int i) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.view_tab, null);
        ImageView viewById = (ImageView) inflate.findViewById(R.id.ivTabBg);
        if (i == 1) {
            viewById.setImageResource(R.mipmap.tab11bg);
        } else {
            viewById.setImageResource(R.mipmap.tab11bg);
        }
        return inflate;
    }

    @Override
    protected void bindData(Bundle savedInstanceState) {
    }

    @Override
    protected void bindListener() {

    }

    @OnClick({
            R.id.llPosition
            , R.id.llSearch
            , R.id.ivMessageNormal

    })
    public void bindViewClick(View view) {
        switch (view.getId()) {
            case R.id.llPosition://站+位置
                getActivity().startActivityForResult((new Intent(getActivity(), SiteAndPositionActivity.class)), Constants.ACTIVITY_REQUEST_CODE_1);
//                SiteAndPositionActivity.getInstance(getActivity());
                break;
            case R.id.llSearch://搜索查询
                SearchQueryActivity.getInstance(getActivity());
                break;
            case R.id.ivMessageNormal://消息
                PetMessageActivity.getInstance(getActivity());
                break;
        }
    }

    /**
     * 接收附属上级界面传值
     * @param requestCode
     * @param resultCode
     * @param data
     */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        String areaName = data.getStringExtra("areaName");
        int areaId = data.getIntExtra("areaId",500);
        //地点
        mTvAreaResult.setText(areaName);


//        if (requestCode == Constants.ACTIVITY_REQUEST_CODE_1) {
//            if (resultCode == Constants.ACTIVITY_RESULT_CODE_1) {
//                if (data != null) {
//                    String areaName = data.getStringExtra("areaName");
//                    int areaId = data.getIntExtra("areaId",500);
//                    //地点
//                    mTvAreaResult.setText(areaName);
//                }
//            }
//        }
    }
}
