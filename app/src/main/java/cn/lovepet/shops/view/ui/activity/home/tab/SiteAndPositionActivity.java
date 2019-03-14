package cn.lovepet.shops.view.ui.activity.home.tab;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.umeng.analytics.MobclickAgent;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.lovepet.shops.R;
import cn.lovepet.shops.base.BaseActivity;
import cn.lovepet.shops.base.Constants;
import cn.lovepet.shops.bean.PetAreaOneLevel;
import cn.lovepet.shops.helper.basequickadapter.BaseQuickAdapter;
import cn.lovepet.shops.helper.basequickadapter.BaseViewHolder;
import cn.lovepet.shops.helper.imageview.RecycleViewDivider;
import cn.lovepet.shops.helper.immersive.title.OnTitleBarListener;
import cn.lovepet.shops.helper.immersive.title.TitleBar;
import cn.lovepet.shops.util.ILog;
import cn.lovepet.shops.util.FileUtils;

/**
 * @author JSYL-DCL
 * @date 2018/11/21 14:33
 * @des 站点、地理位置选择
 */
public class SiteAndPositionActivity extends BaseActivity {
    private Context _context;
    private BaseQuickAdapter mAreaAdapter;
    //标题栏
    @BindView(R.id.siteTitlebar)
    TitleBar mTitleBar;
    @BindView(R.id.siteRecyclerView)
    RecyclerView mSiteRecyclerView;
    @BindView(R.id.tvChoiceAddress)
    TextView tvChoiceAddress;
    private List<PetAreaOneLevel.Places> placesList;

    public static void getInstance(Context context) {
        context.startActivity(new Intent(context, SiteAndPositionActivity.class));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_site_postion;
    }

    @Override
    protected void init() {
        if (placesList != null) placesList.clear();
        else placesList = new ArrayList<>();
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        _context = SiteAndPositionActivity.this;
        mTitleBar.setTitle("购物车");
        initTitleBarStyle();
        setOneLevelArea();
    }

    @Override
    protected void initData() {
    }

    private void setOneLevelArea() {
//        mSiteRecyclerView.setLayoutManager(new LinearLayoutManager(_context));
//        mSiteRecyclerView.setHasFixedSize(true);
//        //添加item分割线
//        mSiteRecyclerView.addItemDecoration(new DashlineItemDivider("#B2B2B2"));
        //添加item分割线
        LinearLayoutManager layoutManager = new LinearLayoutManager(_context, LinearLayoutManager.VERTICAL, false);
        mSiteRecyclerView.setLayoutManager(layoutManager);
        int color = getResources().getColor(R.color.main_top_line_bg);
        RecycleViewDivider recycleViewDivider = new RecycleViewDivider(_context, layoutManager.getOrientation(), 1, color);
        mSiteRecyclerView.removeItemDecoration(recycleViewDivider);
        mSiteRecyclerView.addItemDecoration(recycleViewDivider);
        mSiteRecyclerView.setHasFixedSize(true);
        mSiteRecyclerView.setItemViewCacheSize(10);
        mAreaAdapter = new AreaAdapter(R.layout.item_site, placesList);
        //防止数据错乱
        mAreaAdapter.setHasStableIds(true);
        mSiteRecyclerView.setAdapter(mAreaAdapter);
        getOneLevelData();
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
        return R.color.white;
//        return R.color.cu_config_positive_action_solid_color;
//        return 0;
//        return R.color.white;
    }

    private void initTitleBarStyle() {
        if (setImmersiveStatusBarColor() != 0) {
            mTitleBar.setBackgroundResource(setImmersiveStatusBarColor());
        } else {
            mTitleBar.setBackgroundResource(R.color.white);
        }
        mTitleBar.setTitleColor(getResources().getColor(R.color.black));
        mTitleBar.setBackgroundResource(R.color.white);
        mTitleBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onLeftClick(View v) {
                finish();
            }

            @Override
            public void onTitleClick(View v) {
            }

            @Override
            public void onRightClick(View v) {
            }
        });
    }

    /**
     * 地区列表
     */
    public class AreaAdapter extends BaseQuickAdapter<PetAreaOneLevel.Places, BaseViewHolder> {
        public AreaAdapter(int layoutResId, List<PetAreaOneLevel.Places> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, final PetAreaOneLevel.Places item, int position) {
            TextView text1 = (TextView) helper.getView(R.id.tvAreaOneLevel);
            LinearLayout llAreaOneLevel = (LinearLayout) helper.getView(R.id.llAreaOneLevel);
            text1.setText(item.getName() == null ? "" : item.getName());
            llAreaOneLevel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tvChoiceAddress.setText(item.getName());
                    Intent intent = new Intent();
                    // 获取用户计算后的结果
                    intent.putExtra("areaName", item.getName());
                    intent.putExtra("areaId", item.getPlaceid());
                    setResult(Constants.ACTIVITY_RESULT_CODE_1, intent);
                    finish();
                }
            });
        }
    }

    /**
     * 地区
     */
    private void getOneLevelData() {
        //地区一级数据
        String jsonFromAsset = FileUtils.getJson(SiteAndPositionActivity.this, "pet_search_area_ol.json");
        Gson gson = new Gson();
        Type type = new TypeToken<PetAreaOneLevel>() {
        }.getType();
        PetAreaOneLevel petAreaOneLevel = gson.fromJson(jsonFromAsset, type);
        List<PetAreaOneLevel.Places> places = petAreaOneLevel.getPlaces();
        placesList.addAll(places);
        mAreaAdapter.notifyDataSetChanged();
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