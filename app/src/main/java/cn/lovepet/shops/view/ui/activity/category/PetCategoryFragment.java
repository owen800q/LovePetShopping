package cn.lovepet.shops.view.ui.activity.category;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import cn.lovepet.shops.R;
import cn.lovepet.shops.base.BaseFragment;
import cn.lovepet.shops.view.adapter.MyViewPageAdapter;
import cn.lovepet.shops.view.ui.activity.home.tab.SearchQueryActivity;


/**
 * 分类
 * @author JSYL-DCL
 * @date 2018/8/24 13:58
 * @des
 */
public class PetCategoryFragment extends BaseFragment {
    private final String TAG = PetCategoryFragment.class.getSimpleName();
    private Context _context;
    @BindView(R.id.categaryTab)
    TabLayout mCategaryTab;
    @BindView(R.id.categaryViewPager)
    ViewPager mViewpager;
    @BindView(R.id.llCategorySearch)
    RelativeLayout mLlCategorySearch;
    public PetCategoryFragment() {
    }
    public static PetCategoryFragment newInstance() {
        PetCategoryFragment fragment = new PetCategoryFragment();
        return fragment;
    }

    @Override
    protected int setImmersiveStatusBarColor() {
        return 0;
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_pet_categories;
    }

    @Override
    protected void init() {
    }

    @Override
    protected void bindView() {
        _context = getActivity();
        setTabLayout();
    }


    private void setTabLayout() {
        ArrayList<String> titleDatas = new ArrayList<>();
        titleDatas.add("分类");
        titleDatas.add("品牌");
        ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new TabCategoryMainFragment());
        fragmentList.add(new TabCategoryBrandFragment());
        MyViewPageAdapter myViewPageAdapter = new MyViewPageAdapter(getActivity().getSupportFragmentManager(), titleDatas,fragmentList);
        mViewpager.setAdapter(myViewPageAdapter);
        mViewpager.setOffscreenPageLimit(1);//设置ViewPage缓存界面数
        mCategaryTab.setupWithViewPager(mViewpager);
        mCategaryTab.setTabsFromPagerAdapter(myViewPageAdapter);
//        mCategaryTab.getTabAt(1).setCustomView(getTabView(1));
    }

    @Override
    protected void bindData(Bundle savedInstanceState) {
    }
    @Override
    protected void bindListener() {
       /* mCategaryTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position == 0){
                    mViewpager.setCurrentItem(0);
                }else if (position == 1){
                    mViewpager.setCurrentItem(1);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });*/
    }

    @OnClick({
            R.id.llCategorySearch
    })
    public void bindViewClick(View view){
        switch (view.getId()){
            case R.id.llCategorySearch:
                SearchQueryActivity.getInstance(getActivity());
                break;
        }
    }

}
