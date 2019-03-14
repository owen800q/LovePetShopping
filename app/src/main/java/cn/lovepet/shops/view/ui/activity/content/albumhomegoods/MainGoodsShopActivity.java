package cn.lovepet.shops.view.ui.activity.content.albumhomegoods;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.umeng.analytics.MobclickAgent;

import butterknife.BindView;
import cn.lovepet.shops.R;
import cn.lovepet.shops.base.BaseActivity;
import cn.lovepet.shops.helper.basequickadapter.BaseQuickAdapter;
import cn.lovepet.shops.helper.customview.SpaceItemDecoration1;
import cn.lovepet.shops.helper.headerview.HeaderView;
import cn.lovepet.shops.helper.headerview.PtrFrameLayout;
import cn.lovepet.shops.helper.headerview.PtrHandler;
import cn.lovepet.shops.mvp.base.GoodsJDHomeContract;
import cn.lovepet.shops.mvp.presenter.GoodsJdHomePresenterimpl;
import cn.lovepet.shops.util.DensityUtil;

/**
 * @author dingcl
 * 商品首页展览
 */
public class MainGoodsShopActivity extends BaseActivity implements HeaderView.RefreshDistanceListener ,GoodsJDHomeContract.View,PositionChangedListener, BaseQuickAdapter.RequestLoadMoreListener {
    /**
     * 改变titlebar中icon颜色时的距离
     */
    private static int DISTANCE_WHEN_TO_SELECTED = 40;
    @BindView(R.id.scanning_layout)
    LinearLayout scanningLayout;
    @BindView(R.id.advisory_layout)
    LinearLayout advisoryLayout;
    @BindView(R.id.home_title_bar_layout)
    FrameLayout homeTitleBarLayout;
    @BindView(R.id.home_title_bar_bg_view)
    View homeTitleBarBgView;
    @BindView(R.id.llTopSearch)
    LinearLayout mLlTopSearch;
    private RecyclerView recyclerView;
    private HeaderView mPtrFrame;
    private Context mContext;
    private AlbumHomeMultipleRecycleAdapter adapter;
    private int distanceY;
    /**
     * 加载首页样式标记
     */
    private int flag = 1;
    GoodsJdHomePresenterimpl mPresenter;

    public static void getInstance(Context context) {
         context.startActivity(new Intent(context,MainGoodsShopActivity.class));
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_goods_albot_home;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mContext = MainGoodsShopActivity.this;
        mPresenter = new GoodsJdHomePresenterimpl(mContext,this);
        initBase();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

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
     * 初始化下拉刷新及滚动距离title发生的改变
     */
    private void initBase() {
        initPtrFrame();
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(recyclerView.getContext(), 4, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addItemDecoration(new SpaceItemDecoration1(DensityUtil.dip2px(mContext,3)));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                distanceY += dy;
                if (distanceY > DensityUtil.dip2px(mContext, 20)) {
                    homeTitleBarBgView.setBackgroundColor(getResources().getColor(R.color.white));
                    if (Build.VERSION.SDK_INT > 10) {
                        homeTitleBarBgView.setAlpha(distanceY * 1.0f / DensityUtil.dip2px(mContext, 100));
                    }
                    else {
                        DISTANCE_WHEN_TO_SELECTED = 20;
                    }
                }
                else {
                    homeTitleBarBgView.setBackgroundColor(0);
                }

                if (distanceY > DensityUtil.dip2px(mContext, DISTANCE_WHEN_TO_SELECTED) && !scanningLayout.isSelected()) {
                    scanningLayout.setSelected(true);
                    advisoryLayout.setSelected(true);
                }
                else if (distanceY <= DensityUtil.dip2px(mContext, DISTANCE_WHEN_TO_SELECTED) && scanningLayout.isSelected()) {
                    scanningLayout.setSelected(false);
                    advisoryLayout.setSelected(false);
                }
            }
        });
        adapter = new AlbumHomeMultipleRecycleAdapter();
        adapter.setOnLoadMoreListener(this);
        adapter.setEnableLoadMore(true);
        adapter.setListener(this);
        recyclerView.setAdapter(adapter);
        mPresenter.getHomeIndexData(flag);
        flag = 0;
    }

    /**
     * 初始化下拉刷新
     */
    private void initPtrFrame() {
        mPtrFrame = (HeaderView) findViewById(R.id.rotate_header_list_view_frame);
        mPtrFrame.setOnRefreshDistanceListener(this);
        mPtrFrame.setPtrHandler(new PtrHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                updateData();
            }
        });

        // 是否进入页面就开始显示刷新动作
        /*mPtrFrame.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPtrFrame.autoRefresh();
            }
        }, 100);*/
    }

    /**
     * 下拉后刷新数据
     */
    private void updateData() {
        mPtrFrame.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPresenter.getHomeIndexData(flag);
                if(flag == 0){
                    flag = 1;
                }
                else{
                    flag = 0;
                }
            }
        }, 1000);
    }

    @Override
    public void onStart() {
        super.onStart();

    }


    @Override
    public void onPositionChange(int currentPosY) {
        if (currentPosY > 0) {
            if (homeTitleBarLayout.getVisibility() == View.VISIBLE) {
                homeTitleBarLayout.setVisibility(View.GONE);
            }
        } else {
            if (homeTitleBarLayout.getVisibility() == View.GONE) {
                homeTitleBarLayout.setVisibility(View.VISIBLE);
                distanceY = 0;
            }
        }
    }


    @Override
    public void setHomeIndexData(HomeIndex homeIndex) {
        if(homeIndex == null){
            mPtrFrame.refreshComplete();
            return;
        }
        adapter.getData().clear();
        adapter.resetMaxHasLoadPosition();
        adapter.setNewData(homeIndex.itemInfoList);
        mPtrFrame.refreshComplete();
    }

    @Override
    public void setRecommendedWares(HomeIndex recommendedProducts) {
        adapter.getData().addAll(recommendedProducts.itemInfoList);
        adapter.loadMoreComplete();
    }

    @Override
    public void setMoreRecommendedWares(HomeIndex moreRecommendedProducts) {
        adapter.getData().addAll(moreRecommendedProducts.itemInfoList);
        adapter.loadMoreComplete();
    }

    /**
     * 当前recyclerView 的position的回调
     * @param position
     */
    @Override
    public void currentPosition(int position) {

    }

    @Override
    public void onLoadMoreRequested() {
        recyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (adapter.getData().size() >= 90){
                    adapter.loadMoreEnd(false);
                }
                else{
                    mPresenter.getRecommendedWares();
                }
            }
        },1000);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }
}
