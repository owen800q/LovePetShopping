package cn.lovepet.shops.view.ui.activity.union;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;
//import com.github.library.BaseQuickAdapter;
//import com.github.library.BaseViewHolder;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.lovepet.shops.R;
import cn.lovepet.shops.base.BaseFragment;
import cn.lovepet.shops.bean.UnionBottomGoodsBean;
import cn.lovepet.shops.helper.basequickadapter.BaseQuickAdapter;
import cn.lovepet.shops.helper.basequickadapter.BaseViewHolder;
import cn.lovepet.shops.helper.glide.GlideCircleTransform;
import cn.lovepet.shops.helper.glide.GlideRoundTransform;
import cn.lovepet.shops.helper.imageview.RecycleViewDivider;
import cn.lovepet.shops.util.ILog;

/**
 * @author JSYL-DCL
 * @date 2018/10/29 10:50
 * @des 联盟-狗狗
 */
public class TabUnionBottomListFragment2 extends BaseFragment {
    private static final String TAG1 = TabUnionBottomListFragment2.class.getSimpleName();
    private BaseQuickAdapter mBottomGoodsAdapter;
    private List<UnionBottomGoodsBean.Dog2catgoods.Listgoods> dataList;
    private static List<UnionBottomGoodsBean.Dog2catgoods>  goodBeanList;

    @BindView(R.id.bottomRecyclerview)
    RecyclerView mBottomRecyclerview;

    public Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    setRecyclerViewData();
                    break;
            }
        }
    };

    public static TabUnionBottomListFragment2 newInstance(List<UnionBottomGoodsBean.Dog2catgoods>  dog2catgoods) {
        TabUnionBottomListFragment2 fragment = new TabUnionBottomListFragment2();
        if (goodBeanList != null)goodBeanList.clear();
        else goodBeanList = new ArrayList<>();
        goodBeanList.addAll(dog2catgoods);
        return fragment;
    }
    @Override
    protected int setImmersiveStatusBarColor() {
        return 0;
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_union_dog_item;
    }

    @Override
    protected void init() {
        if (dataList != null)dataList.clear();
        else dataList = new ArrayList<>();
    }

    @Override
    protected void bindView() {
        setRecyclerViewData();
    }

    private void setRecyclerViewData() {
        //禁用滑动事件
//        mBottomRecyclerview.setNestedScrollingEnabled(false);
        if (goodBeanList != null && goodBeanList.size() > 0){
            dataList.addAll(goodBeanList.get(0).getListgoods());
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mBottomRecyclerview.setLayoutManager(layoutManager);
        //添加item分割线
        int color = getResources().getColor(R.color.common_divider_narrow);
        RecycleViewDivider recycleViewDivider = new RecycleViewDivider(getActivity(), layoutManager.getOrientation(), 20, color);
        mBottomRecyclerview.removeItemDecoration(recycleViewDivider);
        mBottomRecyclerview.addItemDecoration(recycleViewDivider);
        mBottomRecyclerview.setHasFixedSize(true);
        mBottomRecyclerview.setItemViewCacheSize(10);
        mBottomGoodsAdapter = new BottomGoodsAdapter(R.layout.item_union_bottom_details_experiential_division, dataList);
        //防止数据错乱
        mBottomGoodsAdapter.setHasStableIds(true);
        mBottomRecyclerview.setAdapter(mBottomGoodsAdapter);
    }



    @Override
    protected void bindData(Bundle savedInstanceState) {
    }

    @Override
    protected void bindListener() {
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
                    .transform(new GlideCircleTransform(getActivity()))
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
                    .transform(new GlideRoundTransform(getActivity(),20))
                    .diskCacheStrategy(DiskCacheStrategy.RESULT)
                    .into(ivMiddle);
//                        .into(new SimpleTarget<Bitmap>() {
//                                    @Override
//                                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
//                                        ivMiddle.setImageBitmap(resource);
//                                    }
//                                });
        }
    }


    /**
     * 获取宿主Activity的用户信息
     */
    public void onListSwitch(int firstTabType,int secondTabPosition) {
        if (dataList != null)dataList.clear();
        else dataList = new ArrayList<>();
        if (goodBeanList != null && goodBeanList.size() > 0){
            dataList.addAll(goodBeanList.get(secondTabPosition).getListgoods());
            sendMsg(0);
        }
        ILog.e(TAG1,">>PetUnionFragment-->选择 firstTabType： "+firstTabType);
        ILog.e(TAG1,">>PetUnionFragment-->选择 secondTabPosition： "+secondTabPosition);
        ILog.e(TAG1,">>PetUnionFragment-->选择 dataList： "+new Gson().toJson(dataList));
    }

    private void sendMsg(int i) {
        Message message = Message.obtain();
        message.what = i;
        handler.sendMessage(message);
    }
}