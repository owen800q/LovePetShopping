package cn.lovepet.shops.view.ui.activity.category;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.github.library.BaseMultiItemQuickAdapter;
import com.github.library.BaseQuickAdapter;
import com.github.library.BaseViewHolder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.lovepet.shops.R;
import cn.lovepet.shops.base.BaseFragment;
import cn.lovepet.shops.bean.PetCategoryMainLeftMenu;
import cn.lovepet.shops.bean.PetCategoryMainRightList;
import cn.lovepet.shops.helper.imageview.RecycleViewDivider;
import cn.lovepet.shops.util.FileUtils;
import cn.lovepet.shops.util.ToastsUtils;
import cn.lovepet.shops.view.widget.SmoothScrollLayoutManager;

/**
 * @author JSYL-DCL
 * @date 2018/10/29 10:50
 * @des 分类-首页
 */
public class TabCategoryMainFragment extends BaseFragment {
    private static final java.lang.String TAG1 = TabCategoryMainFragment.class.getSimpleName();
    @BindView(R.id.leftRecyclerView)
    RecyclerView mLeftRecyclerView;
    @BindView(R.id.rightRecyclerView)
    RecyclerView mRightRecyclerView;
    private  List<PetCategoryMainLeftMenu.Categorys> categorysesLeft;
    private  List<String> categorysesNameList;
    private  Context _context;
    private  LeftMenuAdapter mLeftAdapter;
    private  RightListAdapter mRightAdapter;

    //目标项是否在最后一个可见项之后
    private boolean mShouldScroll;
    //记录目标项位置
    private int mToPosition;

    public Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0://推荐
                    setRightListAdapter(0);
                    break;
                case 1://国际
                    setRightListAdapter(1);
                    break;
                case 2://服饰
                    setRightListAdapter(2);
                    break;
                case 3://窝垫
                    setRightListAdapter(3);
                    break;
                case 4://主粮
                    setRightListAdapter(4);
                    break;
                case 5://零食
                    setRightListAdapter(5);
                    break;
                case 6://玩具
                    setRightListAdapter(6);
                    break;
                case 7://清洁
                    setRightListAdapter(7);
                    break;
                case 8://保健
                    setRightListAdapter(8);
                    break;
                case 9://护理
                    setRightListAdapter(9);
                    break;
                case 10://生活
                    setRightListAdapter(10);
                    break;
                case 11://牵引
                    setRightListAdapter(11);
                    break;
                case 12://美容
                    setRightListAdapter(12);
                    break;
                case 13://出游洗澡
                    setRightListAdapter(13);
                    break;
                case 14://出游洗澡
                    if (mLeftAdapter != null) mLeftAdapter.notifyDataSetChanged();
                    break;
            }
        }
    };



    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_category_main;
    }

    @Override
    protected void init() {
        if (categorysesLeft != null)categorysesLeft.clear();
        else categorysesLeft = new ArrayList<>();
        if (categorysesNameList != null)categorysesNameList.clear();
        else categorysesNameList = new ArrayList<>();
    }

    @Override
    protected void bindView() {
        _context = getActivity();
        getRightMenuData();
        setLeftMenu();

    }


    @Override
    protected void bindData(Bundle savedInstanceState) {
    }

    @Override
    protected void bindListener() {
    }




    private void setRightListAdapter(int listType) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        mRightRecyclerView.setLayoutManager(layoutManager);
        mRightRecyclerView.setHasFixedSize(true);
        //添加item分割线
        int color = getResources().getColor(R.color.lightgray);
        RecycleViewDivider recycleViewDivider = new RecycleViewDivider(getActivity(), layoutManager.getOrientation(), 1, color);
        mRightRecyclerView.removeItemDecoration(recycleViewDivider);
        mRightRecyclerView.addItemDecoration(recycleViewDivider);
        mRightRecyclerView.setItemViewCacheSize(10);
        if (listType == 0) mRightAdapter = new RightListAdapter(tuijianList);
        else if (listType == 1) mRightAdapter = new RightListAdapter(epet_guojiList);
        else if (listType == 2) mRightAdapter = new RightListAdapter(dog_clothesList);
        else if (listType == 3) mRightAdapter = new RightListAdapter(dog_wodianList);
        else if (listType == 4) mRightAdapter = new RightListAdapter(dog_zhuliangList);
        else if (listType == 5) mRightAdapter = new RightListAdapter(dog_lingshiList);
        else if (listType == 6) mRightAdapter = new RightListAdapter(dog_wanjuList);
        else if (listType == 7) mRightAdapter = new RightListAdapter(dog_qingjieList);
        else if (listType == 8) mRightAdapter = new RightListAdapter(dog_baojianList);
        else if (listType == 9) mRightAdapter = new RightListAdapter(dog_huliList);
        else if (listType == 10) mRightAdapter = new RightListAdapter(dog_shenghuoList);
        else if (listType == 11) mRightAdapter = new RightListAdapter(dog_qianyinList);
        else if (listType == 12) mRightAdapter = new RightListAdapter(dog_meirongList);
        else if (listType == 13) mRightAdapter = new RightListAdapter(dog_chuyouxizaoList);
        //防止数据错乱
        mRightAdapter.setHasStableIds(true);
        mRightRecyclerView.setAdapter(mRightAdapter);
    }


    private BaseQuickAdapter mNormalGoodsAdaper;
    private BaseQuickAdapter mBrandAdaper;
    public class RightListAdapter extends BaseMultiItemQuickAdapter<PetCategoryMainRightList.Category_main.Tuijian, BaseViewHolder> {
        /**
         * Same as QuickAdapter#QuickAdapter(Context,int) but with
         * some initialization data.
         *
         * @param data A new list is created out of this one to avoid mutable list
         */
        public RightListAdapter(List<PetCategoryMainRightList.Category_main.Tuijian> data) {
            super(data);
            addItemType(PetCategoryMainRightList.Category_main.Tuijian.CATEGORY_MAIN_SINGLE_IMAGE, R.layout.item_dog_category_main_right_single_image);
            addItemType(PetCategoryMainRightList.Category_main.Tuijian.CATEGORY_MAIN_GOODS_LIST, R.layout.item_dog_category_main_right_normal_goods_list);
            addItemType(PetCategoryMainRightList.Category_main.Tuijian.CATEGORY_MAIN_HOT_RECOMMEND, R.layout.item_dog_category_main_right_brand);

        }

        @Override
        protected void convert(BaseViewHolder holder, PetCategoryMainRightList.Category_main.Tuijian data) {
            final int adapterPosition = holder.getAdapterPosition();
            switch (data.getItemType()) {
                case 0://图
                    String dataSrc = data.getSrc();
                    ImageView ivCaImage = (ImageView) holder.getView(R.id.ivCaImage);
                    Glide.with(_context)
                            .load(dataSrc)
                            .asBitmap()
                            .skipMemoryCache(false)
                            .priority(Priority.HIGH)
                            .dontTransform()
                            .placeholder(R.mipmap.pet_image_loadding)
                            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                            .into(ivCaImage);
                    break;
                case 1://普通商品
                    TextView tvNormalGoodsTitleName = (TextView) holder.getView(R.id.tvNormalGoodsTitleName);
                    ImageView tvNormalGoodsTitleMore = (ImageView) holder.getView(R.id.tvNormalGoodsTitleMore);
                    RecyclerView mNormalGoodsRecyclerView = (RecyclerView) holder.getView(R.id.normalGoodsRecyclerView);
                    tvNormalGoodsTitleName.setText(data.getTitle() == null ? "" : data.getTitle());
                    tvNormalGoodsTitleMore.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ToastsUtils.showShort("全部商品");
                        }
                    });
                    List<PetCategoryMainRightList.Category_main.Tuijian.Menulist> menulist = data.getMenulist();
                    mNormalGoodsRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
                    mNormalGoodsRecyclerView.setHasFixedSize(true);
                    mNormalGoodsRecyclerView.setItemViewCacheSize(10);
                    mNormalGoodsRecyclerView.setAdapter(mNormalGoodsAdaper = new BaseQuickAdapter<PetCategoryMainRightList.Category_main.Tuijian.Menulist, BaseViewHolder>(R.layout.item_dog_category_main_right_normalgoods_item, menulist) {
                        @Override
                        protected void convert(BaseViewHolder helper, PetCategoryMainRightList.Category_main.Tuijian.Menulist item) {
                            int adapterPosition = helper.getAdapterPosition();
                            TextView normalName = (TextView) helper.getView(R.id.normalName);
                            normalName.setText(item.getName() == null? "" : item.getName());
                            ImageView normalImage = (ImageView) helper.getView(R.id.normalImage);
                            Glide.with(mContext)
                                    .load(item.getPhoto())
                                    .asBitmap()
                                    .skipMemoryCache(false)
                                    .priority(Priority.HIGH)
                                    .dontTransform()
                                    .placeholder(R.mipmap.pet_image_loadding)
                                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                    .into(normalImage);

                        }
                    });

                    break;
                case 2://品牌
                    TextView tvBrandTitleName = (TextView) holder.getView(R.id.tvBrandTitleName);
                    RecyclerView mBrandRecyclerView = (RecyclerView) holder.getView(R.id.brandRecyclerView);
                    List<PetCategoryMainRightList.Category_main.Tuijian.Menulist> brandMenuList = data.getMenulist();
                    mBrandRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
                    mBrandRecyclerView.setHasFixedSize(true);
                    mBrandRecyclerView.setItemViewCacheSize(10);
                    mBrandRecyclerView.setAdapter(mBrandAdaper = new BaseQuickAdapter<PetCategoryMainRightList.Category_main.Tuijian.Menulist, BaseViewHolder>(R.layout.item_dog_category_main_right_brand_item, brandMenuList) {
                        @Override
                        protected void convert(BaseViewHolder helper, PetCategoryMainRightList.Category_main.Tuijian.Menulist item) {
                            int adapterPosition = helper.getAdapterPosition();
                            ImageView brandImage = (ImageView) helper.getView(R.id.brandImage);
                            TextView brandName = (TextView) helper.getView(R.id.brandName);
                            brandName.setText(item.getName() == null? "" : item.getName());
                            Glide.with(mContext)
                                    .load(item.getLogo())
                                    .asBitmap()
                                    .skipMemoryCache(false)
                                    .priority(Priority.HIGH)
                                    .dontTransform()
                                    .placeholder(R.mipmap.pet_image_loadding)
                                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                    .into(brandImage);
                        }
                    });
                    break;
                default:
                    break;

            }
        }
    }

    @Override
    protected int setImmersiveStatusBarColor() {
        return 0;
    }


    /**
     * 设置左侧菜单数据
     */
    private void setLeftMenu() {
        SmoothScrollLayoutManager layoutManager = new SmoothScrollLayoutManager(getActivity());
        mLeftRecyclerView.setLayoutManager(layoutManager);
        mLeftRecyclerView.setHasFixedSize(true);
        //添加item分割线
        int color = getResources().getColor(R.color.lightgray);
        RecycleViewDivider recycleViewDivider = new RecycleViewDivider(getActivity(), layoutManager.getOrientation(), 1, color);
        mLeftRecyclerView.removeItemDecoration(recycleViewDivider);
        mLeftRecyclerView.addItemDecoration(recycleViewDivider);

//        mLeftRecyclerView.setLayoutManager(new LinearLayoutManager(_context));
//        mLeftRecyclerView.setHasFixedSize(true);
//        //添加item分割线
//        int color = getResources().getColor(R.color.lightgray);
//        mLeftRecyclerView.addItemDecoration(new RecycleViewDivider(_context, LinearLayoutManager.VERTICAL, 1, color));
//        mLaunchRecyclerView.setItemViewCacheSize(10);
        mLeftAdapter = new LeftMenuAdapter(categorysesNameList,R.layout.item_category_main_left_menu);
        //防止数据错乱
        mLeftAdapter.setHasStableIds(true);
        mLeftRecyclerView.setAdapter(mLeftAdapter);
        getLeftMenuData();
    }


    /**
     * 数据适配器
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
            final TextView tvLeftMenuName = (TextView) helper.getView(R.id.tvLeftMenuName);
            tvLeftMenuName.setText(item);
            if (mBooleanArray.get(position)) {
                helper.setBackgroundColor(R.id.tvLeftMenuName, Color.parseColor("#F6F6F6"));
                helper.setTextColor(R.id.tvLeftMenuName,Color.parseColor("#FF0000"));
            } else {
                helper.setBackgroundColor(R.id.tvLeftMenuName, Color.parseColor("#FFFFFF"));
                helper.setTextColor(R.id.tvLeftMenuName,Color.parseColor("#212121"));
            }

            tvLeftMenuName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setItemChecked(helper.getAdapterPosition());
                    if (position == 0){
                        sendMsg(0);
                    } else if(position == 1) {
                        sendMsg(1);
                    }else if(position == 2) {
                        sendMsg(2);
                    }else if(position == 3) {
                        sendMsg(3);
                    }else if(position == 4) {
                        sendMsg(4);
                    }else if(position == 5) {
                        sendMsg(5);
                    }else if(position == 6) {
                        sendMsg(6);
                    }else if(position == 7) {
                        sendMsg(7);
                    }else if(position == 8) {
                        sendMsg(8);
                    }else if(position == 9) {
                        sendMsg(9);
                    }else if(position == 10) {
                        sendMsg(10);
                    }else if(position == 11) {
                        sendMsg(11);
                    }else if(position == 12) {
                        sendMsg(12);
                    }else if(position == 13) {
                        sendMsg(13);
                    }else {
                    }
                }
            });
        }
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
     * 获取右侧列表数据
     */
    List<PetCategoryMainRightList.Category_main.Tuijian> tuijianList;
    List<PetCategoryMainRightList.Category_main.Tuijian> epet_guojiList;
    List<PetCategoryMainRightList.Category_main.Tuijian> dog_clothesList;
    List<PetCategoryMainRightList.Category_main.Tuijian> dog_wodianList;
    List<PetCategoryMainRightList.Category_main.Tuijian> dog_zhuliangList;
    List<PetCategoryMainRightList.Category_main.Tuijian> dog_lingshiList;
    List<PetCategoryMainRightList.Category_main.Tuijian> dog_wanjuList;
    List<PetCategoryMainRightList.Category_main.Tuijian> dog_qingjieList;
    List<PetCategoryMainRightList.Category_main.Tuijian> dog_baojianList;
    List<PetCategoryMainRightList.Category_main.Tuijian> dog_huliList;
    List<PetCategoryMainRightList.Category_main.Tuijian> dog_shenghuoList;
    List<PetCategoryMainRightList.Category_main.Tuijian> dog_qianyinList;
    List<PetCategoryMainRightList.Category_main.Tuijian> dog_meirongList;
    List<PetCategoryMainRightList.Category_main.Tuijian> dog_chuyouxizaoList;
    private void getRightMenuData() {
        if (tuijianList != null)tuijianList.clear();
        else tuijianList = new ArrayList<>();
        if (epet_guojiList != null)epet_guojiList.clear();
        else epet_guojiList = new ArrayList<>();
        if (dog_clothesList != null)dog_clothesList.clear();
        else dog_clothesList = new ArrayList<>();
        if (dog_wodianList != null)dog_wodianList.clear();
        else dog_wodianList = new ArrayList<>();
        if (dog_zhuliangList != null)dog_zhuliangList.clear();
        else dog_zhuliangList = new ArrayList<>();
        if (dog_lingshiList != null)dog_lingshiList.clear();
        else dog_lingshiList = new ArrayList<>();
        if (dog_wanjuList != null)dog_wanjuList.clear();
        else dog_wanjuList = new ArrayList<>();
        if (dog_qingjieList != null)dog_qingjieList.clear();
        else dog_qingjieList = new ArrayList<>();
        if (dog_baojianList != null)dog_baojianList.clear();
        else dog_baojianList = new ArrayList<>();
        if (dog_huliList != null)dog_huliList.clear();
        else dog_huliList = new ArrayList<>();
        if (dog_shenghuoList != null)dog_shenghuoList.clear();
        else dog_shenghuoList = new ArrayList<>();
        if (dog_qianyinList != null)dog_qianyinList.clear();
        else dog_qianyinList = new ArrayList<>();
        if (dog_meirongList != null)dog_meirongList.clear();
        else dog_meirongList = new ArrayList<>();
        if (dog_chuyouxizaoList != null)dog_chuyouxizaoList.clear();
        else dog_chuyouxizaoList = new ArrayList<>();
        String json = FileUtils.getJson(getActivity(), "pet_dog_category_main_right.json");
        Gson gson = new Gson();
        Type type = new TypeToken<PetCategoryMainRightList>() {}.getType();
        PetCategoryMainRightList petCategoryMainRightList = gson.fromJson(json, type);
        PetCategoryMainRightList.Category_main category_main = petCategoryMainRightList.getCategory_main();
        List<PetCategoryMainRightList.Category_main.Tuijian> tuijian = category_main.getTuijian();
        List<PetCategoryMainRightList.Category_main.Tuijian> epet_guoji = category_main.getEpet_guoji();
        List<PetCategoryMainRightList.Category_main.Tuijian> dog_clothes = category_main.getDog_clothes();
        List<PetCategoryMainRightList.Category_main.Tuijian> dog_wodian = category_main.getDog_wodian();
        List<PetCategoryMainRightList.Category_main.Tuijian> dog_zhuliang = category_main.getDog_zhuliang();
        List<PetCategoryMainRightList.Category_main.Tuijian> dog_lingshi = category_main.getDog_lingshi();
        List<PetCategoryMainRightList.Category_main.Tuijian> dog_wanju = category_main.getDog_wanju();
        List<PetCategoryMainRightList.Category_main.Tuijian> dog_qingjie = category_main.getDog_qingjie();
        List<PetCategoryMainRightList.Category_main.Tuijian> dog_baojian = category_main.getDog_baojian();
        List<PetCategoryMainRightList.Category_main.Tuijian> dog_huli = category_main.getDog_huli();
        List<PetCategoryMainRightList.Category_main.Tuijian> dog_shenghuo = category_main.getDog_shenghuo();
        List<PetCategoryMainRightList.Category_main.Tuijian> dog_qianyin = category_main.getDog_qianyin();
        List<PetCategoryMainRightList.Category_main.Tuijian> dog_meirong = category_main.getDog_meirong();
        List<PetCategoryMainRightList.Category_main.Tuijian> dog_chuyouxizao = category_main.getDog_chuyouxizao();
        tuijianList.addAll(tuijian);
        epet_guojiList.addAll(epet_guoji);
        dog_clothesList.addAll(dog_clothes);
        dog_wodianList.addAll(dog_wodian);
        dog_zhuliangList.addAll(dog_zhuliang);
        dog_lingshiList.addAll(dog_lingshi);
        dog_wanjuList.addAll(dog_wanju);
        dog_qingjieList.addAll(dog_qingjie);
        dog_baojianList.addAll(dog_baojian);
        dog_huliList.addAll(dog_huli);
        dog_shenghuoList.addAll(dog_shenghuo);
        dog_qianyinList.addAll(dog_qianyin);
        dog_meirongList.addAll(dog_meirong);
        dog_chuyouxizaoList.addAll(dog_chuyouxizao);
    }


    /**
     * 加载左侧菜单数据
     */
    private void getLeftMenuData() {
        String json = FileUtils.getJson(getActivity(), "pet_dog_category_main_left.json");
        Gson gson = new Gson();
        Type type = new TypeToken<PetCategoryMainLeftMenu>() {}.getType();
        PetCategoryMainLeftMenu petCategoryMainLeftMenu = gson.fromJson(json, type);
        List<PetCategoryMainLeftMenu.Alert_target> alert_target = petCategoryMainLeftMenu.getAlert_target();
        List<PetCategoryMainLeftMenu.Categorys> categorys = petCategoryMainLeftMenu.getCategorys();
        for (PetCategoryMainLeftMenu.Categorys categoryObject: categorys) {
            String name = categoryObject.getName();
            categorysesNameList.add(name);
        }
        categorysesLeft.addAll(categorys);
        mBooleanArray = new SparseBooleanArray(categorysesNameList.size());
        mBooleanArray.put(0, true);
        mLeftAdapter.notifyDataSetChanged();
        sendMsg(0);
    }


    private void sendMsg(int i) {
        Message message = Message.obtain();
        message.what = i;
        handler.sendMessage(message);
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

}