package cn.lovepet.shops.view.ui.activity.shopcart;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import butterknife.BindArray;
import butterknife.BindView;
import cn.lovepet.shops.R;
import cn.lovepet.shops.base.BaseFragment;
import cn.lovepet.shops.helper.immersive.title.OnTitleBarListener;
import cn.lovepet.shops.helper.immersive.title.TitleBar;
import cn.lovepet.shops.helper.immersive.title.style.TitleBarLightStyle;
import cn.lovepet.shops.util.ApplicationUtil;
import cn.lovepet.shops.util.ILog;
import cn.lovepet.shops.util.ToastsUtils;


/**
 * 购物车
 * @author JSYL-DCL
 * @date 2018/8/24 13:58
 * @des
 */
public class PetShopCartFragment extends BaseFragment {

    private final String TAG = PetShopCartFragment.class.getSimpleName();
    private Context _context;
    //标题栏
    @BindView(R.id.shopcart_title_bar)
    TitleBar mTitleBar;
    //标题栏
    @BindArray(R.array.pet_main_title)
    String[] mTitles;
    public PetShopCartFragment() {
    }
    public static PetShopCartFragment newInstance() {
        PetShopCartFragment fragment = new PetShopCartFragment();
        return fragment;
    }

    @Override
    protected int setImmersiveStatusBarColor() {
        return R.color.white;
//        return R.color.cu_config_positive_action_solid_color;
//        return 0;
//        return R.color.white;
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_pet_shopcart;
    }

    @Override
    protected void init() {
    }

    @Override
    protected void bindView() {
        _context = getActivity();
        mTitleBar.setTitle("购物车");
        initTitleBarStyle();
    }
    @Override
    protected void bindData(Bundle savedInstanceState) {
    }
    @Override
    protected void bindListener() {

    }


    private void initTitleBarStyle() {
        if (setImmersiveStatusBarColor() != 0) {
            mTitleBar.setBackgroundResource(setImmersiveStatusBarColor());
        }else{
            mTitleBar.setBackgroundResource(R.color.white);
        }
        mTitleBar.setTitleColor(getMyActivity().getResources().getColor(R.color.color_super_value_text_sale_price));
        mTitleBar.setBackgroundResource(R.color.white);
        mTitleBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onLeftClick(View v) {
                Toast.makeText(getActivity(), "左项被点击", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onTitleClick(View v) {
                Toast.makeText(getActivity(), "标题被点击", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onRightClick(View v) {
                Toast.makeText(getActivity(), "编辑", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
