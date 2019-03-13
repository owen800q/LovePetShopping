package cn.lovepet.shops.view.ui.activity.personal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.lovepet.shops.R;
import cn.lovepet.shops.base.BaseFragment;
import cn.lovepet.shops.base.Constants;
import cn.lovepet.shops.bean.PetPersonalBean;
import cn.lovepet.shops.helper.basequickadapter.BaseMultiItemQuickAdapter;
import cn.lovepet.shops.helper.basequickadapter.BaseQuickAdapter;
import cn.lovepet.shops.helper.basequickadapter.BaseViewHolder;
import cn.lovepet.shops.helper.imageview.DashlineItemDivider;
import cn.lovepet.shops.helper.immersive.title.OnTitleBarListener;
import cn.lovepet.shops.helper.immersive.title.TitleBar;
import cn.lovepet.shops.util.FileUtils;
import cn.lovepet.shops.util.ILog;
import cn.lovepet.shops.util.ToastsUtils;
import cn.lovepet.shops.view.MyImageView;
import cn.lovepet.shops.view.ui.activity.content.ScrollTopActivity;
import cn.lovepet.shops.view.ui.activity.publical.LoginActivity;


/**
 * 我的E宠
 * @author JSYL-DCL
 * @date 2018/8/24 13:58
 * @des
 */
public class PetPersonalFragment extends BaseFragment{
    @BindView(R.id.appbar)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.shopcart1_title_bar)
    TitleBar mTitleBar;
//    @BindView(R.id.tv_info)
//    TextView mTextView;
    @BindView(R.id.llHeader)
    LinearLayout llHeader;
    @BindView(R.id.ivMessage)
    ImageView ivMessage;
    @BindView(R.id.personalRecyclerView)
    RecyclerView mPersonalRecyclerView;
    @BindView(R.id.tvSnap)
    TextView tvSnap;
    @BindView(R.id.tvUserLogin)
    TextView tvUserLogin;
    @BindView(R.id.tvUserRegister)
    TextView tvUserRegister;
    @BindView(R.id.personalAnimCheckinAnimImage)
    MyImageView mCheckinImageView;
    private PersonalAdapter mAdapter;
    private List<PetPersonalBean.Data> personalDataList;

    private final String TAG = PetPersonalFragment.class.getSimpleName();
    private Context _context;
    public PetPersonalFragment() {
    }
    public static PetPersonalFragment newInstance() {
        PetPersonalFragment fragment = new PetPersonalFragment();
        return fragment;
    }

    @Override
    protected int setImmersiveStatusBarColor() {
        return 0;
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_pet_personal;
    }

    @Override
    protected void init() {
        if (personalDataList != null)personalDataList.clear();
        else personalDataList = new ArrayList<>();
    }

    @Override
    protected void bindView() {
        _context = getActivity();
        mTitleBar.setTitle("");
//        tvSnap.setFocusableInTouchMode(true);
//        tvSnap.requestFocus();
//        mPersonalRecyclerView.setNestedScrollingEnabled(false);
        initTitleBarStyle();
        //设置滑动渐变标题栏
        setGradualChangeTitlebar();
        setPersonalData();
    }

    private void setPersonalData() {
        mPersonalRecyclerView.setLayoutManager(new LinearLayoutManager(_context));
        mPersonalRecyclerView.setHasFixedSize(true);
        //添加item分割线
        mPersonalRecyclerView.addItemDecoration(new DashlineItemDivider("#B2B2B2"));
//        mLaunchRecyclerView.setItemViewCacheSize(10);
        mAdapter = new PersonalAdapter(personalDataList);
        //防止数据错乱
        mAdapter.setHasStableIds(true);
        mPersonalRecyclerView.setAdapter(mAdapter);
        loadPersonalData();
    }

    private void loadPersonalData() {
        String json = FileUtils.getJson(getActivity(), "pet_personal.json");
        Gson gson = new Gson();
        Type type = new TypeToken<PetPersonalBean>() {}.getType();
        PetPersonalBean petPersonalBean = gson.fromJson(json, type);
        List<PetPersonalBean.Data> data = petPersonalBean.getData();
        PetPersonalBean.Service_info service_info = petPersonalBean.getService_info();
        String push_alias = petPersonalBean.getPush_alias();
        personalDataList.addAll(data);
        mAdapter.notifyDataSetChanged();

    }


    @Override
    protected void bindData(Bundle savedInstanceState) {
        mCheckinImageView.setImageResource(R.drawable.anim_personal_checkin);
        AnimationDrawable drawable = (AnimationDrawable) mCheckinImageView.getDrawable();
        drawable.setOneShot(false);
        drawable.start();
    }
    @Override
    protected void bindListener() {
        mPersonalRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //dy <0 表示 上滑， dy>0 表示下滑
                if (dy > 0){
                    ILog.e(TAG,"滑动监听 下滑："+ dy);
                }else if (dy < 0){
                    ILog.e(TAG,"滑动监听 上滑："+ dy);
                }
            }
        });
    }

    @OnClick({
            R.id.ivMessage,
            R.id.tvUserLogin,
            R.id.tvUserRegister,
    })
    public void bindViewClick(View view){
        switch (view.getId()){
            case R.id.ivMessage:
                ToastsUtils.showShort("消息");
                break;
            case R.id.tvUserLogin:
                ToastsUtils.showShort("登录");
                String baiDuUrl = Constants.USER_LOGIN_URL;
                LoginActivity.loadUrl(getActivity(), baiDuUrl, "登录/注册");
                break;
            case R.id.tvUserRegister:
                ToastsUtils.showShort("注册");
                break;
        }
    }

    BaseQuickAdapter mMenuListAdapter;
    public class PersonalAdapter extends BaseMultiItemQuickAdapter<PetPersonalBean.Data, BaseViewHolder> {
        /**
         * Same as QuickAdapter#QuickAdapter(Context,int) but with
         * some initialization data.
         *
         * @param data A new list is created out of this one to avoid mutable list
         */
        public PersonalAdapter(List<PetPersonalBean.Data> data) {
            super(data);
            addItemType(PetPersonalBean.Data.MENU_IMAGE, R.layout.item_pet_personal_menu_image_text);
            addItemType(PetPersonalBean.Data.MENU_SINGLE, R.layout.item_pet_personal_menu_single);
            addItemType(PetPersonalBean.Data.MENU_LIST, R.layout.item_pet_personal_menu_list_item);

        }

        @Override
        protected void convert(BaseViewHolder helper, PetPersonalBean.Data item, int position) {
            final List<PetPersonalBean.Data.Datas> datas = item.getDatas();
            final int adapterPosition = helper.getAdapterPosition();
            switch (item.getItemType()) {
                case 0://图文
                    TextView tvNumber1 = (TextView) helper.getView(R.id.tvNumber1);
                    TextView tvNumber2 = (TextView) helper.getView(R.id.tvNumber2);
                    TextView tvNumber3 = (TextView) helper.getView(R.id.tvNumber3);
                    TextView tvNumber4 = (TextView) helper.getView(R.id.tvNumber4);

                    ImageView IvMenu1 = (ImageView) helper.getView(R.id.IvMenu1);
                    ImageView IvMenu2 = (ImageView) helper.getView(R.id.IvMenu2);
                    ImageView IvMenu3 = (ImageView) helper.getView(R.id.IvMenu3);
                    ImageView IvMenu4 = (ImageView) helper.getView(R.id.IvMenu4);

                    TextView tvBottomText1 = (TextView) helper.getView(R.id.tvBottomText1);
                    TextView tvBottomText2 = (TextView) helper.getView(R.id.tvBottomText2);
                    TextView tvBottomText3 = (TextView) helper.getView(R.id.tvBottomText3);
                    TextView tvBottomText4 = (TextView) helper.getView(R.id.tvBottomText4);
                    boolean hastoptext = datas.get(0).getHastoptext();
                    boolean hastoptext1 = datas.get(1).getHastoptext();
                    boolean hastoptext2 = datas.get(2).getHastoptext();
                    boolean hastoptext3 = datas.get(3).getHastoptext();
                    if (datas.get(0).getHastoptext()){
                        tvNumber1.setVisibility(View.VISIBLE);
                        IvMenu1.setVisibility(View.GONE);
                        tvNumber1.setText(datas.get(0).getBottom());
                    }else {
                        tvNumber1.setVisibility(View.GONE);
                        IvMenu1.setVisibility(View.VISIBLE);
                        Glide.with(mContext)
                                .load(datas.get(0).getFirst_img())
                                .asBitmap()
                                .skipMemoryCache(false)
                                .priority(Priority.HIGH)
                                .dontTransform()
                                .placeholder(R.mipmap.pet_image_loadding)
                                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                .into(IvMenu1);
                    }

                    if (datas.get(1).getHastoptext()){
                        tvNumber2.setVisibility(View.VISIBLE);
                        IvMenu2.setVisibility(View.GONE);
                        tvNumber2.setText(datas.get(1).getBottom());
                    }else {
                        tvNumber2.setVisibility(View.GONE);
                        IvMenu2.setVisibility(View.VISIBLE);
                        Glide.with(mContext)
                                .load(datas.get(1).getFirst_img())
                                .asBitmap()
                                .skipMemoryCache(false)
                                .priority(Priority.HIGH)
                                .dontTransform()
                                .placeholder(R.mipmap.pet_image_loadding)
                                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                .into(IvMenu2);
                    }
                    if (datas.get(2).getHastoptext()){
                        tvNumber3.setVisibility(View.VISIBLE);
                        IvMenu3.setVisibility(View.GONE);
                        tvNumber3.setText(datas.get(2).getBottom());
                    }else {
                        tvNumber3.setVisibility(View.GONE);
                        IvMenu3.setVisibility(View.VISIBLE);
                        Glide.with(mContext)
                                .load(datas.get(2).getFirst_img())
                                .asBitmap()
                                .skipMemoryCache(false)
                                .priority(Priority.HIGH)
                                .dontTransform()
                                .placeholder(R.mipmap.pet_image_loadding)
                                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                .into(IvMenu3);
                    }
                    if (datas.get(3).getHastoptext()){
                        tvNumber4.setVisibility(View.VISIBLE);
                        IvMenu4.setVisibility(View.GONE);
                        tvNumber4.setText(datas.get(3).getBottom());
                    }else {
                        tvNumber4.setVisibility(View.GONE);
                        IvMenu4.setVisibility(View.VISIBLE);
                        Glide.with(mContext)
                                .load(datas.get(3).getFirst_img())
                                .asBitmap()
                                .skipMemoryCache(false)
                                .priority(Priority.HIGH)
                                .dontTransform()
                                .placeholder(R.mipmap.pet_image_loadding)
                                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                .into(IvMenu4);
                    }
                    tvBottomText1.setText(datas.get(0).getTop());
                    tvBottomText2.setText(datas.get(1).getTop());
                    tvBottomText3.setText(datas.get(2).getTop());
                    tvBottomText4.setText(datas.get(3).getTop());
                    break;
                case 1://图标
                    int iconIndex = 0;
                    ImageView iconIv = null;
                    ImageView ivSingleImg1 = (ImageView) helper.getView(R.id.ivSingleImg1);
                    ImageView ivSingleImg2 = (ImageView) helper.getView(R.id.ivSingleImg2);
                    ImageView ivSingleImg3 = (ImageView) helper.getView(R.id.ivSingleImg3);
                    ImageView ivSingleImg4 = (ImageView) helper.getView(R.id.ivSingleImg4);
                    TextView tvSingleDash = (TextView) helper.getView(R.id.tvSingleDash);
                    if (item.isHasdash())tvSingleDash.setVisibility(View.VISIBLE);
                    else  tvSingleDash.setVisibility(View.GONE);

                    Glide.with(mContext)
                            .load(datas.get(0).getImg_model().getImage())
                            .asBitmap()
                            .skipMemoryCache(false)
                            .priority(Priority.HIGH)
                            .dontTransform()
                            .placeholder(R.mipmap.pet_image_loadding)
                            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                            .into(ivSingleImg1);
                    Glide.with(mContext)
                            .load(datas.get(1).getImg_model().getImage())
                            .asBitmap()
                            .skipMemoryCache(false)
                            .priority(Priority.HIGH)
                            .dontTransform()
                            .placeholder(R.mipmap.pet_image_loadding)
                            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                            .into(ivSingleImg2);
                    Glide.with(mContext)
                            .load(datas.get(2).getImg_model().getImage())
                            .asBitmap()
                            .skipMemoryCache(false)
                            .priority(Priority.HIGH)
                            .dontTransform()
                            .placeholder(R.mipmap.pet_image_loadding)
                            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                            .into(ivSingleImg3);
                    Glide.with(mContext)
                            .load(datas.get(3).getImg_model().getImage())
                            .asBitmap()
                            .skipMemoryCache(false)
                            .priority(Priority.HIGH)
                            .dontTransform()
                            .placeholder(R.mipmap.pet_image_loadding)
                            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                            .into(ivSingleImg4);
                    break;
                case 2://列表导航
                    final int position1 = adapterPosition-4;
                    ImageView ivIcon = (ImageView) helper.getView(R.id.ivIcon);
                    ((TextView) helper.getView(R.id.tvTitleName)).setText(datas.get(0).getTop());
                    if (datas.get(0).getHasdash())((TextView) helper.getView(R.id.tvDividerBottom)).setVisibility(View.VISIBLE);
                    else ((TextView) helper.getView(R.id.tvDividerBottom)).setVisibility(View.GONE);
                    if (datas.get(0).getHassubtitle()){
                        ((TextView) helper.getView(R.id.tvsubTitle)).setVisibility(View.VISIBLE);
                        ((TextView) helper.getView(R.id.tvsubTitle)).setText(datas.get(0).getBottom());
                    }else {
                        ((TextView) helper.getView(R.id.tvsubTitle)).setVisibility(View.GONE);
                    }
                    helper.getView(R.id.rlTitleContent).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (position1 == 0){
                                startActivity(new Intent(getActivity(),ScrollTopActivity.class));
                            }
                            ToastsUtils.showShort(position1+" "+datas.get(0).getTop());
                        }
                    });
                    Glide.with(mContext)
                            .load(datas.get(0).getFirst_img())
                            .asBitmap()
                            .skipMemoryCache(false)
                            .priority(Priority.NORMAL)
                            .dontTransform()
                            .placeholder(R.mipmap.pet_image_loadding)
                            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                            .into(ivIcon);
                    break;
                default:
                    break;

            }
        }
    }

    private void initTitleBarStyle() {
        if (setImmersiveStatusBarColor() != 0) {
            mTitleBar.setBackgroundResource(setImmersiveStatusBarColor());
        }else{
            mTitleBar.setBackgroundResource(R.color.white);
        }
        mTitleBar.setTitleColor(getMyActivity().getResources().getColor(R.color.color_super_value_text_sale_price));
        mTitleBar.setBackgroundResource(R.color.white);
        mTitleBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onLeftClick(View v) {
//                Toast.makeText(getActivity(), "返回", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onTitleClick(View v) {
                Toast.makeText(getActivity(), "标题", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onRightClick(View v) {
//                startActivity(new Intent(getActivity(), LauncherAllActivity.class));
                SettingActivity.getInstance(_context);
            }
        });
    }

    /**
     * 设置滑动渐变标题栏
     */
    private void setGradualChangeTitlebar() {
        final Drawable drawable = ContextCompat.getDrawable(getActivity(), R.mipmap.index_head_black_setting);
        final Drawable drawable1 = ContextCompat.getDrawable(getActivity(), R.mipmap.index_head_white_setting);
        final Drawable drawable2 = ContextCompat.getDrawable(getActivity(), R.mipmap.index_head_message);
        final Drawable drawable3 = ContextCompat.getDrawable(getActivity(), R.mipmap.index_head_message_);
        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                float percent = Float.valueOf(Math.abs(verticalOffset)) / Float.valueOf(appBarLayout.getTotalScrollRange());
                //第一种
                int toolbarHeight = appBarLayout.getTotalScrollRange();
                int dy = Math.abs(verticalOffset);
                if (dy <= toolbarHeight) {
                    float scale = (float) dy / toolbarHeight;
                    float alpha = scale * 255;
//                    mTitleBar.setTitle("我的E宠");
                    mTitleBar.setBackgroundColor(Color.argb((int) alpha, 255, 255, 255));
                    if ((int) alpha > 240){
                        mTitleBar.setTitle("我的E宠");
                        mTitleBar.setRightIcon(drawable);
                        llHeader.setVisibility(View.GONE);
                        mTitleBar.setLineVisible(true);
                        mTitleBar.setLineColor(getResources().getColor(R.color.common_h7));
                    }else {
                        mTitleBar.setTitle("");
                        mTitleBar.setRightIcon(drawable1);
                        llHeader.setVisibility(View.VISIBLE);
                        mTitleBar.setLineVisible(false);
                    }
//                    mTitleBar.setBackgroundColor(Color.argb((int) alpha, 255, 255, 255));
//                    mTextView.setText("setBackgroundColor(Color.argb((int) "+(int) alpha+", 255, 255, 255))\n"+"mFLayout.setAlpha("+percent+")");
                }
                //第二种
//                mTitleBar.setAlpha(percent);
            }
        });
    }


}
