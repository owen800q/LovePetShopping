package cn.lovepet.shops.helper.popupwindow;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;

import com.github.library.BaseQuickAdapter;
import com.github.library.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import cn.lovepet.shops.R;
import cn.lovepet.shops.base.Constants;
import cn.lovepet.shops.bean.PetDogGoodsListBean;
import cn.lovepet.shops.helper.imageview.RecycleViewDivider;
import cn.lovepet.shops.util.DensityUtil;
import razerdp.basepopup.BasePopupWindow;

/**
 * 包含着listview的popup，使用builder模式，事件与tag进行绑定
 */
public class SlideFirstFilterListPopupWindow extends BasePopupWindow {
    private SimpleFilterAdaper mFilterAdaper;
    private ListView mListView;
    private OnSimpleListPopupItemClickListener mOnSimpleListPopupItemClickListener;
    public SlideFirstFilterListPopupWindow(Context context, Builder builder, final List<PetDogGoodsListBean.Sort_rank.Sort_rank_list>  filterModel) {
        super(context);
        setBackPressEnable(true);
        setAlignBackground(true);
        if (filterModel != null) {
            RecyclerView mPopupRecyclerView = (RecyclerView) findViewById(R.id.lvPopup);
            LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
            mPopupRecyclerView.setLayoutManager(layoutManager);
            //添加item分割线
            int color = context.getResources().getColor(R.color.common_divider_narrow);
            RecycleViewDivider recycleViewDivider = new RecycleViewDivider(context, layoutManager.getOrientation(), 1/2, color);
            mPopupRecyclerView.removeItemDecoration(recycleViewDivider);
            mPopupRecyclerView.addItemDecoration(recycleViewDivider);
            mPopupRecyclerView.setHasFixedSize(true);
            mPopupRecyclerView.setItemViewCacheSize(5);

            mFilterAdaper = new SimpleFilterAdaper(R.layout.item_filter, filterModel);
            mPopupRecyclerView.setAdapter(mFilterAdaper);
        }
    }

    @Override
    public View onCreateContentView() {
        return createPopupById(R.layout.popup_simple_list);
    }

    public static class Builder {
        private List<Object> mItemEventList = new ArrayList<>();
        private Activity mContext;
        private List<PetDogGoodsListBean.Sort_rank.Sort_rank_list> sort_rank_list = new ArrayList<>();
        public Builder(Activity context,List<PetDogGoodsListBean.Sort_rank.Sort_rank_list> data) {
            mContext = context;
            sort_rank_list.addAll(data);
        }

        public Builder addItem(String itemTx) {
            mItemEventList.add(itemTx);
            return this;
        }

        public Builder addItem(int clickTag, String itemTx) {
            mItemEventList.add(new clickItemEvent(clickTag, itemTx));
            return this;
        }
        public List<Object> getItemEventList() {
            return mItemEventList;
        }
        public SlideFirstFilterListPopupWindow build() {
            return new SlideFirstFilterListPopupWindow(mContext, this,sort_rank_list);
        }

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



    public class SimpleFilterAdaper extends BaseQuickAdapter<PetDogGoodsListBean.Sort_rank.Sort_rank_list, BaseViewHolder> {
        public SimpleFilterAdaper(int layoutResId, List<PetDogGoodsListBean.Sort_rank.Sort_rank_list> data) {
            super(layoutResId, data);
        }
        public SimpleFilterAdaper(List<PetDogGoodsListBean.Sort_rank.Sort_rank_list> data, int... layoutResIds) {
            super(data, layoutResIds);
        }
        @Override
        protected void convert(BaseViewHolder helper, final PetDogGoodsListBean.Sort_rank.Sort_rank_list item) {
            final int adapterPosition = helper.getAdapterPosition();
            CheckBox cbnFilter = (CheckBox) helper.getView(R.id.cbnFilter);
            cbnFilter.setText(item.getItem());
            if (TextUtils.isEmpty(Constants.POPUP_DEFAULT_SORT)) {
                if (item.getChecked() == 1) {
                    cbnFilter.setChecked(true);
                } else {
                    cbnFilter.setChecked(false);
                }
            }else {
                if (Constants.POPUP_DEFAULT_SORT.equals(item.getItem())){
                    cbnFilter.setChecked(true);
                }else {
                    cbnFilter.setChecked(false);
                }
            }
            cbnFilter.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    String trim = buttonView.getText().toString().trim();
                    if (mOnSimpleListPopupItemClickListener != null) {
                        mOnSimpleListPopupItemClickListener.onItemClick(adapterPosition,trim);
                        dismiss();
                    }
                }
            });
        }
    }




    public void setOnSimpleListPopupItemClickListener(OnSimpleListPopupItemClickListener onListPopupItemClickListener) {
        mOnSimpleListPopupItemClickListener = onListPopupItemClickListener;
    }

    public interface OnSimpleListPopupItemClickListener {
        void onItemClick(int what,String text);
    }

































//    private SlideFirstFilterListPopupWindow(Context context) {
//        super(context);
//    }
//
//    private SlideFirstFilterListPopupWindow(Context context, Builder builder, final List<String> data) {
//        this(context);
//        mListView = (ListView) findViewById(R.id.lvPopup);
//        setPopupGravity(Gravity.CENTER);
//        setClipChildren(false);
//
////        private String data[] = {"aa","bb","cc","dd","aa","bb","cc","dd","aa","bb","cc","dd","aa","bb","cc","dd"};//假数据
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,data);
//        mListView.setAdapter(adapter);
//        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if (mOnListPopupItemClickListener != null){
//                    mOnListPopupItemClickListener.onItemClick(position,data.get(position));
//                    dismiss();
//                }
//            }
//        });
//    }






    public static class clickItemEvent {
        private int clickTag;
        private String itemTx;

        public clickItemEvent(int clickTag, String itemTx) {
            this.clickTag = clickTag;
            this.itemTx = itemTx;
        }

        public int getClickTag() {
            return clickTag;
        }

        public void setClickTag(int clickTag) {
            this.clickTag = clickTag;
        }

        public String getItemTx() {
            return itemTx;
        }

        public void setItemTx(String itemTx) {
            this.itemTx = itemTx;
        }
    }



    @Override
    public Animator onCreateShowAnimator() {
        AnimatorSet set = new AnimatorSet();
        set.playTogether(ObjectAnimator.ofFloat(getDisplayAnimateView(), "rotationX", 90f, 0f).setDuration(400),
                ObjectAnimator.ofFloat(getDisplayAnimateView(), "translationY", 250f, 0f).setDuration(400),
                ObjectAnimator.ofFloat(getDisplayAnimateView(), "alpha", 0f, 1f).setDuration(400 * 3 / 2));
        return set;
    }



    @Override
    public Animator onCreateDismissAnimator() {
        AnimatorSet set = new AnimatorSet();
        set.playTogether(ObjectAnimator.ofFloat(getDisplayAnimateView(), "rotationX", 0f, 90f).setDuration(400),
                ObjectAnimator.ofFloat(getDisplayAnimateView(), "translationY", 0f, 250f).setDuration(400),
                ObjectAnimator.ofFloat(getDisplayAnimateView(), "alpha", 1f, 0f).setDuration(400 * 3 / 2));
        return set;
    }
}
