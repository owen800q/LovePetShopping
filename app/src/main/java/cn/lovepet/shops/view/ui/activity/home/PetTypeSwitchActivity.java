package cn.lovepet.shops.view.ui.activity.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.analytics.MobclickAgent;

import butterknife.BindView;
import butterknife.OnClick;
import cn.lovepet.shops.R;
import cn.lovepet.shops.base.BaseActivity;
import cn.lovepet.shops.helper.looprotary_switchview.listener.OnItemClickListener;
import cn.lovepet.shops.helper.looprotary_switchview.listener.OnItemSelectedListener;
import cn.lovepet.shops.helper.looprotary_switchview.view.LoopRotarySwitchView;

/**
 * @author JSYL-DCL
 * @date 2018/10/23 13:55
 * @des
 */
public class PetTypeSwitchActivity extends BaseActivity implements OnItemClickListener, OnItemSelectedListener {
    private static final java.lang.String TAG1 = PetTypeSwitchActivity.class.getSimpleName();
    private Context context;
    @BindView(R.id.mLoopRotarySwitchView)
    LoopRotarySwitchView mLoopRotarySwitchView;

    @BindView(R.id.dog_text)
    TextView TvDogTitle;
    @BindView(R.id.cat_text)
    TextView TvCatTitle;
    @BindView(R.id.fish_text)
    TextView TvFishTitle;


    @BindView(R.id.current_epettype_note)
    TextView epettypeNote;
    @BindView(R.id.top_epettype)
    TextView topEpettype;
    @BindView(R.id.into_enter)
    TextView intoEnter;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_epetswitch;
    }

    @Override
    protected void init() {
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        context = PetTypeSwitchActivity.this;
        // allow blur radius is 0 < r <= 25
//        baseGlassView.setBlurRadius(25);
        initLoopRotarySwitchView();
    }

    @Override
    protected void initData() {

    }

    @OnClick({
            R.id.switchClose
    })
    public void bindViewClick(View view){
        switch (view.getId()){
            case  R.id.switchClose:
                finish();
                break;
        }
    }

    @Override
    protected void initListener() {
        mLoopRotarySwitchView.setOnItemClickListener(this);
        mLoopRotarySwitchView.setOnItemSelectedListener(this);
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
     * 设置LoopRotarySwitchView
     */
    private void initLoopRotarySwitchView() {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(dm);
        int width=dm.widthPixels;
        mLoopRotarySwitchView
                .setR(width/3)//设置R的大小
                .setMultiple(0.1f)
                .setAutoRotation(false)//是否自动切换
                .setAutoScrollDirection(LoopRotarySwitchView.AutoScrollDirection.left)
                .setAutoRotationTime(1500)//自动切换的时间  单位毫秒
                .setLoopRotationX(5);
        mLoopRotarySwitchView.setSelectItem(4);
//        mLoopRotarySwitchView.initView();

    }

    @Override
    public void onItemClick(int item, View view) {
        Toast.makeText(PetTypeSwitchActivity.this, "click item:"+item, Toast.LENGTH_SHORT).show();
    }

    /**
     * 当前选中监听
     * @param item
     * @param view
     */
    @Override
    public void selected(int item, View view) {
//        Toast.makeText(PetTypeSwitchActivity.this, "select item:"+item, Toast.LENGTH_SHORT).show();
        switch (view.getId()){
            case R.id.rlDog:
                epettypeNote.setText(String.format("您当前在%s站", "狗狗"));
                topEpettype.setText("DOG");
                TvDogTitle.setTextColor(getResources().getColor(R.color.epet_dog));
                intoEnter.setBackgroundResource(R.drawable.bg_epettype_enter_dog);
                break;
            case R.id.rlCat:
                epettypeNote.setText(String.format("您当前在%s站", "猫猫"));
                topEpettype.setText("CAT");
                TvCatTitle.setTextColor(getResources().getColor(R.color.epet_cat));
                intoEnter.setBackgroundResource(R.drawable.bg_epettype_enter_cat);
                break;
            case R.id.rlFish:
                epettypeNote.setText(String.format("您当前在%s站", "水族"));
                topEpettype.setText("FISH");
                TvFishTitle.setTextColor(getResources().getColor(R.color.epet_fish));
                intoEnter.setBackgroundResource(R.drawable.bg_epettype_enter_fish);
                break;
            default:
                break;
        }
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