package cn.lovepet.shops.view.ui.activity.content;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import cn.lovepet.shops.R;
import cn.lovepet.shops.base.BaseActivity;
import cn.lovepet.shops.base.Constants;
import cn.lovepet.shops.bean.PetDogGoodsListBean;
import cn.lovepet.shops.helper.basequickadapter.BaseQuickAdapter;
import cn.lovepet.shops.helper.basequickadapter.BaseViewHolder;
import cn.lovepet.shops.helper.imageview.RecycleViewDivider;
import cn.lovepet.shops.helper.popupwindow.SlideFirstAllFilterPopupWindow;
import cn.lovepet.shops.helper.popupwindow.SlideFirstFilterListPopupWindow;
import cn.lovepet.shops.helper.popupwindow.SlideSecondFilterPopupWindow;
import cn.lovepet.shops.util.FileUtils;
import cn.lovepet.shops.util.ToastsUtils;
import cn.lovepet.shops.util.ViewUtils;
import cn.lovepet.shops.view.ui.activity.home.tab.SearchQueryActivity;
import razerdp.basepopup.BasePopupWindow;

/**
 * @author JSYL-DCL
 * @date 2018/11/21 14:33
 * @des 宠物消息
 */
public class PetGoodsActivity extends BaseActivity {
    private Context mContext;
    @BindView(R.id.goodsRecyclerView)
    RecyclerView mGoodsRecyclerView;
    @BindView(R.id.llGoodsRoot)
    LinearLayout mLlGoodsRoot;
    @BindView(R.id.brandArrow)
    ImageView mBrandArrow;
    @BindView(R.id.ivAgeArrow)
    ImageView mIvAgeArrow;
    @BindView(R.id.ivBodyArrow)
    ImageView mIvBodyArrow;
    @BindView(R.id.ivKelisizeArrow)
    ImageView mIvKelisizeArrow;

    @BindView(R.id.llFirstFilter)
    LinearLayout mLlFirstFilter;
    @BindView(R.id.llSecondFilter)
    LinearLayout mLlSecondFilter;

    @BindView(R.id.llBrand)
    LinearLayout mLlBrand;
    @BindView(R.id.llAge)
    LinearLayout mLlAge;
    @BindView(R.id.llShape)
    LinearLayout mLlShape;
    @BindView(R.id.llGrainSize)
    LinearLayout mLlGrainSize;
    //第一层排序
    @BindView(R.id.tvDefaultSort)
    TextView mTvDefaultSort;
    @BindView(R.id.ivDefaultSort)
    ImageView mIvDefaultSort;
    @BindView(R.id.tvSoldNums)
    TextView mTvSoldNums;
    @BindView(R.id.ivAllFilterSelect)
    ImageView mIvAllFilterSelect;
    @BindView(R.id.tvAllFilterSelect)
    TextView mTvAllFilterSelect;


    @BindView(R.id.tvFSLine)
    TextView tvFSLine;
    private RotateAnimation showArrowAnima;
    private RotateAnimation dismissArrowAnima;
    private SlideSecondFilterPopupWindow mSlideFromTopPopup;
//    private SlideFirstAllFilterPopupWindow mSlideFirstAllFilterPopupWindow;
    private Map<Integer,String> checkedMap;
    private BaseQuickAdapter mGoodsAdaper;
    private List<PetDogGoodsListBean.Goodslist> goodsModelList;

    public static void getInstance(Context context){
        context.startActivity(new Intent(context,PetGoodsActivity.class));
    }
    @Override
    protected int getLayoutId() {
        return R.layout.activity_pet_goods;
    }

    @Override
    protected void init() {
        if (goodsModelList != null)goodsModelList.clear();
        else goodsModelList = new ArrayList<>();
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mContext = PetGoodsActivity.this;
        checkedMap = new HashMap<>();
        buildShowArrowAnima();
        buildDismissArrowAnima();
        getFilterGoodsAllData();
        setBottomGoodsDetail();
    }

    /**
     * 设置底部列表默认数据
     */
    private void setBottomGoodsDetail() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        int color = getResources().getColor(R.color.common_divider_narrow);
        RecycleViewDivider divider = new RecycleViewDivider(mContext,LinearLayoutManager.VERTICAL,1,color);
        mGoodsRecyclerView.removeItemDecoration(divider);
        mGoodsRecyclerView.addItemDecoration(divider);
        mGoodsRecyclerView.setLayoutManager(layoutManager);
        mGoodsRecyclerView.setHasFixedSize(true);
        mGoodsRecyclerView.setItemViewCacheSize(5);
        mGoodsAdaper = new GoodsAdaper(R.layout.item_goods_t1, goodsModelList);
        mGoodsRecyclerView.setAdapter(mGoodsAdaper);
        getGoods();
    }

    private void getGoods() {
        if (goodsModelList != null)goodsModelList.clear();
        else goodsModelList = new ArrayList<>();
        goodsModelList.addAll(goodslist);
        mGoodsAdaper.notifyDataSetChanged();

    }

    private class GoodsAdaper extends BaseQuickAdapter<PetDogGoodsListBean.Goodslist, BaseViewHolder> {
        public GoodsAdaper(int layoutResId, List<PetDogGoodsListBean.Goodslist> data) {
            super(layoutResId, data);
        }

        public GoodsAdaper(List<PetDogGoodsListBean.Goodslist> data) {
            super(data);
        }

        @Override
        protected void convert(BaseViewHolder helper, PetDogGoodsListBean.Goodslist item, int position) {
            ImageView jxImageIcon = (ImageView) helper.getView(R.id.jxImageIcon);
//            TextView tvJxTitle = (TextView) holder.getView(R.id.tvJxTitle);
            ImageView ivJxIconSold = (ImageView) helper.getView(R.id.ivJxIconSold);
            TextView tvJxCurerntPrice = (TextView) helper.getView(R.id.tvJxCurerntPrice);
            TextView tvJxOldPrice = (TextView) helper.getView(R.id.tvJxOldPrice);
            TextView tvHuDong = (TextView) helper.getView(R.id.tvHuDong);
            TextView tvSoldNum = (TextView) helper.getView(R.id.tvSoldNum);
            ImageView ivShopcart = (ImageView) helper.getView(R.id.ivShopcart);

            helper.setText(R.id.tvJxTitle,item.getSubject() == null ? "" : item.getSubject());
            helper.setText(R.id.tvJxCurerntPrice,item.getSale_price() == null ? "" : "¥"+item.getSale_price());
            helper.setText(R.id.tvJxOldPrice,item.getMarket_price() == null ? "" : item.getMarket_price());
            helper.setText(R.id.tvHuDong,item.getComments() == null ? "" : item.getComments());
            helper.setText(R.id.tvSoldNum,item.getSold() == null ? "" : item.getSold());
            ViewUtils.setPriceLine(tvJxOldPrice,0);
            Glide.with(mContext)
                    .load(item.getPhoto())
                    .asBitmap()
                    .skipMemoryCache(false)
                    .priority(Priority.HIGH)
                    .dontTransform()
                    .placeholder(R.mipmap.pet_image_loadding)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(jxImageIcon);

            List<PetDogGoodsListBean.Goodslist.ActivityLabels> activityLabels = item.getActivityLabels();
            if (activityLabels != null && activityLabels.size() > 0){
                ivJxIconSold.setVisibility(View.VISIBLE);
                Glide.with(mContext)
                        .load(activityLabels.get(0).getImage())
                        .asBitmap()
                        .skipMemoryCache(false)
                        .priority(Priority.HIGH)
                        .dontTransform()
                        .placeholder(R.mipmap.pet_image_loadding)
                        .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                        .into(ivJxIconSold);
            }else {
                ivJxIconSold.setVisibility(View.GONE);
            }
            ivShopcart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastsUtils.showShort("加入购物车");
                }
            });
        }
    };


    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
    }

    @OnClick({
            R.id.ivBack
            ,R.id.goodsSearch
            ,R.id.llDefaultSort
            ,R.id.tvSoldNums
            ,R.id.llPrice
            ,R.id.llFilterSelect
            ,R.id.llBrand
            ,R.id.llAge
            ,R.id.llShape
            ,R.id.llGrainSize
    })
    public void bindViewClick(View view){
        switch (view.getId()){
            case  R.id.ivBack:
                finish();
                break;
            case  R.id.goodsSearch:
                SearchQueryActivity.getInstance(mContext);
                break;
            case  R.id.llDefaultSort://默认排序
                if (sortRankModelList != null && sortRankModelList.size() > 0) {
                    SlideFirstFilterListPopupWindow.Builder builder = new SlideFirstFilterListPopupWindow.Builder(this,sortRankModelList);
                    SlideFirstFilterListPopupWindow build = builder.build();
                    build.setOnSimpleListPopupItemClickListener(new SlideFirstFilterListPopupWindow.OnSimpleListPopupItemClickListener() {
                        @Override
                        public void onItemClick(int what, String text) {
                            Constants.POPUP_DEFAULT_SORT = text;
                            if (text.contains("默认")) {
                                mTvDefaultSort.setText("默认");
                            }else {
                                mTvDefaultSort.setText(text);
                            }
                            mTvSoldNums.setTextColor(getResources().getColor(R.color.material_grey_500));
                            mTvDefaultSort.setTextColor(getResources().getColor(R.color.red));
                            mIvDefaultSort.setImageResource(R.drawable.ico_arrow_down_select);
                        }
                    });
                    build.setOnDismissListener(onDismissListener);
                    build.showPopupWindow(tvFSLine);

                }else {
                    ToastsUtils.showShort("暂无筛选项");
                }
                break;
            case  R.id.tvSoldNums://销量
                mTvSoldNums.setTextColor(getResources().getColor(R.color.red));
                accordingFilterInit();
//                mTvSoldNums.setText(text);
                break;
            case  R.id.llPrice://价格
                ToastsUtils.showShort("价格");
                break;
            case  R.id.llFilterSelect://筛选
                initAllFilterPopUp(filterItemList,tvFSLine,mIvAllFilterSelect,mTvAllFilterSelect);
                break;
            case  R.id.llBrand://品牌
                initPopUp(brandModel,0,mBrandArrow,mLlSecondFilter,mLlBrand);
                Constants.POPUP_CURRENT_CLICK = 10;
                break;
            case  R.id.llAge://年龄
                initPopUp(ageModel,1,mIvAgeArrow,mLlSecondFilter,mLlAge);
                Constants.POPUP_CURRENT_CLICK = 11;
                break;
            case  R.id.llShape://体型
                initPopUp(bodyModel,2,mIvBodyArrow,mLlSecondFilter,mLlShape);
                Constants.POPUP_CURRENT_CLICK = 12;
                break;
            case  R.id.llGrainSize://颗粒大小
                initPopUp(keliSizeModel,3,mIvKelisizeArrow,mLlSecondFilter,mLlGrainSize);
                Constants.POPUP_CURRENT_CLICK = 13;
                break;
        }
    }

    /**
     * 一级筛选按钮展开弹窗
     * @param modelList
     * @param anchorView 相对view
     * @param tvBtn 按钮view
     */
    private void initAllFilterPopUp(List<PetDogGoodsListBean.FilterBoxData> modelList, View anchorView, View ico, View tvBtn) {
        if (modelList != null) {
            SlideFirstAllFilterPopupWindow.Builder builder = new SlideFirstAllFilterPopupWindow.Builder(this,modelList);
            SlideFirstAllFilterPopupWindow build = builder.build();
            build.setOnAllFilterPopupItemClickListener(new SlideFirstAllFilterPopupWindow.OnAllFilterPopupItemClickListener() {
                @Override
                public void onItemClick(int what, String text) {
                    ToastsUtils.showShort(text);
//                    mTvSoldNums.setTextColor(getResources().getColor(R.color.material_grey_500));
//                    mTvDefaultSort.setTextColor(getResources().getColor(R.color.red));
//                    mIvDefaultSort.setImageResource(R.drawable.ico_arrow_down_select);
                }
            });
            build.setOnDismissListener(onAllFilterDismissListener);
//            build.setOffsetX(0);
//            build.setOffsetY(-150);
            build.showPopupWindow(anchorView);
//            PopupWindow popupWindow = build.getPopupWindow();
//            popupWindow.showAtLocation(anchorView, Gravity.BOTTOM,0,150);
            if (build.isShowing() && ico instanceof ImageView) {
                ico.setBackground(getResources().getDrawable(R.drawable.ico_select_filter_checked));
                ((TextView)tvBtn).setTextColor(getResources().getColor(R.color.red));
                mTvSoldNums.setTextColor(getResources().getColor(R.color.material_grey_500));
                mTvDefaultSort.setTextColor(getResources().getColor(R.color.material_grey_500));
                mIvDefaultSort.setImageResource(R.drawable.ico_arrow_down_unselect);
            }
        }else {
            ToastsUtils.showShort("暂无筛选项");
        }
    }

    /**
     * 一级筛选初始化未操作项
     */
    private void accordingFilterInit() {
        mTvDefaultSort.setTextColor(getResources().getColor(R.color.material_grey_500));
        if (sortRankModelList != null && sortRankModelList.size() > 0) {
            String item = sortRankModelList.get(0).getItem();
            if (item.contains("默认")) {
                mTvDefaultSort.setText("默认");
            }else {
                mTvDefaultSort.setText(item);
            }
        }else {
            mTvDefaultSort.setText("");
        }
        mIvDefaultSort.setImageResource(R.drawable.ico_arrow_down_unselect);
    }

    /**
     * 二级筛选初始化弹窗
     * @param model
     * @param i
     * @param ivarrow
     * @param mLlSecondFilter achorView 基于此view展开
     * @param mButton 展开按钮
     */
    private void initPopUp(PetDogGoodsListBean.FilterBoxData model, int i, ImageView ivarrow, LinearLayout mLlSecondFilter, LinearLayout mButton) {
        if (mSlideFromTopPopup != null && mSlideFromTopPopup.isShowing()){
        }else {
            mSlideFromTopPopup = new SlideSecondFilterPopupWindow(mContext,model,i);
            mSlideFromTopPopup.setOnDismissListener(onDismissListener);
            mSlideFromTopPopup.setOnListPopupItemClickListener(onPopupSelectListener);
            if (!mSlideFromTopPopup.isShowing()) startShowArrowAnima(ivarrow);
            mSlideFromTopPopup.showPopupWindow(mLlSecondFilter);
            mButton.setBackground(getResources().getDrawable(R.drawable.shape_goods_button_bg_clicked));
        }
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected void getBundleExtras(Intent intent) {

    }

    @Override
    protected int setImmersiveStatusBarColor() {
        return 0;
    }


    /**
     * 创建箭头开始动画
     */
    private void buildShowArrowAnima() {
        if (showArrowAnima != null) return;
        showArrowAnima = new RotateAnimation(0, 180f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        showArrowAnima.setDuration(200);
        showArrowAnima.setInterpolator(new AccelerateDecelerateInterpolator());
        showArrowAnima.setFillAfter(true);
    }

    /**
     * 创建箭头在弹窗消失时动画
     */
    private void buildDismissArrowAnima() {
        if (dismissArrowAnima != null) return;
        dismissArrowAnima = new RotateAnimation(180f, 0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        dismissArrowAnima.setDuration(200);
        dismissArrowAnima.setInterpolator(new AccelerateDecelerateInterpolator());
        dismissArrowAnima.setFillAfter(true);
    }

    /**
     * 开始箭头动画
     * @param mArraw
     */
    private void startShowArrowAnima(View mArraw) {
        if (mArraw == null) return;
        if (mArraw instanceof ImageView) {
            mArraw.clearAnimation();
            mArraw.startAnimation(showArrowAnima);
        }
    }


    /**
     * 结束箭头动画
     * @param mArraw
     */
    private void startDismissArrowAnima(View mArraw) {
        if (mArraw == null) return;
        if (mArraw instanceof ImageView) {
            mArraw.clearAnimation();
            mArraw.startAnimation(dismissArrowAnima);
        }
    }


    /**
     * 获取物品列表数据
     */
    PetDogGoodsListBean.FilterBoxData brandModel;
    PetDogGoodsListBean.FilterBoxData ageModel;
    PetDogGoodsListBean.FilterBoxData bodyModel;
    PetDogGoodsListBean.FilterBoxData keliSizeModel;
    List<PetDogGoodsListBean.Goodslist> goodslist;
    List<String> normalSortList;
    List<PetDogGoodsListBean.Sort_rank.Sort_rank_list> sortRankModelList;

    List<PetDogGoodsListBean.FilterBoxData> filterItemList;
    private void getFilterGoodsAllData() {
        if (normalSortList != null)normalSortList.clear();
        else normalSortList = new ArrayList<>();
        if (sortRankModelList != null)sortRankModelList.clear();
        else sortRankModelList = new ArrayList<>();
        String json = FileUtils.getJson(mContext, "pet_goods_filter.json");
        Gson gson = new Gson();
        Type type = new TypeToken<PetDogGoodsListBean>() {}.getType();
        PetDogGoodsListBean petDogGoodsListBean = gson.fromJson(json, type);
        filterItemList = petDogGoodsListBean.getFilterBoxData();
        List<PetDogGoodsListBean.Sort_rank> sort_rank = petDogGoodsListBean.getSort_rank();
        //底部列表商品
        goodslist = petDogGoodsListBean.getGoodslist();
        List<PetDogGoodsListBean.Sort_rank.Sort_rank_list> sort_rank_list = sort_rank.get(0).getSort_rank_list();
        //品牌
        brandModel = filterItemList.get(0);
        //年龄
        ageModel = filterItemList.get(1);
        //体型
        bodyModel = filterItemList.get(2);
        //颗粒大小
        keliSizeModel = filterItemList.get(3);
        //默认排序
        if (sort_rank_list != null && sort_rank_list.size() > 0){
            for (PetDogGoodsListBean.Sort_rank.Sort_rank_list a : sort_rank_list) {
                normalSortList.add(a.getItem());
            }
            String item = sort_rank_list.get(0).getItem();
            sortRankModelList.addAll(sort_rank_list);
            mTvDefaultSort.setTextColor(getResources().getColor(R.color.red));
            mIvDefaultSort.setImageResource(R.drawable.ico_arrow_down_select);
            if (TextUtils.isEmpty(Constants.POPUP_DEFAULT_SORT)){
                if (item.contains("默认")){
                    mTvDefaultSort.setText("默认");
                }else {
                    mTvDefaultSort.setText(item);
                }
                Constants.POPUP_DEFAULT_SORT = item;
            }else {
                if (Constants.POPUP_DEFAULT_SORT.contains("默认")){
                    mTvDefaultSort.setText("默认");
                }else {
                    mTvDefaultSort.setText(Constants.POPUP_DEFAULT_SORT);
                }
            }
        }else {
            if (normalSortList != null) normalSortList.clear();
            if (sortRankModelList != null) sortRankModelList.clear();
        }

    }


    /**
     * 二级筛选的弹窗消失动画
     */
    private BasePopupWindow.OnDismissListener onDismissListener = new BasePopupWindow.OnDismissListener() {
        @Override
        public boolean onBeforeDismiss() {
            if (Constants.POPUP_CURRENT_CLICK == 10){//品牌
                startDismissArrowAnima(mBrandArrow);
            }else if (Constants.POPUP_CURRENT_CLICK == 11){//年龄
                startDismissArrowAnima(mIvAgeArrow);
            }else if (Constants.POPUP_CURRENT_CLICK == 12){//体型
                startDismissArrowAnima(mIvBodyArrow);
            }else if (Constants.POPUP_CURRENT_CLICK == 13){//颗粒大小
                startDismissArrowAnima(mIvKelisizeArrow);
            }
            return super.onBeforeDismiss();
        }
        @Override
        public void onDismiss() {
            if (Constants.POPUP_CURRENT_CLICK == 10){//品牌
                mLlBrand.setBackground(getResources().getDrawable(R.drawable.shape_goods_button_bg));
            }else if (Constants.POPUP_CURRENT_CLICK == 11){//年龄
                mLlAge.setBackground(getResources().getDrawable(R.drawable.shape_goods_button_bg));
            }else if (Constants.POPUP_CURRENT_CLICK == 12){//体型
                mLlShape.setBackground(getResources().getDrawable(R.drawable.shape_goods_button_bg));
            }else if (Constants.POPUP_CURRENT_CLICK == 13){//颗粒大小
                mLlGrainSize.setBackground(getResources().getDrawable(R.drawable.shape_goods_button_bg));
            }
        }
    };

    /**
     * 二级筛选选中条目监听
     */
    private SlideSecondFilterPopupWindow.OnListPopupItemClickListener onPopupSelectListener = new SlideSecondFilterPopupWindow.OnListPopupItemClickListener() {
        @Override
        public void onItemClick(int what, String text, int filterType) {
            ToastsUtils.showShort("选择："+text+":"+what);
            if (filterType == 0){//品牌
                Constants.POPUP_BRAND_SELECTED = text;
            }else if (filterType == 1){//年龄
                Constants.POPUP_AGE_SELECTED = text;
            }else if (filterType == 2){//体型
                Constants.POPUP_BODY_SELECTED = text;
            }else if (filterType == 3){//颗粒大小
                Constants.POPUP_KELISIZE_SELECTED = text;
            }
        }
    };


    /**
     * 筛选的弹窗消失监听
     */
    private BasePopupWindow.OnDismissListener onAllFilterDismissListener = new BasePopupWindow.OnDismissListener() {
        @Override
        public boolean onBeforeDismiss() {
            return super.onBeforeDismiss();
        }
        @Override
        public void onDismiss() {
            mIvAllFilterSelect.setBackground(getResources().getDrawable(R.drawable.ico_select_filter_none));
            mTvAllFilterSelect.setTextColor(getResources().getColor(R.color.material_grey_500));
            mTvDefaultSort.setTextColor(getResources().getColor(R.color.red));
            mIvDefaultSort.setImageResource(R.drawable.ico_arrow_down_select);
        }
    };

}