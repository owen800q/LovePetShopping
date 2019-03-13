package cn.lovepet.shops.helper.popupwindow;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;

import com.github.library.BaseQuickAdapter;
import com.github.library.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import cn.lovepet.shops.R;
import cn.lovepet.shops.base.Constants;
import cn.lovepet.shops.bean.PetDogGoodsListBean;
import cn.lovepet.shops.util.AnimationUtils;
import cn.lovepet.shops.util.DensityUtil;
import razerdp.basepopup.BasePopupWindow;
import razerdp.util.SimpleAnimationUtils;

/**
 * 从顶部下滑的Poup
 */
public class SlideSecondFilterPopupWindow extends BasePopupWindow {
    private BaseQuickAdapter mFilterAdaper;
    private OnListPopupItemClickListener mOnListPopupItemClickListener;
    private int mFilterTypeInt;
    private int ischecked = 200;
    private String typeItemName = "";
    public SlideSecondFilterPopupWindow(Context context, final PetDogGoodsListBean.FilterBoxData filterModel, int filterTypeInt) {
        super(context);
        setBackPressEnable(true);
        setAlignBackground(true);
//        setPopupGravity(Gravity.RIGHT).setShowAnimation(SimpleAnimationUtils.getTranslateHorizontalAnimation(RelativeLayout.ALIGN_PARENT_RIGHT,0,500))
//                    .setDismissAnimation(SimpleAnimationUtils.getTranslateHorizontalAnimation(0,RelativeLayout.ALIGN_PARENT_RIGHT,500));
        if (filterModel != null) {
            List<PetDogGoodsListBean.FilterBoxData.Rows> rows = filterModel.getRows();
            RecyclerView mPopupRecyclerView = (RecyclerView) findViewById(R.id.popupRecyclerView);
            mPopupRecyclerView.setLayoutManager(new GridLayoutManager(context, 3));
            mPopupRecyclerView.setHasFixedSize(true);
            mPopupRecyclerView.setItemViewCacheSize(10);
            mFilterAdaper = new FilterAdaper(R.layout.item_filter, rows);
            mPopupRecyclerView.setAdapter(mFilterAdaper);
        }
        mFilterTypeInt = filterTypeInt;


    }

    @Override
    public View onCreateContentView() {
        return createPopupById(R.layout.popup_select_from_top);
    }

    @Override
    protected Animation onCreateShowAnimation() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0f, 0f, - DensityUtil.dip2px(getContext(), 350), 0);
        translateAnimation.setDuration(450);
        translateAnimation.setInterpolator(new OvershootInterpolator(1));
        return translateAnimation;
    }

    @Override
    protected Animation onCreateDismissAnimation() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0f, 0f, 0, - DensityUtil.dip2px(getContext(), 350));
        translateAnimation.setDuration(450);
        translateAnimation.setInterpolator(new OvershootInterpolator(-4));
        return translateAnimation;
    }



    public class FilterAdaper extends BaseQuickAdapter<PetDogGoodsListBean.FilterBoxData.Rows, BaseViewHolder> {
        public FilterAdaper(int layoutResId, List<PetDogGoodsListBean.FilterBoxData.Rows> data) {
            super(layoutResId, data);
        }
        public FilterAdaper(List<PetDogGoodsListBean.FilterBoxData.Rows> data, int... layoutResIds) {
            super(data, layoutResIds);
        }
        @Override
        protected void convert(BaseViewHolder helper, final PetDogGoodsListBean.FilterBoxData.Rows item) {
            final int adapterPosition = helper.getAdapterPosition();
            CheckBox cbnFilter = (CheckBox) helper.getView(R.id.cbnFilter);
            if (mFilterTypeInt == 0){
                PetDogGoodsListBean.FilterBoxData.Rows.Items items = item.getItems().get(0);
                cbnFilter.setText(items.getName());
                ischecked = items.getChecked();
            }else {
                ischecked = item.getChecked();
                cbnFilter.setText(item.getName());
            }
            if (mFilterTypeInt == 0){//品牌
                setCheckedContent(Constants.POPUP_BRAND_SELECTED,ischecked,cbnFilter,item.getItems().get(0).getName());
            }else if (mFilterTypeInt == 1){//年龄
                setCheckedContent(Constants.POPUP_AGE_SELECTED,ischecked,cbnFilter,item.getName());
            }else if (mFilterTypeInt == 2){//体型
                setCheckedContent(Constants.POPUP_BODY_SELECTED,ischecked,cbnFilter,item.getName());
            }else if (mFilterTypeInt == 3){//颗粒大小
                setCheckedContent(Constants.POPUP_KELISIZE_SELECTED,ischecked,cbnFilter,item.getName());
            }

            cbnFilter.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    String trim = buttonView.getText().toString().trim();
                    if (mOnListPopupItemClickListener != null) {
                        mOnListPopupItemClickListener.onItemClick(adapterPosition,trim,mFilterTypeInt);
                        dismiss();
                    }
                }
            });

        }
    }


    /**
     * 设置选中
     * @param popupBrandSelected
     * @param ischecked
     * @param cbnFilter
     * @param item
     */
    String selectText = "";
    private void setCheckedContent(String popupSelected, int ischecked, CheckBox cbnFilter, String name) {
        if (TextUtils.isEmpty(popupSelected)){
            if (ischecked == 0) {
                cbnFilter.setChecked(false);
            } else if (ischecked == 1) {
                cbnFilter.setChecked(true);
            } else {
                cbnFilter.setChecked(false);
            }
        }else {
            if (popupSelected.equals(name)){
                cbnFilter.setChecked(true);
            }else {
                cbnFilter.setChecked(false);
            }
        }
    }


    public void setOnListPopupItemClickListener(OnListPopupItemClickListener onListPopupItemClickListener) {
        mOnListPopupItemClickListener = onListPopupItemClickListener;
    }

    public interface OnListPopupItemClickListener {
        void onItemClick(int what,String text,int filterType);
    }


}
