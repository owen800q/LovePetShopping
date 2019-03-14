package cn.lovepet.shops.view.ui.activity.home.tab;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.bugly.crashreport.CrashReport;
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
import cn.lovepet.shops.bean.PetDogTabSnacksBean;
import cn.lovepet.shops.bean.PetDogTabSnacksSecondListBean;
import cn.lovepet.shops.helper.basequickadapter.BaseMultiItemQuickAdapter;
import cn.lovepet.shops.helper.basequickadapter.BaseQuickAdapter;
import cn.lovepet.shops.helper.basequickadapter.BaseViewHolder;
import cn.lovepet.shops.helper.customview.SpaceItemDecoration;
import cn.lovepet.shops.helper.glide.GlideImageLoader;
import cn.lovepet.shops.helper.imageview.RecycleViewDivider;
import cn.lovepet.shops.helper.recyclerview.RecyclerViewHorizonScrollHelper;
import cn.lovepet.shops.helper.video.CustomMediaPlayer.JZMediaManager;
import cn.lovepet.shops.helper.video.CustomMediaPlayer.Jzvd;
import cn.lovepet.shops.helper.video.CustomMediaPlayer.JzvdMgr;
import cn.lovepet.shops.helper.video.CustomMediaPlayer.JzvdStd;
import cn.lovepet.shops.util.FileUtils;
import cn.lovepet.shops.util.ILog;
import cn.lovepet.shops.util.ToastsUtils;
import cn.lovepet.shops.util.ViewUtils;
import static android.view.View.GONE;
import static cn.lovepet.shops.helper.video.CustomMediaPlayer.Jzvd.CURRENT_STATE_PLAYING;

/**
 * @author JSYL-DCL
 * @date 2018/10/29 10:50
 * @des 首页-页签-狗狗零食
 */
public class TabSnacksFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    private static final String TAG1 = TabSnacksFragment.class.getSimpleName();
    Handler handler = new Handler();
    @BindView(R.id.topRecyclerView)
    RecyclerView mTopRecyclerView;
    @BindView(R.id.bottomRecyclerview)
    RecyclerView mBottomRecyclerview;

    @BindView(R.id.horizontalScrollView)
    HorizontalScrollView mHorizontalScrollView;
    @BindView(R.id.rgpSnackfood)
    RadioGroup mRgpSnackfood;
    @BindView(R.id.llBottomTitle)
    LinearLayout mLlBottomTitle;
    @BindView(R.id.ivBottomTitleImg)
    ImageView mIvBottomTitleImg;
    @BindView(R.id.bottomNestedScrollView)
    NestedScrollView mBottomNestedScrollView;


    private BaseQuickAdapter mAdapter;
    private List<String> nineImages;
    private List<PetDogTabSnacksBean.Top_datas> topDatasList;
    private List<PetDogTabSnacksBean.Bottom_datas> bottomDatasList;
    private List<PetDogTabSnacksSecondListBean.Bottom_goods_list.Datalist> bottomGoodList;
    private List<PetDogTabSnacksSecondListBean.Bottom_menu_list> bottomMenuList;

    public static TabSnacksFragment newInstance() {
        TabSnacksFragment fragment = new TabSnacksFragment();
        return fragment;
    }

    @Override
    protected int setImmersiveStatusBarColor() {
        return 0;
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_home_tab_snacks;
    }

    @Override
    protected void init() {
        if (topDatasList != null) topDatasList.clear();
        else topDatasList = new ArrayList<>();
        if (bottomDatasList != null) bottomDatasList.clear();
        else bottomDatasList = new ArrayList<>();
        if (nineImages != null) nineImages.clear();
        else nineImages = new ArrayList<>();
        if (bottomGoodList != null) bottomGoodList.clear();
        else bottomGoodList = new ArrayList<>();
        if (bottomMenuList != null) bottomMenuList.clear();
        else bottomMenuList = new ArrayList<>();

    }

    @Override
    protected void bindView() {
        mLlBottomTitle.setVisibility(GONE);
        setTopData();
        setBottomGroupTab();
        setBottomData();
    }

    private void setBottomGroupTab() {
        getSnacksBottomTitle();
        getSnacksBottomMenuTab();
    }

    private void setTopData() {
        mTopRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mTopRecyclerView.setHasFixedSize(true);
        mTopRecyclerView.setItemViewCacheSize(10);
        mAdapter = new PetDogTabSnacksTopAdapter(topDatasList);
        //防止数据错乱
        mAdapter.setHasStableIds(true);
        mTopRecyclerView.setAdapter(mAdapter);
        getSnacksTopListData();
    }


    private void setBottomData() {
        //禁用滑动事件
        mBottomRecyclerview.setNestedScrollingEnabled(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mBottomRecyclerview.setLayoutManager(layoutManager);
        //添加item分割线
        int color = getResources().getColor(R.color.common_divider_narrow);
        RecycleViewDivider recycleViewDivider = new RecycleViewDivider(getActivity(), layoutManager.getOrientation(), 1, color);
        mBottomRecyclerview.removeItemDecoration(recycleViewDivider);
        mBottomRecyclerview.addItemDecoration(recycleViewDivider);
        mBottomRecyclerview.setHasFixedSize(true);
        mBottomRecyclerview.setItemViewCacheSize(10);
        mJxSoldAdapter = new JxSoldAdapter(R.layout.item_home_tab_bottom_list_item, bottomGoodList);
        //防止数据错乱
        mJxSoldAdapter.setHasStableIds(true);
        mBottomRecyclerview.setAdapter(mJxSoldAdapter);
        getSnacksBottomSubTabData(0);
    }


    @Override
    protected void bindData(Bundle savedInstanceState) {

    }

    @Override
    protected void bindListener() {
        mTopRecyclerView.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() {
            @Override
            public void onChildViewAttachedToWindow(View view) {

            }

            @Override
            public void onChildViewDetachedFromWindow(View view) {
                Jzvd jzvd = view.findViewById(R.id.videoplayer);
                if (jzvd != null && jzvd.jzDataSource.containsTheUrl(JZMediaManager.getCurrentUrl())) {
                    Jzvd currentJzvd = JzvdMgr.getCurrentJzvd();
                    if (currentJzvd != null && currentJzvd.currentScreen != Jzvd.SCREEN_WINDOW_FULLSCREEN) {
                        Jzvd.releaseAllVideos();
                    }
                }
            }
        });

//        mTopRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
//                    Glide.with(getActivity()).resumeRequests();
//                } else {
//                    Glide.with(getActivity()).pauseRequests();
//                }
//            }
//        });



        mBottomNestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                ILog.e(TAG1,"mBottomNestedScrollView----[onScrollChange]------>>");
//                Jzvd jzvd = view.findViewById(R.id.videoplayer);
//                if (ijkVideoView != null && ijkVideoView.jzDataSource.containsTheUrl(JZMediaManager.getCurrentUrl())) {
                if (ijkVideoView != null && ijkVideoView.currentState == CURRENT_STATE_PLAYING) {
                    Jzvd currentJzvd = JzvdMgr.getCurrentJzvd();
                    if (currentJzvd != null && currentJzvd.currentScreen != Jzvd.SCREEN_WINDOW_FULLSCREEN) {
                        Jzvd.releaseAllVideos();
                    }
                }
            }
        });


//        mTopRecyclerView.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() {
//            @Override
//            public void onChildViewAttachedToWindow(View view) {
//                ILog.e(TAG1,"mTopRecyclerView----[onChildViewAttachedToWindow]------>>");
//            }
//
//            @Override
//            public void onChildViewDetachedFromWindow(View view) {
////                IjkVideoView ijkVideoView = view.findViewById(R.id.video_player);
//
//                ILog.e(TAG1,"mTopRecyclerView----[addOnChildAttachStateChangeListener]------>>");
////                if (ijkVideoView != null && !ijkVideoView.isFullScreen() && ijkVideoView.isPlaying()){
////                    ILog.e(TAG1,"mTopRecyclerView----[addOnChildAttachStateChangeListener222]------>>");
////                    ijkVideoView.stopPlayback();
////                    ijkVideoView.release();
////                }
//            }
//        });
    }


    /**
     * 主粮数据设置
     */
    private List<String> bannerList;
    private List<Class<? extends ViewPager.PageTransformer>> transformers = new ArrayList<>();
    private BaseQuickAdapter mJxSoldAdapter;
    private BaseQuickAdapter mBrandGridAdaper;
    private JzvdStd ijkVideoView;

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    public class PetDogTabSnacksTopAdapter extends BaseMultiItemQuickAdapter<PetDogTabSnacksBean.Top_datas, BaseViewHolder> implements OnBannerListener {
        /**
         * Same as QuickAdapter#QuickAdapter(Context,int) but with
         * some initialization data.
         *
         * @param data A new list is created out of this one to avoid mutable list
         */
        public PetDogTabSnacksTopAdapter(List<PetDogTabSnacksBean.Top_datas> data) {
            super(data);
            addItemType(PetDogTabSnacksBean.Top_datas.BANNER1, R.layout.tab_home_banner1);
            addItemType(PetDogTabSnacksBean.Top_datas.MENU_SECOND_LEVEL, R.layout.tab_home_navigation_grid_list);
            addItemType(PetDogTabSnacksBean.Top_datas.DOUBLE_IMAGE, R.layout.tab_home_two_image);
            addItemType(PetDogTabSnacksBean.Top_datas.PlATE_SNAP_LINE, R.layout.tab_home_snap_line);
            addItemType(PetDogTabSnacksBean.Top_datas.PLATE_TITLE, R.layout.tab_home_title);//5
            addItemType(PetDogTabSnacksBean.Top_datas.PLATE_VIDEO, R.layout.tab_home_video1);
            addItemType(PetDogTabSnacksBean.Top_datas.SINGLE_PLATE, R.layout.tab_home_single_goods);
            addItemType(PetDogTabSnacksBean.Top_datas.PLATE_BRAND, R.layout.tab_home_brand);
            addItemType(PetDogTabSnacksBean.Top_datas.BANNER2, R.layout.tab_home_banner2);
            addItemType(PetDogTabSnacksBean.Top_datas.BANNER3, R.layout.tab_home_banner3);
        }

        @Override
        protected void convert(BaseViewHolder helper, PetDogTabSnacksBean.Top_datas item, int position) {
            final List<PetDogTabSnacksBean.Top_datas.Datalist> datalist = item.getDatalist();
            if (bannerList != null) bannerList.clear();
            else bannerList = new ArrayList<>();
            switch (item.getItemType()) {
                case 1://轮播图
                    List<String> titles = new ArrayList<>();
                    if (titles != null && titles.size() > 0) titles.clear();
                    Banner mBanner = (Banner) helper.getView(R.id.banner1);
                    initAnim();
                    //数据
                    for (PetDogTabSnacksBean.Top_datas.Datalist a : datalist) {
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
                            .setDelayTime(3000)
                            .start();
                    break;
                case 4:

                    break;
                case 8:
                    List<String> brandList = new ArrayList<>();
                    RecyclerView mBrandRecyclerView = (RecyclerView) helper.getView(R.id.brandRecycler);
                    mBrandRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
                    mBrandRecyclerView.addItemDecoration(new SpaceItemDecoration(getActivity()));
                    mBrandRecyclerView.setItemViewCacheSize(10);
                    mBrandRecyclerView.setAdapter(mBrandGridAdaper = new BaseQuickAdapter<String, BaseViewHolder>(R.layout.tab_home_brand_item, brandList) {
                        @Override
                        protected void convert(BaseViewHolder helper, String item, int position) {
                            ImageView brandCenterImage = (ImageView) helper.getView(R.id.brandimg);
                            Glide.with(mContext)
                                    .load(item)
                                    .asBitmap()
                                    .skipMemoryCache(false)
                                    .priority(Priority.HIGH)
                                    .dontTransform()
                                    .placeholder(R.mipmap.pet_image_loadding)
                                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                    .into(brandCenterImage);

                        }
                    });
                    for (PetDogTabSnacksBean.Top_datas.Datalist c : datalist) {
                        brandList.add(c.getImage());
                    }
                    mBrandGridAdaper.notifyDataSetChanged();
                    break;
                case 11:
                    List<String> bannerList = new ArrayList<>();
                    List<String> titles2 = new ArrayList<>();
                    Banner mBanner2 = (Banner) helper.getView(R.id.banner2);
                    if (titles2 != null && titles2.size() > 0) titles2.clear();
                    initAnim();
                    //数据
                    for (PetDogTabSnacksBean.Top_datas.Datalist a : datalist) {
                        String image = a.getImage();
                        bannerList.add(image);
                        titles2.add("");
                    }
                    //默认是NUM_INDICATOR_TITLE
                    mBanner2.setImages(bannerList)
//                            .setBannerTitles(titles)
                            .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                            .setIndicatorGravity(BannerConfig.CENTER)
                            .setImageLoader(new GlideImageLoader())
                            .setOnBannerListener(this)
                            .isAutoPlay(true)
                            .setBannerAnimation(transformers.get(1))
                            .setDelayTime(3000)
                            .start();
                    break;
                case 12:
                    List<String> bannerList3 = new ArrayList<>();
                    List<String> titles3 = new ArrayList<>();
                    Banner mBanner3 = (Banner) helper.getView(R.id.banner3);
                    if (titles3 != null && titles3.size() > 0) titles3.clear();
                    initAnim();
                    //数据
                    for (PetDogTabSnacksBean.Top_datas.Datalist a : datalist) {
                        String image = a.getImage();
                        bannerList3.add(image);
                        titles3.add("");
                    }
                    //默认是NUM_INDICATOR_TITLE
                    mBanner3.setImages(bannerList3)
//                            .setBannerTitles(titles)
                            .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                            .setIndicatorGravity(BannerConfig.CENTER)
                            .setImageLoader(new GlideImageLoader())
                            .setOnBannerListener(this)
                            .isAutoPlay(true)
                            .setBannerAnimation(transformers.get(1))
                            .setDelayTime(3000)
                            .start();
                    break;
                case 5:
                    final ImageView ivTitle = (ImageView) helper.getView(R.id.ivTitle);
                    Glide.with(mContext)
                            .load(item.getImage())
                            .asBitmap()
                            .skipMemoryCache(false)
                            .priority(Priority.NORMAL)
                            .dontTransform()
                            .placeholder(R.mipmap.pet_image_loadding)
                            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                            .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
                                @Override
                                public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                    ivTitle.setImageBitmap(resource);
                                }
                            });
                    break;
                case 6://视频
                    ijkVideoView = (JzvdStd) helper.getView(R.id.videoplayer);
                    String url = item.getDatalist().get(0).getUrl();
                    String video_name = item.getDatalist().get(0).getVideo_name();
                    String image4 = item.getFirst_img().getImage();
                    String url1 = "http://player.epetbar.com/afeb8ce2556043f9a1688d8919f032c1/242ab24d2a834e35a23313dc7a1ae88d-5287d2089db37e62345123a1be272f8b.mp4";
                    String url2 = "http://jzvd.nathen.cn/342a5f7ef6124a4a8faf00e738b8bee4/cf6d9db0bd4d41f59d09ea0a81e918fd-5287d2089db37e62345123a1be272f8b.mp4";
                    ijkVideoView.setUp(url, video_name,JzvdStd.SCREEN_WINDOW_NORMAL);
                    Glide.with(mContext)
                            .load(image4)
                            .into(ijkVideoView.thumbImageView);
//                    ijkVideoView.startVideo();


//                    final ImageView video_image = (ImageView) holder.getView(R.id.video_image);
//                    Glide.with(mContext)
//                            .load(item.getFirst_img().getImage())
//                            .asBitmap()
//                            .skipMemoryCache(false)
//                            .priority(Priority.NORMAL)
//                            .dontTransform()
//                            .placeholder(R.mipmap.pet_image_loadding)
//                            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                            .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
//                                @Override
//                                public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
////                                    BitmapDrawable bd= new BitmapDrawable(getActivity().getResources(), resource);
////                                    ijkVideoView.setBackgroundResource(R.mipmap.video1);
//                                }
//                            });
                    break;
                case 3:
                    final ImageView imageView1 = (ImageView) helper.getView(R.id.ivTwoImg1);
                    final ImageView imageView2 = (ImageView) helper.getView(R.id.ivTwoImg2);
                    String image = datalist.get(0).getImage();

//                    imageView1.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            CrashReport.testJavaCrash();
//                        }
//                    });

                    Glide.with(mContext)
                            .load(datalist.get(0).getImage())
                            .asBitmap()
                            .skipMemoryCache(false)
                            .priority(Priority.NORMAL)
                            .dontTransform()
                            .placeholder(R.mipmap.pet_image_loadding)
                            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                            .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
                                @Override
                                public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                    imageView1.setImageBitmap(resource);
                                }
                            });
                    Glide.with(mContext)
                            .load(datalist.get(1).getImage())
                            .asBitmap()
                            .skipMemoryCache(false)
                            .priority(Priority.NORMAL)
                            .dontTransform()
                            .placeholder(R.mipmap.pet_image_loadding)
                            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                            .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
                                @Override
                                public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                    imageView2.setImageBitmap(resource);
                                }
                            });
                    break;
                case 2://二级可切换菜单
                    RecyclerView mGridRecyclerView = (RecyclerView) helper.getView(R.id.gridRecyclerView);
                    RadioGroup rgpPlateNavigation = (RadioGroup) helper.getView(R.id.rgpPlateNavigation);
                    final ImageView ibnGCFood = (ImageView) helper.getView(R.id.ibnGCFood);
                    final ImageView ibnJKFood = (ImageView) helper.getView(R.id.ibnJKFood);
                    final ImageView ibnKWPF = (ImageView) helper.getView(R.id.ibnKWPF);
                    final ImageView ibnSinglePrice = (ImageView) helper.getView(R.id.ibnSinglePrice);
                    setPlateContentData(mGridRecyclerView, rgpPlateNavigation);
                    String image_choose = datalist.get(0).getImage_choose();
                    String image1 = datalist.get(1).getImage();
                    String image2 = datalist.get(2).getImage();
                    String image3 = datalist.get(3).getImage();
                    Glide.with(mContext)
                            .load(image_choose)
                            .asBitmap()
                            .skipMemoryCache(false)
                            .priority(Priority.NORMAL)
                            .dontTransform()
                            .placeholder(R.mipmap.pet_image_loadding)
                            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                            .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
                                @Override
                                public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                    ibnGCFood.setImageBitmap(resource);
                                }
                            });
                    Glide.with(mContext)
                            .load(image1)
                            .asBitmap()
                            .skipMemoryCache(false)
                            .priority(Priority.NORMAL)
                            .dontTransform()
                            .placeholder(R.mipmap.pet_image_loadding)
                            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                            .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
                                @Override
                                public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                    ibnJKFood.setImageBitmap(resource);
                                }
                            });
                    Glide.with(mContext)
                            .load(image2)
                            .asBitmap()
                            .skipMemoryCache(false)
                            .priority(Priority.NORMAL)
                            .dontTransform()
                            .placeholder(R.mipmap.pet_image_loadding)
                            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                            .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
                                @Override
                                public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                    ibnKWPF.setImageBitmap(resource);
                                }
                            });
                    Glide.with(mContext)
                            .load(image3)
                            .asBitmap()
                            .skipMemoryCache(false)
                            .priority(Priority.NORMAL)
                            .dontTransform()
                            .placeholder(R.mipmap.pet_image_loadding)
                            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                            .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
                                @Override
                                public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                    ibnSinglePrice.setImageBitmap(resource);
                                }
                            });

                    ibnGCFood.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String image_choose = datalist.get(0).getImage_choose();
                            String image1 = datalist.get(1).getImage();
                            String image2 = datalist.get(2).getImage();
                            String image3 = datalist.get(3).getImage();
                            Glide.with(mContext)
                                    .load(image_choose)
                                    .asBitmap()
                                    .skipMemoryCache(false)
                                    .priority(Priority.NORMAL)
                                    .dontTransform()
                                    .placeholder(R.mipmap.pet_image_loadding)
                                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                    .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
                                        @Override
                                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                            ibnGCFood.setImageBitmap(resource);
                                        }
                                    });
                            Glide.with(mContext)
                                    .load(image1)
                                    .asBitmap()
                                    .skipMemoryCache(false)
                                    .priority(Priority.NORMAL)
                                    .dontTransform()
                                    .placeholder(R.mipmap.pet_image_loadding)
                                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                    .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
                                        @Override
                                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                            ibnJKFood.setImageBitmap(resource);
                                        }
                                    });
                            Glide.with(mContext)
                                    .load(image2)
                                    .asBitmap()
                                    .skipMemoryCache(false)
                                    .priority(Priority.NORMAL)
                                    .dontTransform()
                                    .placeholder(R.mipmap.pet_image_loadding)
                                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                    .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
                                        @Override
                                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                            ibnKWPF.setImageBitmap(resource);
                                        }
                                    });
                            Glide.with(mContext)
                                    .load(image3)
                                    .asBitmap()
                                    .skipMemoryCache(false)
                                    .priority(Priority.NORMAL)
                                    .dontTransform()
                                    .placeholder(R.mipmap.pet_image_loadding)
                                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                    .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
                                        @Override
                                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                            ibnSinglePrice.setImageBitmap(resource);
                                        }
                                    });
                            getSnacksSecondPlateData(0);
                        }
                    });

                    //1
                    ibnJKFood.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String image_choose = datalist.get(1).getImage_choose();
                            String image0 = datalist.get(0).getImage();
                            String image2 = datalist.get(2).getImage();
                            String image3 = datalist.get(3).getImage();
                            Glide.with(mContext)
                                    .load(image_choose)
                                    .asBitmap()
                                    .skipMemoryCache(false)
                                    .priority(Priority.NORMAL)
                                    .dontTransform()
                                    .placeholder(R.mipmap.pet_image_loadding)
                                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                    .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
                                        @Override
                                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                            ibnJKFood.setImageBitmap(resource);
                                        }
                                    });
                            Glide.with(mContext)
                                    .load(image0)
                                    .asBitmap()
                                    .skipMemoryCache(false)
                                    .priority(Priority.NORMAL)
                                    .dontTransform()
                                    .placeholder(R.mipmap.pet_image_loadding)
                                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                    .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
                                        @Override
                                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                            ibnGCFood.setImageBitmap(resource);
                                        }
                                    });
                            Glide.with(mContext)
                                    .load(image2)
                                    .asBitmap()
                                    .skipMemoryCache(false)
                                    .priority(Priority.NORMAL)
                                    .dontTransform()
                                    .placeholder(R.mipmap.pet_image_loadding)
                                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                    .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
                                        @Override
                                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                            ibnKWPF.setImageBitmap(resource);
                                        }
                                    });
                            Glide.with(mContext)
                                    .load(image3)
                                    .asBitmap()
                                    .skipMemoryCache(false)
                                    .priority(Priority.NORMAL)
                                    .dontTransform()
                                    .placeholder(R.mipmap.pet_image_loadding)
                                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                    .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
                                        @Override
                                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                            ibnSinglePrice.setImageBitmap(resource);
                                        }
                                    });
                            getSnacksSecondPlateData(1);
                        }
                    });


                    //2
                    ibnKWPF.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String image_choose = datalist.get(2).getImage_choose();
                            String image0 = datalist.get(0).getImage();
                            String image1 = datalist.get(1).getImage();
                            String image3 = datalist.get(3).getImage();
                            Glide.with(mContext)
                                    .load(image_choose)
                                    .asBitmap()
                                    .skipMemoryCache(false)
                                    .priority(Priority.NORMAL)
                                    .dontTransform()
                                    .placeholder(R.mipmap.pet_image_loadding)
                                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                    .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
                                        @Override
                                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                            ibnKWPF.setImageBitmap(resource);
                                        }
                                    });
                            Glide.with(mContext)
                                    .load(image0)
                                    .asBitmap()
                                    .skipMemoryCache(false)
                                    .priority(Priority.NORMAL)
                                    .dontTransform()
                                    .placeholder(R.mipmap.pet_image_loadding)
                                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                    .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
                                        @Override
                                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                            ibnGCFood.setImageBitmap(resource);
                                        }
                                    });
                            Glide.with(mContext)
                                    .load(image1)
                                    .asBitmap()
                                    .skipMemoryCache(false)
                                    .priority(Priority.NORMAL)
                                    .dontTransform()
                                    .placeholder(R.mipmap.pet_image_loadding)
                                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                    .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
                                        @Override
                                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                            ibnJKFood.setImageBitmap(resource);
                                        }
                                    });
                            Glide.with(mContext)
                                    .load(image3)
                                    .asBitmap()
                                    .skipMemoryCache(false)
                                    .priority(Priority.NORMAL)
                                    .dontTransform()
                                    .placeholder(R.mipmap.pet_image_loadding)
                                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                    .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
                                        @Override
                                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                            ibnSinglePrice.setImageBitmap(resource);
                                        }
                                    });
                            getSnacksSecondPlateData(2);
                        }
                    });


                    //3
                    ibnSinglePrice.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String image_choose = datalist.get(3).getImage_choose();
                            String image0 = datalist.get(0).getImage();
                            String image1 = datalist.get(1).getImage();
                            String image2 = datalist.get(2).getImage();
                            Glide.with(mContext)
                                    .load(image_choose)
                                    .asBitmap()
                                    .skipMemoryCache(false)
                                    .priority(Priority.NORMAL)
                                    .dontTransform()
                                    .placeholder(R.mipmap.pet_image_loadding)
                                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                    .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
                                        @Override
                                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                            ibnSinglePrice.setImageBitmap(resource);
                                        }
                                    });
                            Glide.with(mContext)
                                    .load(image0)
                                    .asBitmap()
                                    .skipMemoryCache(false)
                                    .priority(Priority.NORMAL)
                                    .dontTransform()
                                    .placeholder(R.mipmap.pet_image_loadding)
                                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                    .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
                                        @Override
                                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                            ibnGCFood.setImageBitmap(resource);
                                        }
                                    });
                            Glide.with(mContext)
                                    .load(image1)
                                    .asBitmap()
                                    .skipMemoryCache(false)
                                    .priority(Priority.NORMAL)
                                    .dontTransform()
                                    .placeholder(R.mipmap.pet_image_loadding)
                                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                    .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
                                        @Override
                                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                            ibnJKFood.setImageBitmap(resource);
                                        }
                                    });

                            Glide.with(mContext)
                                    .load(image2)
                                    .asBitmap()
                                    .skipMemoryCache(false)
                                    .priority(Priority.NORMAL)
                                    .dontTransform()
                                    .placeholder(R.mipmap.pet_image_loadding)
                                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                    .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
                                        @Override
                                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                            ibnKWPF.setImageBitmap(resource);
                                        }
                                    });
                            getSnacksSecondPlateData(3);
                        }
                    });
                    break;
                default:
                    break;

            }
        }

        /**
         * 轮播图
         *
         * @param position
         */
        @Override
        public void OnBannerClick(int position) {
            ToastsUtils.showShort("主粮轮播图，点击了：" + position);
        }
    }


    /**
     * 精选活动
     */
    public class JxSoldAdapter extends BaseQuickAdapter<PetDogTabSnacksSecondListBean.Bottom_goods_list.Datalist, BaseViewHolder> {
        public JxSoldAdapter(int layoutResId, List<PetDogTabSnacksSecondListBean.Bottom_goods_list.Datalist> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, PetDogTabSnacksSecondListBean.Bottom_goods_list.Datalist item, int position) {
            ImageView jxImageIcon = (ImageView) helper.getView(R.id.jxImageIcon);
//            TextView tvJxTitle = (TextView) helper.getView(R.id.tvJxTitle);
            ImageView ivJxIconSold = (ImageView) helper.getView(R.id.ivJxIconSold);
            TextView tvJxIconSold2 = (TextView) helper.getView(R.id.tvJxIconSold2);
            TextView tvJxCurerntPrice = (TextView) helper.getView(R.id.tvJxCurerntPrice);
            TextView tvJxOldPrice = (TextView) helper.getView(R.id.tvJxOldPrice);
            TextView tvHuDong = (TextView) helper.getView(R.id.tvHuDong);
            TextView tvSoldNum = (TextView) helper.getView(R.id.tvSoldNum);
            ImageView ivShopcart = (ImageView) helper.getView(R.id.ivShopcart);
            helper.setText(R.id.tvJxTitle, item.getSubject() == null ? "" : item.getSubject());
            helper.setText(R.id.tvJxCurerntPrice, item.getSale_price() == null ? "" : item.getSale_price());
            helper.setText(R.id.tvJxOldPrice, item.getMarket_price() == null ? "" : item.getMarket_price());
            helper.setText(R.id.tvHuDong, item.getComments() == null ? "" : item.getComments());
            helper.setText(R.id.tvSoldNum, item.getSold() == null ? "" : item.getSold());
            ViewUtils.setPriceLine(tvJxOldPrice, 0);
            Glide.with(mContext)
                    .load(item.getPhoto())
                    .asBitmap()
                    .skipMemoryCache(false)
                    .priority(Priority.HIGH)
                    .dontTransform()
                    .placeholder(R.mipmap.pet_image_loadding)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(jxImageIcon);
            if (item.getActivityIcons()) {
                if (TextUtils.isEmpty(item.getIcon_char())) {
                    ivJxIconSold.setVisibility(View.VISIBLE);
                    tvJxIconSold2.setVisibility(GONE);
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
                    tvJxIconSold2.setVisibility(View.VISIBLE);
                    ivJxIconSold.setVisibility(GONE);
                    tvJxIconSold2.setText(item.getIcon_char());
                }
            } else {
                ivJxIconSold.setVisibility(GONE);
            }
            ivShopcart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastsUtils.showShort("加入购物车");
                }
            });

        }
    }


    /**
     * 二级商品导航
     *
     * @param mPlateRecyvlerView
     * @param rbnPlateNavigation
     */
    SecondPlateAdaper mSecondPlateAdaper;

    private void setPlateContentData(RecyclerView mPlateRecyvlerView, RadioGroup rgpPlateNavigation) {
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 3);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mPlateRecyvlerView.setLayoutManager(layoutManager);
        mPlateRecyvlerView.setHasFixedSize(true);
        mPlateRecyvlerView.setItemViewCacheSize(3);
        rgpPlateNavigation.check(rgpPlateNavigation.getChildAt(0).getId());
        mSecondPlateAdaper = new SecondPlateAdaper(R.layout.item_tab_home_second_plate_grid_item, nineImages);
        mPlateRecyvlerView.setAdapter(mSecondPlateAdaper);
        getSnacksSecondPlateData(0);
    }


    public class SecondPlateAdaper extends BaseQuickAdapter<String, BaseViewHolder> {
        public SecondPlateAdaper(int layoutResId, List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item, int position) {
            int adapterPosition = helper.getAdapterPosition();
            ImageView ivPlateGridView = (ImageView) helper.getView(R.id.ivSecondPlateGridView);
            Glide.with(mContext)
                    .load(item)
                    .asBitmap()
                    .skipMemoryCache(false)
                    .priority(Priority.HIGH)
                    .dontTransform()
                    .placeholder(R.mipmap.pet_image_loadding)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(ivPlateGridView);
        }
    }


    /**
     * 获取零食上部分列表数据
     */
    private void getSnacksTopListData() {
        if (topDatasList != null) topDatasList.clear();
        else topDatasList = new ArrayList<>();

        //主粮一级数据
        String json = FileUtils.getJson(getActivity(), "pet_tab_home_snack_top.json");
        Gson gson = new Gson();
        Type type = new TypeToken<PetDogTabSnacksBean>() {
        }.getType();
        PetDogTabSnacksBean PetDogTabSnacksBean = gson.fromJson(json, type);
        List<PetDogTabSnacksBean.Top_datas> top_datas = PetDogTabSnacksBean.getTop_datas();
        topDatasList.addAll(top_datas);
        mAdapter.notifyDataSetChanged();
        ILog.e(TAG1, "获取上部分零食数据----------->>:" + new Gson().toJson(top_datas));
    }


    /**
     * 获取零食下部分导航页签数据
     */
    private void getSnacksBottomTitle() {
        String json1 = FileUtils.getJson(getActivity(), "pet_tab_home_snack_top_list.json");
        Gson gson1 = new Gson();
        Type type1 = new TypeToken<PetDogTabSnacksSecondListBean>() {
        }.getType();
        PetDogTabSnacksSecondListBean petDogTabSnacksSecondListBean = gson1.fromJson(json1, type1);
        PetDogTabSnacksSecondListBean.Bottom_Title bottom_title = petDogTabSnacksSecondListBean.getBottom_Title();
        mLlBottomTitle.setVisibility(View.VISIBLE);
        Glide.with(getMyActivity())
                .load(bottom_title.getImage())
                .asBitmap()
                .skipMemoryCache(false)
                .priority(Priority.NORMAL)
                .dontTransform()
                .placeholder(R.mipmap.pet_image_loadding)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        mIvBottomTitleImg.setImageBitmap(resource);
                    }
                });
        ILog.e(TAG1, "获取下部分bottom_title数据----------->>:" + new Gson().toJson(bottom_title));
    }

    /**
     * 获取零食下部分导航页签数据
     */
    private void getSnacksBottomMenuTab() {
        if (bottomMenuList != null) bottomMenuList.clear();
        else bottomMenuList = new ArrayList<>();

        String json1 = FileUtils.getJson(getActivity(), "pet_tab_home_snack_top_list.json");
        Gson gson1 = new Gson();
        Type type1 = new TypeToken<PetDogTabSnacksSecondListBean>() {
        }.getType();
        PetDogTabSnacksSecondListBean petDogTabSnacksSecondListBean = gson1.fromJson(json1, type1);
        List<PetDogTabSnacksSecondListBean.Bottom_menu_list> bottom_menu_list = petDogTabSnacksSecondListBean.getBottom_menu_list();
        bottomMenuList.addAll(bottom_menu_list);
        ILog.e(TAG1, "获取下部分bottom_menu_list数据----------->>:" + new Gson().toJson(bottom_menu_list));


        for(int i=0; i < bottomMenuList.size(); i++) {
            RadioButton radioButton = new RadioButton(getMyActivity());
            radioButton.setId(i);
            //设置RadioButton的背景
            radioButton.setBackgroundResource(R.drawable.selector_button_jingxuan);
            //设置RadioButton的文本字体颜色
            radioButton.setTextColor(getResources().getColorStateList(R.color.color_selector_textview));
            //设置按钮的样式
            radioButton.setButtonDrawable(null);
            //设置文字距离按钮四周的距离
            radioButton.setPadding(50, 0, 50, 0);
            //设置按钮文本
            radioButton.setText(bottomMenuList.get(i).getMenu_name());
            radioButton.setTextSize(11.0f);
            //设置字体加粗 true:加粗
            TextPaint tp = radioButton.getPaint();
            tp.setFakeBoldText(false);
            //设置RadioButton间距margin
            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(10,0,10,0);
            //容器组装
            mRgpSnackfood.addView(radioButton, params);
        }
        //设置默认值
        mRgpSnackfood.check(0);

        mRgpSnackfood.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                ToastsUtils.showShort("零食选中："+bottomMenuList.get(checkedId).getMenu_name()+"  "+checkedId);
                ILog.e(TAG1,"零食选中："+bottomMenuList.get(checkedId).getMenu_name()+"  "+checkedId);
                getSnacksBottomSubTabData(checkedId);
                new RecyclerViewHorizonScrollHelper().horizontalScrollViewTo(getActivity(),group.getChildAt(checkedId),mHorizontalScrollView);

                // 通过RadioGroup的findViewById方法，找到ID为checkedID的RadioButton
//                RadioButton tempButton = (RadioButton)group.findViewById(checkedId);
//                tempButton.setTextColor(getResources().getColor(R.color.red));
//                mRgpSnackfood.check(checkedId);

            }
        });
    }


    /**
     * 获取二级板块导航数据
     */
    private void getSnacksSecondPlateData(int i) {
        //板块导航数据
        String json1 = FileUtils.getJson(getActivity(), "pet_tab_home_snack_top_list.json");
        Gson gson1 = new Gson();
        Type type1 = new TypeToken<PetDogTabSnacksSecondListBean>() {
        }.getType();
        PetDogTabSnacksSecondListBean petDogTabSnacksSecondListBean = gson1.fromJson(json1, type1);
        List<PetDogTabSnacksSecondListBean.Menu1> menu1 = petDogTabSnacksSecondListBean.getMenu1();

        if (nineImages != null) nineImages.clear();
        else nineImages = new ArrayList<>();
        if (i == 0) {
            List<PetDogTabSnacksSecondListBean.Menu1.Menus_content> menus_content0 = menu1.get(0).getMenus_content();
            for (int j = 0; j < menus_content0.size(); j++) {
                String image = menus_content0.get(j).getImage();
                nineImages.add(image);
            }
            ILog.e(TAG1, "获取二级板块导航数据----------->>:" + new Gson().toJson(menus_content0));
        } else if (i == 1) {
            List<PetDogTabSnacksSecondListBean.Menu1.Menus_content> menus_content1 = menu1.get(1).getMenus_content();
            for (int j = 0; j < menus_content1.size(); j++) {
                String image = menus_content1.get(j).getImage();
                nineImages.add(image);
            }
            ILog.e(TAG1, "获取二级板块导航数据----------->>:" + new Gson().toJson(menus_content1));
        } else if (i == 2) {
            List<PetDogTabSnacksSecondListBean.Menu1.Menus_content> menus_content2 = menu1.get(2).getMenus_content();
            for (int j = 0; j < menus_content2.size(); j++) {
                String image = menus_content2.get(j).getImage();
                nineImages.add(image);
            }
            ILog.e(TAG1, "获取二级板块导航数据----------->>:" + new Gson().toJson(menus_content2));
        } else if (i == 3) {
            List<PetDogTabSnacksSecondListBean.Menu1.Menus_content> menus_content3 = menu1.get(3).getMenus_content();
            for (int j = 0; j < menus_content3.size(); j++) {
                String image = menus_content3.get(j).getImage();
                nineImages.add(image);
            }
            ILog.e(TAG1, "获取二级板块导航数据----------->>:" + new Gson().toJson(menus_content3));
        }
        mSecondPlateAdaper.notifyDataSetChanged();
    }


    /**
     * 获取零食底部列表Tab数据
     */
    private void getSnacksBottomSubTabData(int tabIndex) {
        if (bottomGoodList != null) bottomGoodList.clear();
        else bottomGoodList = new ArrayList<>();

        String json = FileUtils.getJson(getActivity(), "pet_tab_home_snack_top_list.json");
        Gson gson = new Gson();
        Type type = new TypeToken<PetDogTabSnacksSecondListBean>() {
        }.getType();
        PetDogTabSnacksSecondListBean petDogTabSnacksSecondListBean = gson.fromJson(json, type);
        List<PetDogTabSnacksSecondListBean.Bottom_goods_list> bottom_goods_list = petDogTabSnacksSecondListBean.getBottom_goods_list();
        PetDogTabSnacksSecondListBean.Bottom_goods_list bottom_goods_list1 = bottom_goods_list.get(tabIndex);
        List<PetDogTabSnacksSecondListBean.Bottom_goods_list.Datalist> datalist = bottom_goods_list1.getDatalist();
        bottomGoodList.addAll(datalist);
        mJxSoldAdapter.notifyDataSetChanged();
        if (bottomGoodList != null && bottomGoodList.size() > 0) {
            new RecyclerViewHorizonScrollHelper().smoothMoveToPosition(mBottomRecyclerview, 0);
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

    @Override
    public void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }

    @Override
    public void onResume() {
        super.onResume();
        Jzvd.releaseAllVideos();
//        if (ijkVideoView != null){
//            ijkVideoView.resume();
//        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Jzvd.releaseAllVideos();
//        if (ijkVideoView != null){
//            ijkVideoView.release();
//        }
    }

}