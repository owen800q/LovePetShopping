package cn.lovepet.shops.helper.popupwindow;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.github.library.BaseQuickAdapter;
import com.github.library.BaseViewHolder;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import cn.lovepet.shops.R;
import cn.lovepet.shops.base.Constants;
import cn.lovepet.shops.bean.PetDogGoodsListBean;
import cn.lovepet.shops.helper.imageview.RecycleViewDivider;
import cn.lovepet.shops.util.AnimationUtils;
import cn.lovepet.shops.util.DensityUtil;
import cn.lovepet.shops.util.ILog;
import cn.lovepet.shops.util.ToastsUtils;
import cn.lovepet.shops.view.ui.activity.category.TabCategoryMainFragment;
import cn.lovepet.shops.view.widget.SmoothScrollLayoutManager;
import razerdp.basepopup.BasePopupWindow;

/**
 * 从顶部下滑的Poup
 */
public class SlideFirstAllFilterPopupWindow<T> extends BasePopupWindow {
    private static final java.lang.String TAG1 = "SlideFirstAllFilterPopupWindow";
    private BaseQuickAdapter mFilterAdaper;
    private OnAllFilterPopupItemClickListener mOnAllFilterPopupItemClickListener;
    private int ischecked = 200;
    private LeftMenuAdapter mLeftAdapter;
    private RightListAdapter mRightAdapter;
    private ArrayList<String> leftlist;
    private ArrayList<String> rightList;
    private List<PetDogGoodsListBean.FilterBoxData> modellist;
    private RecyclerView mLeftRecyclerView;
    private RecyclerView mRightRecyclerView;
    //目标项是否在最后一个可见项之后
    private boolean mShouldScroll;
    //记录目标项位置
    private int mToPosition;

    public Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int obj = (int) msg.obj;
            Constants.POPUP_LEFT_SELECTED = obj;
            getRightListData(obj);
        }
    };

    public SlideFirstAllFilterPopupWindow(Context context,Builder builder, final List<PetDogGoodsListBean.FilterBoxData> modelList) {
        super(context);
        setBackPressEnable(true);
        setAlignBackground(true);
        int height = getHeight();
        setShowAnimation(AnimationUtils.inFromRightAnimation(150))
                    .setDismissAnimation(AnimationUtils.outToRightAnimation(150));
//        setPopupGravity(Gravity.RIGHT).setShowAnimation(SimpleAnimationUtils.getTranslateHorizontalAnimation(RelativeLayout.ALIGN_PARENT_RIGHT,0,500))
//                    .setDismissAnimation(SimpleAnimationUtils.getTranslateHorizontalAnimation(0,RelativeLayout.ALIGN_PARENT_RIGHT,500));
//        if (rows != null) {
//            RecyclerView mPopupRecyclerView = (RecyclerView) findViewById(R.id.popupRecyclerView);
//            mPopupRecyclerView.setLayoutManager(new GridLayoutManager(context, 3));
//            mPopupRecyclerView.setHasFixedSize(true);
//            mPopupRecyclerView.setItemViewCacheSize(10);
//            mFilterAdaper = new FilterAdaper(R.layout.item_filter, rows);
//            mPopupRecyclerView.setAdapter(mFilterAdaper);
        mLeftRecyclerView = (RecyclerView) findViewById(R.id.classic_recycle);
        mRightRecyclerView = (RecyclerView) findViewById(R.id.rightRecyclerView);
        Button mBtnSure = (Button) findViewById(R.id.btn_sure);
        Button mBtnClearSelect = (Button) findViewById(R.id.btn_clear_select);
        TextView mTvTotal = (TextView) findViewById(R.id.tvTotal);
//        }
        if (leftlist != null)leftlist.clear();
        else leftlist = new ArrayList<>();
        if (rightList != null)rightList.clear();
        else rightList = new ArrayList<>();
        if (modellist != null)modellist.clear();
        else modellist = new ArrayList<>();
        setLeftMenu(context,modelList);
        setRightList(context);
        modellist.addAll(modelList);

        mBtnSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        mBtnClearSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastsUtils.showShort("重置");
            }
        });

    }

    /**
     * 设置左侧菜单数据
     * @param context
     * @param modelList
     */
    private void setLeftMenu(Context context, List<PetDogGoodsListBean.FilterBoxData> modelList) {
        SmoothScrollLayoutManager layoutManager = new SmoothScrollLayoutManager(context);
        mLeftRecyclerView.setLayoutManager(layoutManager);
        mLeftRecyclerView.setHasFixedSize(true);
        //添加item分割线
        int color = context.getResources().getColor(R.color.lightgray1);
        RecycleViewDivider recycleViewDivider = new RecycleViewDivider(context, layoutManager.getOrientation(), 1, color);
        mLeftRecyclerView.removeItemDecoration(recycleViewDivider);
        mLeftRecyclerView.addItemDecoration(recycleViewDivider);
//        mLaunchRecyclerView.setItemViewCacheSize(10);
        mLeftAdapter = new LeftMenuAdapter(leftlist,R.layout.item_category_main_left_menu);
        //防止数据错乱
        mLeftAdapter.setHasStableIds(true);
        mLeftRecyclerView.setAdapter(mLeftAdapter);
        getLeftMenuData(modelList);
    }

    /**
     * 右侧列表数据适配器
     */
    public class RightListAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
        public RightListAdapter(int layoutResId, List<String> data) {
            super(layoutResId, data);
        }
        public RightListAdapter(List<String> data, int... layoutResIds) {
            super(data, layoutResIds);
        }
        @Override
        protected void convert(final BaseViewHolder helper, final String item) {
            final int position = helper.getAdapterPosition();
            final AppCompatCheckBox cbnContentView = (AppCompatCheckBox) helper.getView(R.id.cbnContentView);
            cbnContentView.setText(item);
            if (modellist != null){
                if (Constants.POPUP_LEFT_SELECTED != 100) {
                    if (Constants.POPUP_LEFT_SELECTED == 0){
                        int checked = modellist.get(Constants.POPUP_LEFT_SELECTED).getRows().get(position).getItems().get(0).getChecked();
                        if (0 == checked){
                            cbnContentView.setChecked(false);
                        }else if (1 == checked){
                            cbnContentView.setChecked(true);
                        }
                    }else{
                        int checked = modellist.get(Constants.POPUP_LEFT_SELECTED).getRows().get(position).getChecked();
                        if (0 == checked){
                            cbnContentView.setChecked(false);
                        }else if (1 == checked){
                            cbnContentView.setChecked(true);
                        }
                    }
                }
            }

//            if (item.equals(Constants.POPUP_RIGHT_SELECTED_0) || item.equals(Constants.POPUP_RIGHT_SELECTED_1) ||
//                item.equals(Constants.POPUP_RIGHT_SELECTED_2) || item.equals(Constants.POPUP_RIGHT_SELECTED_2) ||
//                item.equals(Constants.POPUP_RIGHT_SELECTED_4) || item.equals(Constants.POPUP_RIGHT_SELECTED_5) ||
//                item.equals(Constants.POPUP_RIGHT_SELECTED_6)){
//                cbnContentView.setChecked(true);
//            } else {
//                cbnContentView.setChecked(false);
//            }
            cbnContentView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    String trim = buttonView.getText().toString().trim();
//                    if (0 == Constants.POPUP_LEFT_SELECTED) Constants.POPUP_RIGHT_SELECTED_0 = trim;
//                    if (1 == Constants.POPUP_LEFT_SELECTED) Constants.POPUP_RIGHT_SELECTED_1 = trim;
//                    if (2 == Constants.POPUP_LEFT_SELECTED) Constants.POPUP_RIGHT_SELECTED_2 = trim;
//                    if (3 == Constants.POPUP_LEFT_SELECTED) Constants.POPUP_RIGHT_SELECTED_3 = trim;
//                    if (4 == Constants.POPUP_LEFT_SELECTED) Constants.POPUP_RIGHT_SELECTED_4 = trim;
//                    if (5 == Constants.POPUP_LEFT_SELECTED) Constants.POPUP_RIGHT_SELECTED_5 = trim;
//                    if (6 == Constants.POPUP_LEFT_SELECTED) Constants.POPUP_RIGHT_SELECTED_6 = trim;
                }
            });
        }
    }

    /**
     * 左侧导航列表数据适配器
     */
    private SparseBooleanArray mBooleanArray;
    public class LeftMenuAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
        public LeftMenuAdapter(int layoutResId, List<String> data) {
            super(layoutResId, data);
        }
        public LeftMenuAdapter(List<String> data, int... layoutResIds) {
            super(data, layoutResIds);
        }
        @Override
        protected void convert(final BaseViewHolder helper, final String item) {

            final int position = helper.getAdapterPosition();
            PetDogGoodsListBean.FilterBoxData filterBoxData = modellist.get(position);
            final int flag = filterBoxData.getFlag();
            final TextView tvLeftMenuName = (TextView) helper.getView(R.id.tvLeftMenuName);
            tvLeftMenuName.setText(item);
            if (mBooleanArray.get(position)) {
                helper.setBackgroundColor(R.id.tvLeftMenuName, Color.parseColor("#FFFFFF"));
//                helper.setTextColor(R.id.tvLeftMenuName,Color.parseColor("#FF0000"));
            } else {
                helper.setBackgroundColor(R.id.tvLeftMenuName, Color.parseColor("#F6F6F6"));
//                helper.setTextColor(R.id.tvLeftMenuName,Color.parseColor("#212121"));
            }

            tvLeftMenuName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    ToastsUtils.showShort("第"+position+"个，"+modellist.get(position).getName());
                    Constants.POPUP_LEFT_SELECTED = position;
                    setItemChecked(helper.getAdapterPosition());
                    if (position == flag){
                        sendMsg(flag);
                    }
                }
            });
        }
    }

    private void setRightList(Context context) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        mRightRecyclerView.setLayoutManager(layoutManager);
        mRightRecyclerView.setHasFixedSize(true);
        //添加item分割线
        int color = context.getResources().getColor(R.color.lightgray1);
        RecycleViewDivider recycleViewDivider = new RecycleViewDivider(context, layoutManager.getOrientation(), 1, color);
        mRightRecyclerView.removeItemDecoration(recycleViewDivider);
        mRightRecyclerView.addItemDecoration(recycleViewDivider);
        mRightRecyclerView.setItemViewCacheSize(10);
        mRightAdapter = new RightListAdapter(R.layout.item_indexex_hot_layout,rightList);
        //防止数据错乱
        mRightAdapter.setHasStableIds(true);
        mRightRecyclerView.setAdapter(mRightAdapter);
//        getRightListData(listType);
    }



    /**
     * @param position
     */
    private int mLastCheckedPosition = -1;
    public void setItemChecked(int position) {
        if (mLastCheckedPosition == position)
            return;

        mBooleanArray.put(position, true);
        if (position != 0){
            mBooleanArray.put(0, false);
        }else {
        }
        if (mLastCheckedPosition > -1) {
            mBooleanArray.put(mLastCheckedPosition, false);
            //平滑
            smoothMoveToPosition(mLeftRecyclerView,position);
            mLeftAdapter.notifyItemChanged(mLastCheckedPosition);
        }
        mLeftAdapter.notifyDataSetChanged();
        mLastCheckedPosition = position;
    }

    /**
     * 滑动到指定位置
     */
    private void smoothMoveToPosition(RecyclerView mRecyclerView, final int position) {
        // 第一个可见位置
        int firstItem = mRecyclerView.getChildLayoutPosition(mRecyclerView.getChildAt(0));
        // 最后一个可见位置
        int lastItem = mRecyclerView.getChildLayoutPosition(mRecyclerView.getChildAt(mRecyclerView.getChildCount() - 1));
        if (position < firstItem) {
            // 第一种可能:跳转位置在第一个可见位置之前
            mRecyclerView.smoothScrollToPosition(position);
        } else if (position <= lastItem) {
            // 第二种可能:跳转位置在第一个可见位置之后
            int movePosition = position - firstItem;
            if (movePosition >= 0 && movePosition < mRecyclerView.getChildCount()) {
                int top = mRecyclerView.getChildAt(movePosition).getTop();
                mRecyclerView.smoothScrollBy(0, top);
            }
        } else {
            // 第三种可能:跳转位置在最后可见项之后
            mRecyclerView.smoothScrollToPosition(position);
            mToPosition = position;
            mShouldScroll = true;
        }

    }



    public void getLeftMenuData(List<PetDogGoodsListBean.FilterBoxData> modelList) {
        ILog.e(TAG1,"[getLeftMenuData] modelList:"+new Gson().toJson(modelList));
        if (leftlist != null)leftlist.clear();
        else leftlist = new ArrayList<>();
        if (modelList != null && modelList.size() > 0){
            for (PetDogGoodsListBean.FilterBoxData b: modelList) {
                leftlist.add(b.getName());
            }
        }
        mBooleanArray = new SparseBooleanArray(leftlist.size());
        mBooleanArray.put(0, true);
        mLeftAdapter.notifyDataSetChanged();
        sendMsg(0);
    }


    public void getRightListData(int obj) {
        if (rightList != null)rightList.clear();
        else rightList = new ArrayList<>();
        if (modellist != null && modellist.size() > 0){
            PetDogGoodsListBean.FilterBoxData filterBoxData = modellist.get(obj);
            if (0 == obj) {
                List<PetDogGoodsListBean.FilterBoxData.Rows> rows = filterBoxData.getRows();
                for (PetDogGoodsListBean.FilterBoxData.Rows c : rows) {
                    rightList.add(c.getItems().get(0).getName());
                }
            }else {
                for (PetDogGoodsListBean.FilterBoxData.Rows c : filterBoxData.getRows()) {
                    rightList.add(c.getName());
                }
            }
        }else {
            if (rightList != null)rightList.clear();
        }
        mRightAdapter.notifyDataSetChanged();
//        mRightRecyclerView.invalidate();
    }



    @Override
    public View onCreateContentView() {
        return createPopupById(R.layout.popup_select_all);
    }

    private static Activity mContext;
    public static class Builder {
        private List<Object> mItemEventList = new ArrayList<>();
        private List<PetDogGoodsListBean.FilterBoxData> modelDatas = new ArrayList<>();
        public Builder(Activity context, List<PetDogGoodsListBean.FilterBoxData> data) {
            mContext = context;
            modelDatas.addAll(data);
        }

        public SlideFirstAllFilterPopupWindow.Builder addItem(String itemTx) {
            mItemEventList.add(itemTx);
            return this;
        }

        public SlideFirstAllFilterPopupWindow.Builder addItem(int clickTag, String itemTx) {
            mItemEventList.add(new SlideFirstAllFilterPopupWindow.clickItemEvent(clickTag, itemTx));
            return this;
        }
        public List<Object> getItemEventList() {
            return mItemEventList;
        }
        public SlideFirstAllFilterPopupWindow build() {
            return new SlideFirstAllFilterPopupWindow(mContext, this,modelDatas);
        }

    }

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


    public void setOnAllFilterPopupItemClickListener(OnAllFilterPopupItemClickListener onListPopupItemClickListener) {
        mOnAllFilterPopupItemClickListener = onListPopupItemClickListener;
    }

    public interface OnAllFilterPopupItemClickListener {
        void onItemClick(int what, String text);
    }


    private void sendMsg(int flag) {
        Message message = Message.obtain();
        message.obj = flag;
        handler.sendMessage(message);
    }

    private void sendMsg(int i,T flag) {
        Message message = Message.obtain();
        message.what = i;
        message.obj = flag;
        handler.sendMessage(message);
    }


}
