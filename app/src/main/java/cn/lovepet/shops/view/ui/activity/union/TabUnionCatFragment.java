package cn.lovepet.shops.view.ui.activity.union;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import cn.lovepet.shops.R;
import cn.lovepet.shops.base.BaseFragment;

/**
 * @author JSYL-DCL
 * @date 2018/10/29 10:50
 * @des 联盟-猫猫
 */
public class TabUnionCatFragment extends BaseFragment {
    private static final String TAG1 = TabUnionCatFragment.class.getSimpleName();
    private String[] subTabs = new String[]{"精选","运动","香水","健康","玩耍","食品","窝点","饲养","训练"};
    private int[] subTabIcons = new int[]{R.mipmap.all,R.mipmap.all,R.mipmap.all,R.mipmap.all,
                                          R.mipmap.all, R.mipmap.all,R.mipmap.all,R.mipmap.all,
                                          R.mipmap.all};
    @BindView(R.id.tablayout)
    TabLayout mTabLayout;

    @Override
    protected int setImmersiveStatusBarColor() {
        return 0;
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_union_cat_item;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void bindView() {
        for(int i=0;i<subTabs.length;i++){
            mTabLayout.addTab(mTabLayout.newTab());
//            mTabLayout.getTabAt(i).setText(subTabs[i]);
            mTabLayout.getTabAt(i).setCustomView(makeTabView(i));
        }
    }

    @Override
    protected void bindData(Bundle savedInstanceState) {

    }

    @Override
    protected void bindListener() {

    }

    /**
     * 引入布局设置图标和标题
     * @param position
     * @return
     */
    private View makeTabView(int position){
        View tabView = LayoutInflater.from(getActivity()).inflate(R.layout.tab_text_icon,null);
        TextView customTextview = tabView.findViewById(R.id.customTextview);
        ImageView customImageview = tabView.findViewById(R.id.customImageview);
        customTextview.setText(subTabs[position]);
        customImageview.setImageResource(subTabIcons[position]);
        return tabView;
    }
}