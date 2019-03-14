package cn.lovepet.shops.view.ui.activity.home.tab;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jet.flowtaglayout.FlowTagLayout;
import com.umeng.analytics.MobclickAgent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.OnClick;
import cn.lovepet.shops.R;
import cn.lovepet.shops.base.BaseActivity;
import cn.lovepet.shops.util.ToastsUtils;

/**
 * @author JSYL-DCL
 * @date 2018/11/21 14:33
 * @des 搜索查询
 */
public class SearchQueryActivity extends BaseActivity {
    @BindView(R.id.flowTagLayout)
    FlowTagLayout mFlowTagLayout;
    @BindView(R.id.flowTagLayout_history)
    FlowTagLayout mHistoryFlowTagLayout;
    @BindArray(R.array.pet_search_remen_array)
    String[] mRemenArrays;
    @BindArray(R.array.pet_search_histoty)
    String[] mHistotyArrays;
    private Context mContext;

    public static void getInstance(Context context) {
        context.startActivity(new Intent(context, SearchQueryActivity.class));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search_query;
    }

    @Override
    protected void init() {

    }

    List<String> dataList1;
    List<String> dataList2 = new ArrayList<>();
    @Override
    protected void initView(Bundle savedInstanceState) {
        mContext = SearchQueryActivity.this;
        if (dataList1 != null) dataList1.clear();
        else dataList1 = new ArrayList<>();
        List<String> strings = Arrays.asList(mRemenArrays);
        List<String> strings1 = Arrays.asList(mHistotyArrays);
        dataList1.addAll(strings);
        dataList2.addAll(strings1);
        // 添加tag
        mFlowTagLayout.addTags(dataList1);  // 添加tag的列表，该方法会把之前的tags全部清空
        mHistoryFlowTagLayout.addTags(dataList2);  // 添加tag的列表，该方法会把之前的tags全部清空
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        mFlowTagLayout.setTagClickListener(new FlowTagLayout.OnTagClickListener() {
            @Override
            public void tagClick(int position) {
                String s = dataList1.get(position);
                ToastsUtils.showShort(position+"-热门选中s："+s);
                if (!dataList2.contains(s)) {
                    dataList2.add(s);
                    Collections.reverse(dataList2);
                    mHistoryFlowTagLayout.addTags(dataList2);
                }
                startActivity(new Intent(mContext,SearchGoodsActivity.class));

            }
        });
        mHistoryFlowTagLayout.setTagClickListener(new FlowTagLayout.OnTagClickListener() {
            @Override
            public void tagClick(int position) {
                String s = dataList2.get(position);
                ToastsUtils.showShort(position+"-最近选中s："+s);
                mHistoryFlowTagLayout.getChildAt(position).setSelected(!mHistoryFlowTagLayout.getChildAt(position).isSelected());
            }
        });

    }

    @OnClick({
             R.id.llClearAll
            ,R.id.ivBack
    })
    public void bindViewClick(View view){
        switch (view.getId()){
            case  R.id.llClearAll:
                //清除历史
                mHistoryFlowTagLayout.removeAllViews();
                if (dataList2 != null) dataList2.clear();
                break;
            case  R.id.ivBack:
                finish();
                break;
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