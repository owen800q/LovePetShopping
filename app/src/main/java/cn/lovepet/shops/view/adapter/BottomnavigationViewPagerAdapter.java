package cn.lovepet.shops.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by dingcl on 2018/08.
 */
public class BottomnavigationViewPagerAdapter extends FragmentPagerAdapter {
//public class BottomnavigationViewPagerAdapter extends FragmentStatePagerAdapter {

    //fragment 集合
    private List<Fragment> fragments;

    public BottomnavigationViewPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;

    }
    //返回 fragments 中的一个 Fragment
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }


    //Fragment数量
    @Override
    public int getCount() {
        return  fragments.size();
    }



}
