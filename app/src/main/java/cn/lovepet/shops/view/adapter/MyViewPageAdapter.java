package cn.lovepet.shops.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JSYL-DCL
 * @date 2018/10/29 10:44
 * @des
 */
public class MyViewPageAdapter extends FragmentPagerAdapter {
    private List<String> titleList;
    private ArrayList<Fragment> fragmentList;
    public MyViewPageAdapter(FragmentManager fm, List<String> titleList, ArrayList<Fragment> fragmentList) {
        super(fm);
        this.titleList = titleList;
        this.fragmentList = fragmentList;
    }
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }
    @Override
    public int getCount() {
        return fragmentList.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        if (titleList != null) {
            return titleList.get(position);
        }else {
            return null;
        }
    }
}