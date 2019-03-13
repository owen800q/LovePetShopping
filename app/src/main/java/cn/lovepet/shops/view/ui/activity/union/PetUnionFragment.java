package cn.lovepet.shops.view.ui.activity.union;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;
//import com.github.library.BaseMultiItemQuickAdapter;
//import com.github.library.BaseQuickAdapter;
//import com.github.library.BaseViewHolder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.lovepet.shops.R;
import cn.lovepet.shops.base.BaseFragment;
import cn.lovepet.shops.base.Constants;
import cn.lovepet.shops.bean.UnionBottomBean;
import cn.lovepet.shops.bean.UnionBottomGoodsBean;
import cn.lovepet.shops.bean.UnionTopBean;
import cn.lovepet.shops.helper.basequickadapter.BaseMultiItemQuickAdapter;
import cn.lovepet.shops.helper.basequickadapter.BaseQuickAdapter;
import cn.lovepet.shops.helper.basequickadapter.BaseViewHolder;
import cn.lovepet.shops.helper.customview.CustomProgressDialog;
import cn.lovepet.shops.helper.glide.GlideCircleTransform;
import cn.lovepet.shops.helper.glide.GlideRoundTransform;
import cn.lovepet.shops.helper.imageview.RecycleViewDivider;
import cn.lovepet.shops.helper.immersive.title.OnTitleBarListener;
import cn.lovepet.shops.helper.immersive.title.TitleBar;
import cn.lovepet.shops.util.FileUtils;
import cn.lovepet.shops.util.ILog;
import cn.lovepet.shops.view.ui.activity.publical.LoginActivity;


/**
 * 萌爪联盟
 *
 * @author JSYL-DCL
 * @date 2018/8/24 13:58
 * @des
 */
public class PetUnionFragment extends BaseFragment {
    private static final java.lang.String TAG1 = PetUnionFragment.class.getSimpleName();
    private List<UnionTopBean.Topdatas.Rank> rankList;
    private List<UnionTopBean.Topdatas.Tiyan> tiyanList;
    private List<UnionTopBean.Topdatas> topBeanList;
    private List<UnionBottomGoodsBean.Dog2catgoods.Listgoods> dog2catGoodslist;
    @BindView(R.id.unionAppbar)
    AppBarLayout mAppbar;
    //标题栏
    @BindView(R.id.union_title_bar)
    TitleBar mTitleBar;
    @BindView(R.id.topRecyclerView)
    RecyclerView mTopRecyclerView;
    @BindView(R.id.bottomRecyclerview)
    RecyclerView mBottomRecyclerview;
    @BindView(R.id.unionTopTab)
    TabLayout mTabLayout;
    @BindView(R.id.categoryTablayout)
    TabLayout mCategoryTablayout;

    private String[] topTabs = new String[]{"狗狗", "猫猫"};
    private String[] subTabs = new String[]{"精选", "运动", "香水", "健康", "玩耍", "食品", "窝点", "饲养", "训练"};
    private int[] subTabIcons = new int[]{R.mipmap.all, R.mipmap.all, R.mipmap.all, R.mipmap.all,
            R.mipmap.all, R.mipmap.all, R.mipmap.all, R.mipmap.all,
            R.mipmap.all};

    private final String TAG = PetUnionFragment.class.getSimpleName();
    private Context _context;

    public PetUnionFragment() {
    }

    public static PetUnionFragment newInstance() {
        PetUnionFragment fragment = new PetUnionFragment();
        return fragment;
    }

    @Override
    protected int setImmersiveStatusBarColor() {
        return 0;
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_pet_union;
    }

    @Override
    protected void init() {
        if (tiyanList != null) tiyanList.clear();
        else tiyanList = new ArrayList<>();
        if (rankList != null) rankList.clear();
        else rankList = new ArrayList<>();
        if (topBeanList != null) topBeanList.clear();
        else topBeanList = new ArrayList<>();
        //底部评论列表
        if (dog2catGoodslist != null) dog2catGoodslist.clear();
        else dog2catGoodslist = new ArrayList<>();
    }

    @Override
    protected void bindView() {
        _context = getActivity();
        setTabLayout();
//        viewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager()));
        mTitleBar.setTitle("萌爪联盟");
        Resources resources = _context.getResources();
        Drawable drawable = resources.getDrawable(R.mipmap.icon_union_top_join);
        mTitleBar.setRightIcon(drawable);
        //设置滑动渐变标题栏
        setGradualChangeTitlebar();
        initTitleBarStyle();
//        setRankData();
        getBottomOuterJosn();
        setTopData();
        setBottomListData();
        setMiddleTabData();
    }


    BaseQuickAdapter mTopAdapter;
    private void setTopData() {
        //禁用滑动事件
        mTopRecyclerView.setNestedScrollingEnabled(false);
        mTopRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mTopRecyclerView.setHasFixedSize(true);
        mTopRecyclerView.setItemViewCacheSize(10);
        mTopAdapter = new UnionTopAdapter(topBeanList);
        //防止数据错乱
        mTopAdapter.setHasStableIds(true);
        mTopRecyclerView.setAdapter(mTopAdapter);
        mTopRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    Glide.with(getActivity()).resumeRequests();
                } else {
                    Glide.with(getActivity()).pauseRequests();
                }
            }
        });
        getTopData();
    }

    /**
     * 下部列表
     */
    private BaseQuickAdapter mBottomGoodsAdapter;
    private void setBottomListData() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mBottomRecyclerview.setLayoutManager(layoutManager);
        //解决卡顿
        layoutManager.setSmoothScrollbarEnabled(true);
//        layoutManager.setAutoMeasureEnabled(true);
//        //禁用滑动事件
//        mBottomRecyclerview.setNestedScrollingEnabled(false);

        //添加item分割线
        int color = getResources().getColor(R.color.common_divider_narrow);
        RecycleViewDivider recycleViewDivider = new RecycleViewDivider(getActivity(), layoutManager.getOrientation(), 20, color);
        mBottomRecyclerview.removeItemDecoration(recycleViewDivider);
        mBottomRecyclerview.addItemDecoration(recycleViewDivider);
        mBottomRecyclerview.setHasFixedSize(true);
        mBottomRecyclerview.setItemViewCacheSize(10);
        mBottomGoodsAdapter = new BottomGoodsAdapter(R.layout.item_union_bottom_details_experiential_division, dog2catGoodslist);
        //防止数据错乱
        mBottomGoodsAdapter.setHasStableIds(true);
        mBottomRecyclerview.setAdapter(mBottomGoodsAdapter);
        getBottomListGoods(true,0);
    }


    /**
     * 底部列表适配器
     */
    public class BottomGoodsAdapter extends BaseQuickAdapter<UnionBottomGoodsBean.Dog2catgoods.Listgoods, BaseViewHolder> {
        public BottomGoodsAdapter(int layoutResId, List<UnionBottomGoodsBean.Dog2catgoods.Listgoods> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, UnionBottomGoodsBean.Dog2catgoods.Listgoods item, int position) {
            String headerImageUrl = item.getUser().getAvatar().getImage();
            String coverImageUrl = item.getCover().get(0).getImage();

            final ImageView ivHeaderIcon = (ImageView) helper.getView(R.id.iv_header_icon);
            final ImageView ivMiddle = (ImageView) helper.getView(R.id.ivMiddle);
            helper.setText(R.id.tv_header_name, item.getUser().getUsername() == null ? "" : item.getUser().getUsername())
                    .setText(R.id.tvDivisionRole, item.getUser().getRole().get(0).getTitle() == null ? "" : item.getUser().getRole().get(0).getTitle())
                    .setText(R.id.tvPetDes, item.getUser().getPetmsg() == null ? "" : item.getUser().getPetmsg())
                    .setText(R.id.tvTitleDescription, item.getTitle() == null ? "" : item.getTitle())
                    .setText(R.id.tvcoverDescription, item.getShowtime() == null ? "" : item.getShowtime())
                    .setText(R.id.tvDivisionWatch, item.getView_K() == null ? "" : item.getView_K())
                    .setText(R.id.tvDivisionComment, item.getComment_K() == null ? "" : item.getComment_K())
                    .setText(R.id.tvDivisionZan, item.getZan_K() == null ? "" : item.getZan_K());
            Glide.with(mContext)
                    .load(headerImageUrl)
                    .asBitmap()
//                    .override(80, 80)
                    .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                    .skipMemoryCache(false)
                    .priority(Priority.NORMAL)
                    .dontTransform()
                    .placeholder(R.drawable.pet_image_loadding)
//                    .error(R.drawable.pet_image_loadding)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .transform(new GlideCircleTransform(_context))
                    .into(ivHeaderIcon);
//                    .into(new SimpleTarget<Bitmap>() {
//                        @Override
//                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
//                            ivHeaderIcon.setImageBitmap(resource);
//                        }
//                    });

            Glide.with(mContext)
                    .load(coverImageUrl)
                    .asBitmap()
                    .skipMemoryCache(false)
                    .priority(Priority.NORMAL)
                    .dontTransform()
                    .placeholder(R.drawable.pet_image_loadding)
                    .transform(new GlideRoundTransform(_context,20))
                    .diskCacheStrategy(DiskCacheStrategy.RESULT)
                    .into(ivMiddle);
//                        .into(new SimpleTarget<Bitmap>() {
//                                    @Override
//                                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
//                                        ivMiddle.setImageBitmap(resource);
//                                    }
//                                });
        }

//        public BottomGoodsAdapter(List<UnionBottomGoodsBean.Dog2catgoods.Listgoods> data, int... layoutResIds) {
//            super(data, layoutResIds);
//        }

    }


    @Override
    protected void bindData(Bundle savedInstanceState) {
    }

    @Override
    protected void bindListener() {

    }


    private void initTitleBarStyle() {
        mTitleBar.setTitleColor(getMyActivity().getResources().getColor(R.color.union_bg));
        mTitleBar.setBackgroundResource(R.color.transparent);
        mTitleBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onLeftClick(View v) {
            }

            @Override
            public void onTitleClick(View v) {
            }

            @Override
            public void onRightClick(View v) {
                String baiDuUrl = Constants.UNION_JOIN;
                LoginActivity.loadUrl(getActivity(), baiDuUrl, "加入");
            }
        });
    }


    private class HorizontalAdapter extends BaseQuickAdapter<UnionTopBean.Topdatas.Rank, BaseViewHolder> {
        public HorizontalAdapter(int layoutResId, List<UnionTopBean.Topdatas.Rank> data) {
            super(layoutResId, data);
        }

        public HorizontalAdapter(List<UnionTopBean.Topdatas.Rank> data) {
            super(data);
        }

        @Override
        protected void convert(BaseViewHolder helper, UnionTopBean.Topdatas.Rank item, int position) {
            int adapterPosition = helper.getAdapterPosition();
            ImageView rankImage = (ImageView) helper.getView(R.id.rankImage);
            TextView rankName = (TextView) helper.getView(R.id.rankName);
            LinearLayout llRankItem = (LinearLayout) helper.getView(R.id.llRankItem);

            Glide.with(mContext)
                    .load(item.getAvatar().getImage())
                    .asBitmap()
                    .centerCrop()
                    .skipMemoryCache(false)
                    .priority(Priority.NORMAL)
                    .dontTransform()
                    .placeholder(R.mipmap.pet_image_loadding)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .transform(new GlideCircleTransform(_context))
                    .into(rankImage);
            rankName.setText(item.getUsername() == null ? "" : item.getUsername().toString().trim());
            //更多
            if ("0".equals(item.getUid())) {
                llRankItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String requestUrl = Constants.UNION_RANK_MORE;
                        LoginActivity.loadUrl(getActivity(), requestUrl, "体验榜单");
                    }
                });
            }
        }

    }


//    private static class ViewPagerAdapter extends FragmentPagerAdapter {
//
//        public ViewPagerAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int position) {
////            https://atwinner.github.io/2016/12/27/top-hover/
//            switch (position) {
//                case 0:
////                    String baiDuUrl = Constants.UNION_JOIN;
////                    LoginActivity.loadUrl(getActivity(), baiDuUrl, "加入");
//                    return WebViewFragment.getInstance();
//                default:
//                    return ShopGoodsListFragment.getInstance();
//            }
//        }
//
//        @Override
//        public int getCount() {
//            return 2;
//        }
//    }

    private void setTabLayout() {
//        ArrayList<String> titleDatas = new ArrayList<>();
//        titleDatas.add("狗狗");
//        titleDatas.add("猫猫");
//        ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
//        fragmentList.add(new TabUnionDogFragment());
//        fragmentList.add(new TabUnionCatFragment());
//        MyViewPageAdapter myViewPageAdapter = new MyViewPageAdapter(getActivity().getSupportFragmentManager(), titleDatas, fragmentList);
//        mViewPager.setAdapter(myViewPageAdapter);
//        mViewPager.setOffscreenPageLimit(1);//设置ViewPage缓存界面数
//        mTopTab.setupWithViewPager(mViewPager);
//        mTopTab.setTabsFromPagerAdapter(myViewPageAdapter);
//        mCategaryTab.getTabAt(1).setCustomView(getTabView(1));
    }

    /**
     * 设置滑动渐变标题栏
     */
    private void setGradualChangeTitlebar() {
        mAppbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                float percent = Float.valueOf(Math.abs(verticalOffset)) / Float.valueOf(appBarLayout.getTotalScrollRange());
                //第一种
                int toolbarHeight = appBarLayout.getTotalScrollRange();
                int dy = Math.abs(verticalOffset);
                if (dy <= toolbarHeight) {
                    float scale = (float) dy / toolbarHeight;
                    float alpha = scale * 255;
                    if ((int) alpha > 250) {//上拉
                        mTitleBar.setBackgroundColor(Color.argb((int) alpha, 255, 255, 255));
                    } else {
                        mTitleBar.setBackgroundResource(R.mipmap.bg_img_trial_title_bg);
                    }
                }
                //第二种
//                mTitleBar.setAlpha(percent);
            }
        });
    }


    /**
     * 联盟上部分数据设置
     */
    private BaseQuickAdapter mBrandGridAdaper;

    public class UnionTopAdapter extends BaseMultiItemQuickAdapter<UnionTopBean.Topdatas, BaseViewHolder> {
        /**
         * Same as QuickAdapter#QuickAdapter(Context,int) but with
         * some initialization data.
         *
         * @param data A new list is created out of this one to avoid mutable list
         */
        public UnionTopAdapter(List<UnionTopBean.Topdatas> data) {
            super(data);
            addItemType(UnionTopBean.Topdatas.TOPTIYAN, R.layout.item_union_top_tiyan);
            addItemType(UnionTopBean.Topdatas.TOPRANK, R.layout.item_union_top_rank);
        }

        @Override
        protected void convert(BaseViewHolder helper, UnionTopBean.Topdatas item, int position) {
            switch (item.getItemType()) {
                case 0://上部-体验
                    if (tiyanList != null && tiyanList.size() > 0) {
                        UnionTopBean.Topdatas.Tiyan tiyan = tiyanList.get(0);
                        helper.setText(R.id.tiYanShiNum, tiyan.getLeft().getContent() + "")
                                .setText(R.id.tiYanReportNum, tiyan.getRight().getContent() + "");
                    }
                    break;
                case 1://上部-排行榜
                    RecyclerView mHorizantalRecyclerview = (RecyclerView) helper.getView(R.id.unionHorizantalRecyclerview);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    mHorizantalRecyclerview.setLayoutManager(linearLayoutManager);
                    mHorizantalRecyclerview.setHasFixedSize(true);
                    mHorizantalRecyclerview.setItemViewCacheSize(10);
                    HorizontalAdapter mHorizontalAdapter = new HorizontalAdapter(R.layout.item_union_rank_horizantal_item, rankList);
                    mHorizantalRecyclerview.setAdapter(mHorizontalAdapter);
                    break;
                default:
                    break;

            }
        }
    }


    private void getTopData() {
        if (tiyanList != null) tiyanList.clear();
        else tiyanList = new ArrayList<>();
        if (rankList != null) rankList.clear();
        else rankList = new ArrayList<>();
        if (topBeanList != null) topBeanList.clear();
        else topBeanList = new ArrayList<>();
        String json = FileUtils.getJson(getActivity(), "pet_union_top.json");
        Gson gson = new Gson();
        Type type = new TypeToken<UnionTopBean>() {
        }.getType();
        UnionTopBean unionTopBean = gson.fromJson(json, type);
        List<UnionTopBean.Topdatas> topdatas = unionTopBean.getTopdatas();
        topBeanList.addAll(topdatas);
        List<UnionTopBean.Topdatas.Rank> rank = topdatas.get(0).getRank();
        rankList.addAll(rank);
        //排行榜
        UnionTopBean.Topdatas.Tiyan tiyan = topdatas.get(1).getTiyan();
        tiyanList.add(tiyan);
        mTopAdapter.notifyDataSetChanged();
    }

    /**
     * 底部标签数据+示例列表数据
     */
    private void setMiddleTabData() {
        String json = FileUtils.getJson(getActivity(), "pet_union_bottom.json");
        Gson gson = new Gson();
        Type type = new TypeToken<UnionBottomBean>() {
        }.getType();
        UnionBottomBean unionBottomBean = gson.fromJson(json, type);
        final List<UnionBottomBean.Bottomdata.Cate> cateList = unionBottomBean.getBottomdata().getCate();
        for (int i = 0; i < topTabs.length; i++) {
            mTabLayout.addTab(mTabLayout.newTab());
            mTabLayout.getTabAt(i).setText(topTabs[i]);
        }
        for (int i = 0; i < cateList.size(); i++) {
            mCategoryTablayout.addTab(mCategoryTablayout.newTab());
            mCategoryTablayout.getTabAt(i).setCustomView(makeTabView(i, cateList));
        }
        Constants.UNION_ISFIRSTSETTAB = true;

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position == 0){//狗狗
                    getBottomListGoods(true,0);
                }else  if (position == 1){//猫猫
                    getBottomListGoods(false,0);
                }
                mCategoryTablayout.getTabAt(0).select();

                ILog.e(TAG1,"=======>> 一级Tab选中position："+position);
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mCategoryTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Constants.UNION_ISFIRSTSETTAB = false;
                int position = tab.getPosition();
                int selectedTabPosition = mTabLayout.getSelectedTabPosition();
                mCategoryTablayout.getTabAt(position).select();
                View view = tab.getCustomView();
                if (null != view && view instanceof TextView) {
                    ((TextView) view).setTextSize(19);
                }

                if (selectedTabPosition == 0){//狗狗
                    getBottomListGoods(true,position);
                }else if (selectedTabPosition == 1){//猫猫
                    getBottomListGoods(false,position);
                }
                ILog.e(TAG1,"=======>> 二级Tab选中position："+position);
                ILog.e(TAG1,"=======>> 二级Tab获取一级选中selectedTabPosition："+selectedTabPosition);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    List<UnionBottomGoodsBean.Dog2catgoods> dog2catgoods;
    private void getBottomOuterJosn(){
        try {
            String json = FileUtils.getJson(getActivity(), "pet_union_bottom_tab_goods.json");
            Gson gson = new Gson();
            Type type = new TypeToken<UnionBottomGoodsBean>() {
            }.getType();
            UnionBottomGoodsBean unionBottomGoodsBean = gson.fromJson(json, type);
            dog2catgoods = unionBottomGoodsBean.getDog2catgoods();
        }catch (OutOfMemoryError error){

        }
    }

    /**
     * 底部标签分类列表数据
     */
    private List<String> names;
    private void getBottomListGoods(boolean isdog,int index) {
        if (dog2catGoodslist != null) dog2catGoodslist.clear();
        else dog2catGoodslist = new ArrayList<>();
        if (names != null) names.clear();
        else names = new ArrayList<>();
        if (isdog) {
            List<UnionBottomGoodsBean.Dog2catgoods.Listgoods> listgoods = dog2catgoods.get(index).getListgoods();
            dog2catGoodslist.addAll(listgoods);
        }else {
            List<UnionBottomGoodsBean.Dog2catgoods.Listgoods> listgoods = dog2catgoods.get(index+10).getListgoods();
            dog2catGoodslist.addAll(listgoods);
        }
        CustomProgressDialog customProgressDialog = new CustomProgressDialog(_context,R.style.progressDialog);
        customProgressDialog.onCancel(false,true);
        customProgressDialog.showPosition(250,1);

        customProgressDialog.show();
        mBottomGoodsAdapter.notifyDataSetChanged();
        if (dog2catGoodslist != null && dog2catGoodslist.size() > 0) {
            smoothMoveToPosition(mBottomRecyclerview, 0);
        }

        for (UnionBottomGoodsBean.Dog2catgoods.Listgoods a: dog2catGoodslist) {
            String username = a.getUser().getUsername();
            names.add(username);
        }
        ILog.e(TAG1,"当前展示的列表名字[names]："+new Gson().toJson(names));
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

    /**
     * 引入布局设置图标和标题
     *
     * @param position
     * @param cateList
     * @return
     */
    private View makeTabView(int position, List<UnionBottomBean.Bottomdata.Cate> cateList) {
        View tabView = LayoutInflater.from(getActivity()).inflate(R.layout.tab_text_icon, null);
        TextView customTextview = tabView.findViewById(R.id.customTextview);
        ImageView customImageview = tabView.findViewById(R.id.customImageview);
        customTextview.setText(cateList.get(position).getTag_name());
//            customImageview.setImageResource(subTabIcons[position]);
        Glide.with(_context)
                .load(cateList.get(position).getImage())
                .asBitmap()
                .skipMemoryCache(false)
                .priority(Priority.NORMAL)
                .dontTransform()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(customImageview);
        return tabView;
    }

}
