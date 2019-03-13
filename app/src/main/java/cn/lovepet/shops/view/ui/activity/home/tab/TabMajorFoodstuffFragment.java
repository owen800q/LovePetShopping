package cn.lovepet.shops.view.ui.activity.home.tab;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.transformer.AccordionTransformer;
import com.youth.banner.transformer.BackgroundToForegroundTransformer;
import com.youth.banner.transformer.CubeInTransformer;
import com.youth.banner.transformer.CubeOutTransformer;
import com.youth.banner.transformer.DefaultTransformer;
import com.youth.banner.transformer.DepthPageTransformer;
import com.youth.banner.transformer.FlipHorizontalTransformer;
import com.youth.banner.transformer.FlipVerticalTransformer;
import com.youth.banner.transformer.ForegroundToBackgroundTransformer;
import com.youth.banner.transformer.RotateDownTransformer;
import com.youth.banner.transformer.RotateUpTransformer;
import com.youth.banner.transformer.ScaleInOutTransformer;
import com.youth.banner.transformer.StackTransformer;
import com.youth.banner.transformer.TabletTransformer;
import com.youth.banner.transformer.ZoomInTransformer;
import com.youth.banner.transformer.ZoomOutSlideTransformer;
import com.youth.banner.transformer.ZoomOutTranformer;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.lovepet.shops.R;
import cn.lovepet.shops.base.BaseFragment;
import cn.lovepet.shops.bean.PetDogTabMajorFoodBean;
import cn.lovepet.shops.bean.PetDogTabMajorFoodPlateBean;
import cn.lovepet.shops.helper.basequickadapter.BaseMultiItemQuickAdapter;
import cn.lovepet.shops.helper.basequickadapter.BaseQuickAdapter;
import cn.lovepet.shops.helper.basequickadapter.BaseViewHolder;
import cn.lovepet.shops.helper.glide.GlideImageLoader;
import cn.lovepet.shops.helper.imageview.RecycleViewDivider;
import cn.lovepet.shops.util.FileUtils;
import cn.lovepet.shops.util.ILog;
import cn.lovepet.shops.util.ToastsUtils;
import cn.lovepet.shops.util.ViewUtils;
import cn.lovepet.shops.view.ui.activity.content.PetGoodsActivity;

/**
 * @author JSYL-DCL
 * @date 2018/10/29 10:50
 * @des 首页-页签-狗狗主粮
 */
public class TabMajorFoodstuffFragment extends BaseFragment {

    private static final java.lang.String TAG = TabMajorFoodstuffFragment.class.getSimpleName();
    @BindView(R.id.topRecyclerView)
    RecyclerView mTopRecyclerView;
    @BindView(R.id.bottomRecyclerview)
    RecyclerView mBottomRecyclerview;
    @BindView(R.id.rbnMajorFoodClassfication)
    RadioGroup mRGPRoot;
    @BindView(R.id.rbnMajorFoodAll)
    RadioButton rbnMajorFoodAll;
    @BindView(R.id.rbnMajorFoodJK)
    RadioButton rbnMajorFoodJK;
    @BindView(R.id.rbnMajorFoodGC)
    RadioButton rbnMajorFoodGC;
    @BindView(R.id.rbnMajorFoodCF)
    RadioButton rbnMajorFoodCF;
    @BindView(R.id.rbnMajorFoodDG)
    RadioButton rbnMajorFoodDG;
    @BindView(R.id.appBarLayout)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.collapsingToolbarLayout)
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    @BindView(R.id.horizontalScrollView)
    HorizontalScrollView mHorizontalScrollView;


    private BaseQuickAdapter mAdapter;
    private List<PetDogTabMajorFoodBean.Datas> tabHomeMajorFoodDatas;
    //板块导航
//    private List<PetDogTabMajorFoodPlateBean.Menu_1.Menus_content> tabHomeMajorFoodPlateDatas;
    //分类导航
    private List<PetDogTabMajorFoodPlateBean.Menu_2> tabHomeMajorFoodClassFicationDatas;
    private List<PetDogTabMajorFoodPlateBean.Menu_2.Content_list> jxContentList;
    private List<PetDogTabMajorFoodPlateBean.Menu_2.Content_list> jxContentNewList;

    private List<String> nineImages;
    private BaseQuickAdapter mJxSoldAdapter;
    private LinearLayoutManager classficationlayoutManager;
    public static TabMajorFoodstuffFragment newInstance() {
        TabMajorFoodstuffFragment fragment = new TabMajorFoodstuffFragment();
        return fragment;
    }
    @Override
    protected int setImmersiveStatusBarColor() {
        return 0;
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_home_tab_major_foodstuff;
    }

    @Override
    protected void init() {
        if (tabHomeMajorFoodDatas != null)tabHomeMajorFoodDatas.clear();
        else tabHomeMajorFoodDatas = new ArrayList<>();
        if (jxContentList != null)jxContentList.clear();
        else jxContentList = new ArrayList<>();
        if (jxContentNewList != null)jxContentNewList.clear();
        else jxContentNewList = new ArrayList<>();
        if (tabHomeMajorFoodClassFicationDatas != null)tabHomeMajorFoodClassFicationDatas.clear();
        else tabHomeMajorFoodClassFicationDatas = new ArrayList<>();
        if (nineImages != null)nineImages.clear();
        else nineImages = new ArrayList<>();
    }

    @Override
    protected void bindView() {
       setMajorFoodData();
       setBottomListData();
        //去掉上滑时顶部阴影

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            mAppBarLayout.setOutlineProvider(null);
//            mCollapsingToolbarLayout.setOutlineProvider(ViewOutlineProvider.BOUNDS);
//        }
    }


    private void setMajorFoodData() {
        //禁用滑动事件
        mTopRecyclerView.setNestedScrollingEnabled(false);
        mTopRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mTopRecyclerView.setHasFixedSize(true);
        mTopRecyclerView.setItemViewCacheSize(10);
        mAdapter = new PetDogTabMajorFoodAdapter(tabHomeMajorFoodDatas);
        //防止数据错乱
        mAdapter.setHasStableIds(true);
        mTopRecyclerView.setAdapter(mAdapter);
        mTopRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    Glide.with(getActivity()).resumeRequests();
                }else {
                    Glide.with(getActivity()).pauseRequests();
                }
            }
        });
        getMajorFoodAllData();
    }


    @Override
    protected void bindData(Bundle savedInstanceState) {

    }

    @Override
    protected void bindListener() {

    }

    /**
     * 精选列表
     */
    private void setBottomListData() {
        classficationlayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        mBottomRecyclerview.setLayoutManager(classficationlayoutManager);
        //添加item分割线
        int color = getResources().getColor(R.color.common_h7);
        RecycleViewDivider recycleViewDivider = new RecycleViewDivider(getActivity(), classficationlayoutManager.getOrientation(), 1, color);
        mBottomRecyclerview.removeItemDecoration(recycleViewDivider);
        mBottomRecyclerview.addItemDecoration(recycleViewDivider);
        mBottomRecyclerview.setHasFixedSize(true);
        mBottomRecyclerview.setItemViewCacheSize(10);
        mJxSoldAdapter = new JxSoldAdapter(R.layout.item_home_tab_major_food_jingxuna_item,jxContentNewList);
        //防止数据错乱
        mJxSoldAdapter.setHasStableIds(true);
        mBottomRecyclerview.setAdapter(mJxSoldAdapter);
        rbnMajorFoodAll.setChecked(true);
        getJingxuanPlateData(0);
        mRGPRoot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rbnMajorFoodAll){
                    rbnMajorFoodAll.setBackgroundResource(R.drawable.selector_button_jingxuan);
                    rbnMajorFoodAll.setTextColor(getResources().getColor(R.color.red));
                    rbnMajorFoodJK.setTextColor(getResources().getColor(R.color.common_h1));
                    rbnMajorFoodGC.setTextColor(getResources().getColor(R.color.common_h1));
                    rbnMajorFoodCF.setTextColor(getResources().getColor(R.color.common_h1));
                    rbnMajorFoodDG.setTextColor(getResources().getColor(R.color.common_h1));
                    getJingxuanPlateData(0);
                    horizontalScrollViewTo(group.getChildAt(0));
                }else if (checkedId == R.id.rbnMajorFoodJK){
                    rbnMajorFoodJK.setBackgroundResource(R.drawable.selector_button_jingxuan);
                    rbnMajorFoodJK.setTextColor(getResources().getColor(R.color.red));
                    rbnMajorFoodAll.setTextColor(getResources().getColor(R.color.common_h1));
                    rbnMajorFoodGC.setTextColor(getResources().getColor(R.color.common_h1));
                    rbnMajorFoodCF.setTextColor(getResources().getColor(R.color.common_h1));
                    rbnMajorFoodDG.setTextColor(getResources().getColor(R.color.common_h1));
                    getJingxuanPlateData(1);
                    horizontalScrollViewTo(group.getChildAt(1));
                }else if (checkedId == R.id.rbnMajorFoodGC){
                    rbnMajorFoodGC.setBackgroundResource(R.drawable.selector_button_jingxuan);
                    rbnMajorFoodGC.setTextColor(getResources().getColor(R.color.red));
                    rbnMajorFoodJK.setTextColor(getResources().getColor(R.color.common_h1));
                    rbnMajorFoodAll.setTextColor(getResources().getColor(R.color.common_h1));
                    rbnMajorFoodCF.setTextColor(getResources().getColor(R.color.common_h1));
                    rbnMajorFoodDG.setTextColor(getResources().getColor(R.color.common_h1));
                    getJingxuanPlateData(2);
                    horizontalScrollViewTo(group.getChildAt(2));
                }else if (checkedId == R.id.rbnMajorFoodCF){
                    rbnMajorFoodCF.setBackgroundResource(R.drawable.selector_button_jingxuan);
                    rbnMajorFoodCF.setTextColor(getResources().getColor(R.color.red));
                    rbnMajorFoodGC.setTextColor(getResources().getColor(R.color.common_h1));
                    rbnMajorFoodJK.setTextColor(getResources().getColor(R.color.common_h1));
                    rbnMajorFoodAll.setTextColor(getResources().getColor(R.color.common_h1));
                    rbnMajorFoodDG.setTextColor(getResources().getColor(R.color.common_h1));
                    getJingxuanPlateData(3);
                    horizontalScrollViewTo(group.getChildAt(3));
                }else if (checkedId == R.id.rbnMajorFoodDG){
                    rbnMajorFoodDG.setBackgroundResource(R.drawable.selector_button_jingxuan);
                    rbnMajorFoodDG.setTextColor(getResources().getColor(R.color.red));
                    rbnMajorFoodCF.setTextColor(getResources().getColor(R.color.common_h1));
                    rbnMajorFoodGC.setTextColor(getResources().getColor(R.color.common_h1));
                    rbnMajorFoodJK.setTextColor(getResources().getColor(R.color.common_h1));
                    rbnMajorFoodAll.setTextColor(getResources().getColor(R.color.common_h1));
                    getJingxuanPlateData(4);
                    horizontalScrollViewTo(group.getChildAt(4));
                }
            }
        });
    }

    /**
     * 主粮数据设置
     */
    private List<String> bannerList;
    private List<Class<? extends ViewPager.PageTransformer>> transformers = new ArrayList<>();
    public class PetDogTabMajorFoodAdapter extends BaseMultiItemQuickAdapter<PetDogTabMajorFoodBean.Datas, BaseViewHolder> implements OnBannerListener {
        /**
         * Same as QuickAdapter#QuickAdapter(Context,int) but with
         * some initialization data.
         *
         * @param data A new list is created out of this one to avoid mutable list
         */
        public PetDogTabMajorFoodAdapter(List<PetDogTabMajorFoodBean.Datas> data) {
            super(data);
            addItemType(PetDogTabMajorFoodBean.Datas.BANNER, R.layout.item_pet_tab_home_banner);
            addItemType(PetDogTabMajorFoodBean.Datas.PlATE_NAVIGATION, R.layout.item_pet_tab_home_major_food_plate_navigation);
//            addItemType(PetDogTabMajorFoodBean.Datas.CLASSFICATION_NAVIGATION, R.layout.item_pet_tab_home_major_food_classfication);
        }

        @Override
        protected void convert(BaseViewHolder helper, PetDogTabMajorFoodBean.Datas item, int position) {
            List<PetDogTabMajorFoodBean.Datas.Value_list> value_list = item.getValue_list();
            switch (item.getItemType()) {
                case 101://轮播图
                    bannerList = new ArrayList<>();
                    List<String> titles=new ArrayList<>();
                    if (bannerList != null && bannerList.size() > 0)bannerList.clear();
                    if (titles != null && titles.size() > 0)titles.clear();
                    Banner mBanner = (Banner)helper.getView(R.id.banner);
                    initAnim();
                    //数据
                    for (PetDogTabMajorFoodBean.Datas.Value_list a: value_list) {
                        String image = a.getImage();
                        bannerList.add(image);
                        titles.add("");
                    }
                    //默认是NUM_INDICATOR_TITLE
                    mBanner.setImages(bannerList)
//                            .setBannerTitles(titles)
                            .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                            .setIndicatorGravity(BannerConfig.CENTER)
                            .setImageLoader(new GlideImageLoader())
                            .setOnBannerListener(this)
                            .isAutoPlay(true)
                            .setBannerAnimation(transformers.get(1))
                            .setDelayTime(4000)
                            .start();
                    break;
                case 102://板块导航
                    RecyclerView mPlateRecyvlerView = (RecyclerView) helper.getView(R.id.plateRecyvlerView);
                    RadioGroup rbnPlateNavigation = (RadioGroup) helper.getView(R.id.rbnPlateNavigation);
                    setPlateContentData(mPlateRecyvlerView,rbnPlateNavigation);
                    break;
                default:
                    break;

            }
        }

        /**
         * 轮播图
         * @param position
         */
        @Override
        public void OnBannerClick(int position) {
            ToastsUtils.showShort("主粮轮播图，点击了："+position);
        }
    }


//    private boolean mShouldScroll = false;
//    private int mToPosition = 0;
//    private void smoothMoveToPosition(RecyclerView recyclerView,final int position) {
//        //获取第一个跟最后一个可见item
//        int firstItem = recyclerView.getChildLayoutPosition(recyclerView.getChildAt(0));
//        int lastItem = recyclerView.getChildLayoutPosition(recyclerView.getChildAt(recyclerView.getChildCount() - 1));
//        if (position < firstItem) {
//            // 如果要跳转的位置在第一个可见项之前，则smoothScrollToPosition可以直接跳转
//            recyclerView.smoothScrollToPosition(position);
//        } else if (position <= lastItem) {
//            // 如果要跳转的位置在第一个可见项之后，且在最后一个可见项之前
//            // smoothScrollToPosition根本不会动，此时调用smoothScrollBy来滑动到指定位置
//            int movePosition = position - firstItem;
//            if (movePosition >= 0 && movePosition < recyclerView.getChildCount()) {
//                int top = recyclerView.getChildAt(movePosition).getTop();
//                recyclerView.smoothScrollBy(0, top);
//            }
//        } else {
//            // 如果要跳转的位置在最后可见项之后，则先调用smoothScrollToPosition将要跳转的位置滚动到可见位置
//            // 再通过onScrollStateChanged控制再次调用smoothMoveToPosition，进入上一个控制语句
//            recyclerView.smoothScrollToPosition(position);
//            mShouldScroll = true;
//            mToPosition = position;
//        }
//    }


    /**
     * 精选活动
     */
    public class JxSoldAdapter extends BaseQuickAdapter<PetDogTabMajorFoodPlateBean.Menu_2.Content_list, BaseViewHolder> {
        public JxSoldAdapter(int layoutResId, List<PetDogTabMajorFoodPlateBean.Menu_2.Content_list> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, PetDogTabMajorFoodPlateBean.Menu_2.Content_list item, int position) {
            ImageView jxImageIcon = (ImageView) helper.getView(R.id.jxImageIcon);
//            TextView tvJxTitle = (TextView) helper.getView(R.id.tvJxTitle);
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
            if (item.getActivityIcons()){
                ivJxIconSold.setVisibility(View.VISIBLE);
                Glide.with(mContext)
                        .load(item.getImage())
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
    }

    PlateAdaper mMajorFoodPlateAdaper;
    private void setPlateContentData(RecyclerView mPlateRecyvlerView, RadioGroup rbnPlateNavigation) {
        mPlateRecyvlerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        mPlateRecyvlerView.setHasFixedSize(true);
        mPlateRecyvlerView.setItemViewCacheSize(10);
        rbnPlateNavigation.check(rbnPlateNavigation.getChildAt(0).getId());
        mMajorFoodPlateAdaper = new PlateAdaper(R.layout.item_majorfood_plate_item, nineImages);
        mPlateRecyvlerView.setAdapter(mMajorFoodPlateAdaper);
        rbnPlateNavigation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.ibnGCFood:
                        getMajorFoodPlateData(0);
                        break;
                    case R.id.ibnJKFood:
                        getMajorFoodPlateData(1);
                        break;
                    case R.id.ibnKWPF:
                        getMajorFoodPlateData(2);
                        break;
                    case R.id.ibnSinglePrice:
                        getMajorFoodPlateData(3);
                        break;
                    default:
                        break;
                }
            }


        });
        getMajorFoodPlateData(0);
    }

    private void horizontalScrollViewTo(View childAt) {
        //获取屏幕宽度
        int screenWidth=getResources().getDisplayMetrics().widthPixels;
        //计算控件居正中时距离左侧屏幕的距离
        int middleLeftPosition=(screenWidth - childAt.getWidth())/2;
        //正中间位置需要向左偏移的距离
        int offset = childAt.getLeft()-middleLeftPosition;
        //让水平的滚动视图按照执行的x的偏移量进行移动
        mHorizontalScrollView.smoothScrollTo(offset,0);
    }


    public class PlateAdaper extends BaseQuickAdapter<String, BaseViewHolder> {
        public PlateAdaper(int layoutResId, List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item, int position) {
            int adapterPosition = helper.getAdapterPosition();
            ImageView ivPlateGridView = (ImageView) helper.getView(R.id.ivPlateGridView);

            Glide.with(mContext)
                    .load(item)
                    .asBitmap()
                    .skipMemoryCache(false)
                    .priority(Priority.NORMAL)
                    .dontTransform()
                    .placeholder(R.mipmap.pet_image_loadding)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(ivPlateGridView);
            if (menus_content != null){
                final String name = menus_content.get(adapterPosition).getName();
                ivPlateGridView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastsUtils.showShort(name);
                        PetGoodsActivity.getInstance(mContext);
                    }
                });
            }
        }
    }


    /**
     * 获取主粮一级数据
     */
    private void getMajorFoodAllData() {
//        if (tabHomeMajorFoodPlateDatas != null)tabHomeMajorFoodPlateDatas.clear();
//        else tabHomeMajorFoodPlateDatas = new ArrayList<>();
        if (tabHomeMajorFoodClassFicationDatas != null)tabHomeMajorFoodClassFicationDatas.clear();
        else tabHomeMajorFoodClassFicationDatas = new ArrayList<>();
        //主粮一级数据
        String json = FileUtils.getJson(getActivity(), "pet_dog_tab_home_two.json");
        Gson gson = new Gson();
        Type type = new TypeToken<PetDogTabMajorFoodBean>() {}.getType();
        PetDogTabMajorFoodBean petDogTabMajorFoodBean = gson.fromJson(json, type);
        List<PetDogTabMajorFoodBean.Datas> datas = petDogTabMajorFoodBean.getDatas();
        tabHomeMajorFoodDatas.addAll(datas);
        mAdapter.notifyDataSetChanged();
        ILog.e(TAG,"获取主粮一级数据----------->>:"+new Gson().toJson(petDogTabMajorFoodBean));
    }


    /**
     * 获取板块导航数据
     */
    private List<PetDogTabMajorFoodPlateBean.Menu_1.Menus_content> menus_content;
    private void getMajorFoodPlateData(int i) {
        if (menus_content != null)menus_content.clear();
        else menus_content = new ArrayList<>();
        //板块导航数据
        String json1 = FileUtils.getJson(getActivity(), "pet_dog_tab_home_two_content.json");
        Gson gson1 = new Gson();
        Type type1 = new TypeToken<PetDogTabMajorFoodPlateBean>() {}.getType();
        PetDogTabMajorFoodPlateBean petDogTabMajorFoodPlateBean = gson1.fromJson(json1, type1);
        ILog.e(TAG,"获取板块导航数据----------->>:"+new Gson().toJson(petDogTabMajorFoodPlateBean));
        List<PetDogTabMajorFoodPlateBean.Menu_1> menu_1 = petDogTabMajorFoodPlateBean.getMenu_1();
        List<PetDogTabMajorFoodPlateBean.Menu_2> menu_2 = petDogTabMajorFoodPlateBean.getMenu_2();
        List<PetDogTabMajorFoodPlateBean.Menu_1.Menus_content> menus_content0 = menu_1.get(0).getMenus_content();
        List<PetDogTabMajorFoodPlateBean.Menu_1.Menus_content> menus_content1 = menu_1.get(1).getMenus_content();
        List<PetDogTabMajorFoodPlateBean.Menu_1.Menus_content> menus_content2 = menu_1.get(2).getMenus_content();
        List<PetDogTabMajorFoodPlateBean.Menu_1.Menus_content> menus_content3 = menu_1.get(3).getMenus_content();

        if (nineImages != null)nineImages.clear();
        else nineImages = new ArrayList<>();
        if (jxContentList != null)jxContentList.clear();
        else jxContentList = new ArrayList<>();
        for (PetDogTabMajorFoodPlateBean.Menu_2 b: menu_2) {
            jxContentList.addAll(b.getContent_list());
        }
        if (i == 0){
            for (int j = 0;j < menus_content0.size();j++) {
                String image = menus_content0.get(j).getImage();
                nineImages.add(image);
            }
            menus_content.addAll(menus_content0);
        }else  if (i == 1){
            for (int j = 0;j < menus_content1.size();j++) {
                String image = menus_content1.get(j).getImage();
                nineImages.add(image);
            }
            menus_content.addAll(menus_content1);
        }else  if (i == 2){
            for (int j = 0;j < menus_content2.size();j++) {
                String image = menus_content2.get(j).getImage();
                nineImages.add(image);
            }
            menus_content.addAll(menus_content2);
        }else  if (i == 3){
            for (int j = 0;j < menus_content3.size();j++) {
                String image = menus_content3.get(j).getImage();
                nineImages.add(image);
            }
            menus_content.addAll(menus_content3);
        }
        tabHomeMajorFoodClassFicationDatas.addAll(menu_2);
        mMajorFoodPlateAdaper.notifyDataSetChanged();
    }

    /**
     * 获取详情导航数据（精选）
     */
    private void getJingxuanPlateData(int i) {
        //板块导航数据
        String json1 = FileUtils.getJson(getActivity(), "pet_dog_tab_home_two_content.json");
        Gson gson1 = new Gson();
        Type type1 = new TypeToken<PetDogTabMajorFoodPlateBean>() {}.getType();
        PetDogTabMajorFoodPlateBean petDogTabMajorFoodPlateBean = gson1.fromJson(json1, type1);
        ILog.e(TAG,"获取板块导航数据（精选）----------->>:"+new Gson().toJson(petDogTabMajorFoodPlateBean));
        List<PetDogTabMajorFoodPlateBean.Menu_2> menu_2 = petDogTabMajorFoodPlateBean.getMenu_2();
        if (jxContentNewList != null)jxContentNewList.clear();
        else jxContentNewList = new ArrayList<>();
        jxContentNewList.addAll(menu_2.get(i).getContent_list());
        String name = menu_2.get(i).getName();
        ILog.e(TAG,"获取板块导航（精选）,当前是----------->>:"+name);
        ILog.e(TAG,"获取板块导航（精选）,当前是----------->>jxContentNewList.size  :"+jxContentNewList.size());
        mJxSoldAdapter.notifyDataSetChanged();
        if (jxContentNewList != null && jxContentNewList.size() > 0) {
            smoothMoveToPosition(mBottomRecyclerview, 0);
        }
    }


    private void initAnim() {
        transformers.add(DefaultTransformer.class);
        transformers.add(AccordionTransformer.class);
        transformers.add(BackgroundToForegroundTransformer.class);
        transformers.add(ForegroundToBackgroundTransformer.class);
        transformers.add(CubeInTransformer.class);//兼容问题，慎用
        transformers.add(CubeOutTransformer.class);
        transformers.add(DepthPageTransformer.class);
        transformers.add(FlipHorizontalTransformer.class);//7
        transformers.add(FlipVerticalTransformer.class);
        transformers.add(RotateDownTransformer.class);
        transformers.add(RotateUpTransformer.class);
        transformers.add(ScaleInOutTransformer.class);
        transformers.add(StackTransformer.class);
        transformers.add(TabletTransformer.class);
        transformers.add(ZoomInTransformer.class);
        transformers.add(ZoomOutTranformer.class);
        transformers.add(ZoomOutSlideTransformer.class);
    }



    /**
     * 滑动到指定位置
     *
     * @param mRecyclerView
     * @param position
     */
    //目标项是否在最后一个可见项之后
    private boolean mShouldScroll;
    //记录目标项位置
    private int mToPosition;
    private void smoothMoveToPosition(RecyclerView mRecyclerView, final int position) {
        // 第一个可见位置
        int firstItem = mRecyclerView.getChildLayoutPosition(mRecyclerView.getChildAt(0));
        // 最后一个可见位置
        int lastItem = mRecyclerView.getChildLayoutPosition(mRecyclerView.getChildAt(mRecyclerView.getChildCount() - 1));

        if (position < firstItem) {
            // 如果跳转位置在第一个可见位置之前，就smoothScrollToPosition可以直接跳转
            mRecyclerView.smoothScrollToPosition(position);
        } else if (position <= lastItem) {
            // 跳转位置在第一个可见项之后，最后一个可见项之前
            // smoothScrollToPosition根本不会动，此时调用smoothScrollBy来滑动到指定位置
            int movePosition = position - firstItem;
            if (movePosition >= 0 && movePosition < mRecyclerView.getChildCount()) {
                int top = mRecyclerView.getChildAt(movePosition).getTop();
                mRecyclerView.smoothScrollBy(0, top);
            }
        } else {
            // 如果要跳转的位置在最后可见项之后，则先调用smoothScrollToPosition将要跳转的位置滚动到可见位置
            // 再通过onScrollStateChanged控制再次调用smoothMoveToPosition，执行上一个判断中的方法
            mRecyclerView.smoothScrollToPosition(position);
            mToPosition = position;
            mShouldScroll = true;
        }
    }
}