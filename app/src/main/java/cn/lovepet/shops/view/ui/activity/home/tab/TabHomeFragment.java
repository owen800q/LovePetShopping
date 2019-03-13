package cn.lovepet.shops.view.ui.activity.home.tab;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
//import com.github.library.BaseMultiItemQuickAdapter;
//import com.github.library.BaseQuickAdapter;
//import com.github.library.BaseViewHolder;
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
import cn.lovepet.shops.bean.PetDogTabHomeBean;
import cn.lovepet.shops.helper.basequickadapter.BaseMultiItemQuickAdapter;
import cn.lovepet.shops.helper.basequickadapter.BaseQuickAdapter;
import cn.lovepet.shops.helper.basequickadapter.BaseViewHolder;
import cn.lovepet.shops.helper.glide.GlideImageLoader;
import cn.lovepet.shops.util.FileUtils;
import cn.lovepet.shops.util.ILog;
import cn.lovepet.shops.util.ToastsUtils;
import cn.lovepet.shops.util.ViewUtils;
/**
 * @author JSYL-DCL
 * @date 2018/10/29 10:48
 * @des
 */
public class TabHomeFragment extends BaseFragment {
    private static final String TAG1 = TabHomeFragment.class.getSimpleName();
    private DogTabHomeAdapter mAdapter;
    private List<PetDogTabHomeBean.DogListData> tabHomeDatas;
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;
//    @BindView(R.id.nestedScrollView)
//    NestedScrollView mNestedScrollView;

    public static TabHomeFragment newInstance() {
        TabHomeFragment fragment = new TabHomeFragment();
        return fragment;
    }
    @Override
    protected int setImmersiveStatusBarColor() {
        return 0;
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_home_tab_home;
    }

    @Override
    protected void init() {
        tabHomeDatas = new ArrayList<>();
        if (tabHomeDatas != null && tabHomeDatas.size() > 0)tabHomeDatas.clear();
    }

    @Override
    protected void bindView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemViewCacheSize(10);
        mAdapter = new DogTabHomeAdapter(tabHomeDatas);
        //防止数据错乱
        mAdapter.setHasStableIds(true);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    Glide.with(getActivity()).resumeRequests();
                }else {
                    Glide.with(getActivity()).pauseRequests();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        getTabHomeData();
    }

    @Override
    protected void bindData(Bundle savedInstanceState) {

    }

    @Override
    protected void bindListener() {
    }


    BaseQuickAdapter mNineAdaper;
    BaseQuickAdapter mHorizantalAdaper;
    BaseQuickAdapter mImgAdaper;
    List<Class<? extends ViewPager.PageTransformer>> transformers = new ArrayList<>();
    List<String> bannerList;
     public class DogTabHomeAdapter extends BaseMultiItemQuickAdapter<PetDogTabHomeBean.DogListData, BaseViewHolder> implements OnBannerListener {
        /**
         * Same as QuickAdapter#QuickAdapter(Context,int) but with
         * some initialization data.
         *
         * @param data A new list is created out of this one to avoid mutable list
         */
        public DogTabHomeAdapter(List<PetDogTabHomeBean.DogListData> data) {
            super(data);
            addItemType(PetDogTabHomeBean.DogListData.MULTISIZEIMAGE, R.layout.item_pet_tab_home_multisizeimage);
            addItemType(PetDogTabHomeBean.DogListData.BANNER, R.layout.item_pet_tab_home_banner);
            addItemType(PetDogTabHomeBean.DogListData.TITLE, R.layout.item_pet_tab_home_title);
            addItemType(PetDogTabHomeBean.DogListData.MENU, R.layout.item_pet_tab_home_ninemenu);
            addItemType(PetDogTabHomeBean.DogListData.MENU2, R.layout.item_pet_tab_home_menuimage);
            addItemType(PetDogTabHomeBean.DogListData.HORIZONTAL_SCOROLL, R.layout.item_pet_tab_home_horizantal);
            addItemType(PetDogTabHomeBean.DogListData.IMG, R.layout.item_pet_tab_home_image);
            addItemType(PetDogTabHomeBean.DogListData.VIDEO, R.layout.item_pet_tab_home_video);
            addItemType(PetDogTabHomeBean.DogListData.FOOTER, R.layout.item_pet_tab_home_footer);

        }

         @Override
         protected void convert(BaseViewHolder helper, PetDogTabHomeBean.DogListData item, int position) {
             List<PetDogTabHomeBean.DogListData.Value> value = item.getValue();
             switch (item.getItemType()) {
                 case 0://MULTISIZEIMAGE //新品馆
//                    baseViewHolder.setImageDrawable(bigImage)
                     ImageView bigImage = (ImageView)helper.getView(R.id.bigImage);
                     ImageView smallImageTop = (ImageView)helper.getView(R.id.smallImageTop);
                     ImageView smallImageBottom = (ImageView)helper.getView(R.id.smallImageBottom);
                     PetDogTabHomeBean.DogListData.Value value0 = value.get(0);
                     PetDogTabHomeBean.DogListData.Value value1 = value.get(1);
                     PetDogTabHomeBean.DogListData.Value value2 = value.get(2);
                     String imageSrc0 = value0.getImage();
                     String imageSrc1 = value1.getImage();
                     String imageSrc2 = value2.getImage();
                     Glide.with(mContext)
                             .load(imageSrc0)
                             .asBitmap()
                             .skipMemoryCache(false)
                             .priority(Priority.HIGH)
                             .dontTransform()
                             .placeholder(R.mipmap.pet_image_loadding)
                             .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                             .into(bigImage);
                     Glide.with(mContext)
                             .load(imageSrc1)
                             .asBitmap()
                             .skipMemoryCache(false)
                             .priority(Priority.HIGH)
                             .dontTransform()
                             .placeholder(R.mipmap.pet_image_loadding)
                             .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                             .into(smallImageTop);
                     Glide.with(mContext)
                             .load(imageSrc2)
                             .asBitmap()
                             .skipMemoryCache(false)
                             .priority(Priority.HIGH)
                             .dontTransform()
                             .placeholder(R.mipmap.pet_image_loadding)
                             .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                             .into(smallImageBottom);
                     break;
                 case 1://轮播图
                     bannerList = new ArrayList<>();
                     List<String> titles=new ArrayList<>();
                     if (bannerList != null && bannerList.size() > 0)bannerList.clear();
                     if (titles != null && titles.size() > 0)titles.clear();
                     Banner mBanner = (Banner)helper.getView(R.id.banner);
                     initAnim();
                     //数据
                     for (PetDogTabHomeBean.DogListData.Value a: value) {
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
                 case 2://板块头标题
                     String imageSrcStr = "";
                     int imageSrcInt = R.mipmap.pet_image_loadding;
                     boolean isLocal = false;
                     String titleNameSrc = item.getImage();
                     String type_name = item.getType_name();
                     String type_title = item.getType_title();
                     ImageView titleName = (ImageView) helper.getView(R.id.titleName);
                     if (type_name.equals("新小主专区title")){
                         helper.getView(R.id.llTitleTimer).setVisibility(View.GONE);
                         helper.getView(R.id.llTitleMore).setVisibility(View.GONE);
                         isLocal = false;
                     }else  if (type_name.equals("品质特卖头")){
                         helper.getView(R.id.llTitleTimer).setVisibility(View.GONE);
                         helper.getView(R.id.llTitleMore).setVisibility(View.VISIBLE);
                         imageSrcInt = R.mipmap.title_pztm;
                         isLocal = true;
                     }else  if (type_name.equals("VIP俱乐部title")){
                         helper.getView(R.id.llTitleTimer).setVisibility(View.GONE);
                         helper.getView(R.id.llTitleMore).setVisibility(View.VISIBLE);
                         imageSrcInt = R.mipmap.title_vip;
                         isLocal = true;
                     }else  if (type_name.equals("萌爪联盟title")){
                         helper.getView(R.id.llTitleTimer).setVisibility(View.GONE);
                         helper.getView(R.id.llTitleMore).setVisibility(View.VISIBLE);
                         imageSrcInt = R.mipmap.title_mzlm;
                         isLocal = true;
                     }else  if (type_name.equals("小剧场title")){
                         helper.getView(R.id.llTitleTimer).setVisibility(View.GONE);
                         helper.getView(R.id.llTitleMore).setVisibility(View.VISIBLE);
                         imageSrcInt = R.mipmap.title_xjc_video;
                         isLocal = true;
                     }

                     if (isLocal) {
                         Glide.with(mContext)
                                 .load(imageSrcInt)
                                 .asBitmap()
                                 .skipMemoryCache(false)
                                 .priority(Priority.HIGH)
                                 .dontTransform()
                                 .placeholder(R.mipmap.pet_image_loadding)
                                 .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                 .into(titleName);
                     }else {
                         Glide.with(mContext)
                                 .load(titleNameSrc)
                                 .asBitmap()
                                 .skipMemoryCache(false)
                                 .priority(Priority.HIGH)
                                 .dontTransform()
                                 .placeholder(R.mipmap.pet_image_loadding)
                                 .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                 .into(titleName);
                     }

                     if (type_title.equals("fq123")){
                         helper.getView(R.id.llTitleTimer).setVisibility(View.VISIBLE);
                         helper.getView(R.id.llTitleMore).setVisibility(View.VISIBLE);
                         Glide.with(mContext)
                                 .load(R.mipmap.title_dayfengqiang)
                                 .asBitmap()
                                 .skipMemoryCache(false)
                                 .priority(Priority.HIGH)
                                 .dontTransform()
                                 .placeholder(R.mipmap.pet_image_loadding)
                                 .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                 .into(titleName);
                     }
                     break;
                 case 3://九宫格
                     List<String> nineImages = new ArrayList<>();
                     if (nineImages != null && nineImages.size() > 0)nineImages.clear();
                     RecyclerView mNineRecyclerView = (RecyclerView) helper.getView(R.id.mNineRecyclerView);
                     mNineRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),5));
                     mNineRecyclerView.setHasFixedSize(true);
                     mNineRecyclerView.setItemViewCacheSize(10);
                     for (PetDogTabHomeBean.DogListData.Value a: value) {
                         String image = a.getImage();
                         nineImages.add(image);
                     }
                     ILog.e(TAG1,"nineImages>>>>>>>>>>>>>:"+new Gson().toJson(nineImages));
                     mNineRecyclerView.setAdapter(mNineAdaper = new BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_nine_menu, nineImages) {
                         @Override
                         protected void convert(BaseViewHolder helper, String item, int position) {
                             int adapterPosition = helper.getAdapterPosition();
                             ImageView ivGridView = (ImageView) helper.getView(R.id.ivGridView);
                             Glide.with(mContext)
                                     .load(item)
                                     .asBitmap()
                                     .skipMemoryCache(false)
                                     .priority(Priority.HIGH)
                                     .dontTransform()
                                     .placeholder(R.mipmap.pet_image_loadding)
                                     .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                     .into(ivGridView);
                         }
                     });


                     break;
                 case 4://menu2
                     List<String> menu2Images = new ArrayList<>();
                     if (menu2Images != null && menu2Images.size() > 0)menu2Images.clear();
                     for (PetDogTabHomeBean.DogListData.Value a: value) {
                         menu2Images.add(a.getImage());
                     }
                     ImageView view1 = (ImageView) helper.getView(R.id.ivMenu2a);
                     ImageView view2 = (ImageView) helper.getView(R.id.ivMenu2b);
                     ImageView view3 = (ImageView) helper.getView(R.id.ivMenu2c);
                     Glide.with(mContext)
                             .load(menu2Images.get(0))
                             .asBitmap()
                             .skipMemoryCache(false)
                             .priority(Priority.HIGH)
                             .dontTransform()
                             .placeholder(R.mipmap.pet_image_loadding)
                             .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                             .into(view1);
                     Glide.with(mContext)
                             .load(menu2Images.get(1))
                             .asBitmap()
                             .skipMemoryCache(false)
                             .priority(Priority.HIGH)
                             .dontTransform()
                             .placeholder(R.mipmap.pet_image_loadding)
                             .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                             .into(view2);
                     Glide.with(mContext)
                             .load(menu2Images.get(2))
                             .asBitmap()
                             .skipMemoryCache(false)
                             .priority(Priority.HIGH)
                             .dontTransform()
                             .placeholder(R.mipmap.pet_image_loadding)
                             .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                             .into(view3);
                     break;
                 case 5://横向滑动商品区
                     RecyclerView mHorizantalRecyclerview = (RecyclerView) helper.getView(R.id.horizantalRecyclerview);
                     LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                     linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                     mHorizantalRecyclerview.setLayoutManager(linearLayoutManager);
//                    mHorizantalRecyclerview.setHasFixedSize(true);
                     mHorizantalRecyclerview.setItemViewCacheSize(10);
                     ILog.e(TAG1,"横向滑动商品区>>>>>>>>>>>>>:"+new Gson().toJson(value));
                     mHorizantalRecyclerview.setAdapter(mHorizantalAdaper = new BaseQuickAdapter<PetDogTabHomeBean.DogListData.Value, BaseViewHolder>(R.layout.item_pet_tab_home_horizantal_item, value) {
                         @Override
                         protected void convert(BaseViewHolder helper, PetDogTabHomeBean.DogListData.Value item, int position) {
                             int adapterPosition = helper.getAdapterPosition();
                             ImageView saleIvImage = (ImageView) helper.getView(R.id.saleIvImage);
                             TextView saleTvNowPrice = (TextView) helper.getView(R.id.saleTvNowPrice);
                             TextView saleTvOldPrice = (TextView) helper.getView(R.id.saleTvOldPrice);
                             Glide.with(mContext)
                                     .load(item.getImage())
                                     .asBitmap()
                                     .skipMemoryCache(false)
                                     .priority(Priority.HIGH)
                                     .dontTransform()
                                     .placeholder(R.mipmap.pet_image_loadding)
                                     .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                     .into(saleIvImage);
                             saleTvNowPrice.setText(item.getSale_price().toString());
                             saleTvOldPrice.setText(item.getLittle_price().toString());
                             ViewUtils.setPriceLine(saleTvOldPrice,0);
                         }
                     });
                     break;
                 case 6://单图
                     RecyclerView imgRecyclerview = (RecyclerView) helper.getView(R.id.imgRecyclerview);
                     imgRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
                     imgRecyclerview.setHasFixedSize(true);
                     imgRecyclerview.setItemViewCacheSize(10);
                     imgRecyclerview.setAdapter(mImgAdaper = new BaseQuickAdapter<PetDogTabHomeBean.DogListData.Value, BaseViewHolder>(R.layout.item_pet_tab_home_single_img_item, value) {
                         @Override
                         protected void convert(BaseViewHolder helper, PetDogTabHomeBean.DogListData.Value item, int position) {
                             int adapterPosition = helper.getAdapterPosition();
                             ImageView ivSingleImage = (ImageView) helper.getView(R.id.ivSingleImage);
                             String image = item.getImage();
                             Glide.with(mContext)
                                     .load(image)
                                     .asBitmap()
                                     .skipMemoryCache(false)
                                     .priority(Priority.HIGH)
                                     .dontTransform()
                                     .placeholder(R.mipmap.pet_image_loadding)
                                     .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                     .into(ivSingleImage);
                         }
                     });

                     break;
                 case 7://video
                     PetDogTabHomeBean.DogListData.Value value3 = value.get(0);
                     String title_image = value3.getTitle_image();
                     ImageView ivVideoImage = (ImageView) helper.getView(R.id.ivVideoImage);
                     TextView ivVideoTitleName = (TextView) helper.getView(R.id.ivVideoTitleName);
                     TextView ivVideoWatchnum = (TextView) helper.getView(R.id.ivVideoWatchnum);
                     TextView ivVideoTotalTime = (TextView) helper.getView(R.id.ivVideoTotalTime);
                     Glide.with(mContext)
                             .load(title_image)
                             .asBitmap()
                             .skipMemoryCache(false)
                             .priority(Priority.HIGH)
                             .dontTransform()
                             .placeholder(R.mipmap.pet_image_loadding)
                             .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                             .into(ivVideoImage);
                     ivVideoTitleName.setText(value3.getTitle());
                     ivVideoWatchnum.setText(value3.getWatchnum()+"");
                     ivVideoTotalTime.setText(value3.getTotaltime());
                     break;
                 case 13://footer
                     ImageView ivFooter = (ImageView) helper.getView(R.id.ivFooter);
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
             ToastsUtils.showShort("轮播图，点击了："+position);
         }
     }


    private void initAnim() {
        transformers.add(DefaultTransformer.class);
        transformers.add(AccordionTransformer.class);
        transformers.add(BackgroundToForegroundTransformer.class);
        transformers.add(ForegroundToBackgroundTransformer.class);
        transformers.add(CubeInTransformer.class);//兼容问题，慎用
        transformers.add(CubeOutTransformer.class);
        transformers.add(com.youth.banner.transformer.DepthPageTransformer.class);
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
    public void onDestroy() {
        super.onDestroy();
        if (tabHomeDatas != null && tabHomeDatas.size() > 0) {
            tabHomeDatas.clear();
        }
    }

    private void getTabHomeData() {
        String json = FileUtils.getJson(getActivity(), "pet_dog_all.json");
        Gson gson = new Gson();
        Type type = new TypeToken<PetDogTabHomeBean>() {}.getType();
        PetDogTabHomeBean petDogTabHomeBean = gson.fromJson(json, type);
        List<PetDogTabHomeBean.DogListData> data = petDogTabHomeBean.getData();
        String message = petDogTabHomeBean.getMessage();
        tabHomeDatas.addAll(data);
        mAdapter.notifyDataSetChanged();
    }
}