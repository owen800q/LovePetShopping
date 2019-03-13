package cn.lovepet.shops.helper.recyclerview;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import cn.lovepet.shops.R;

public class RefreshRecyclerView extends LinearLayout implements GestureDetector.OnGestureListener{

    public static final long ONE_MINUTE = 60 * 1000;//一分钟的毫秒值，用于判断上次的更新时间

    public static final long ONE_HOUR = 60 * ONE_MINUTE;//一小时的毫秒值，用于判断上次的更新时间

    public static final long ONE_DAY = 24 * ONE_HOUR;//一天的毫秒值，用于判断上次的更新时间

    public static final long ONE_MONTH = 30 * ONE_DAY;//一月的毫秒值，用于判断上次的更新时间

    public static final long ONE_YEAR = 12 * ONE_MONTH;//一年的毫秒值，用于判断上次的更新时间

    private final GestureDetector mGestureDetector;//手势监听

    private int id;//用来区分不同页面

    private LinearLayout headerView;//刷新头部布局

    public static final int SCROLL_SPEED = -10;//下拉头部回滚的速度

    private int topPadding;//距离顶部的padding值

    private RecyclerView mRecyclerView;//列表控件

    private LinearLayoutManager mLayoutManager;//RecyclerView布局管理器

    private int firstVisibleItemPostion;//第一个可见item的position

    private int mHeaderHeight;//头部高度

    private boolean hasMore;//设置是否有加载更多(用户设置)

    private boolean hasRefresh;//设置是否有下拉刷新（用户设置）

    private boolean canRefresh;//是否可以下拉刷新（逻辑判断）

    private boolean isLoading;//列表是否正在刷新或加载更多中

    private boolean canScroll;//列表是否可以滚动（刷新加载中禁止用户进行列表操作）

    private LoadLinsteners loadLinsteners;//加载监听器

    private ScrollLinsteners scrollLinsteners;//滚动监听器

//    private BaseAdapter mAdapter;//Item适配器

    //头部相关
    private TextView description, updated_at;//描述

    private Long lastUpdateTime;//上次更新时间

    private ImageView arrow;//箭头

    private ProgressBar progress_bar;

    private ImageView iv_head;//头部图片

    private Context context;

    private int readCount;//判断当前列表最大滚动位置

    private static final String TAG = "RefreshRecyclerView";


    private int scroll_count;

    private boolean scrlled;//是否滚动了,优化用


    //用来计时
    private Map<Integer, Long> maps = new HashMap<>();

    public RefreshRecyclerView(Context context) {
        this(context, null);
    }

    public RefreshRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
//        initContents();
        mGestureDetector = new GestureDetector(context, this);
        scroll_count = -1;
    }

    /**
     * 初始化
     */
   /* private void initContents() {
        //默认可下拉刷新，无加载更多
        canRefresh = true;
        hasMore = false;
        hasRefresh = true;
        isLoading = false;
        canScroll = true;

        //头部
        headerView = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.item_recyler_header, null);
        iv_head = (ImageView)headerView.findViewById(R.id.iv_head);
        description = (TextView)headerView.findViewById(R.id.description);
        updated_at = (TextView)headerView.findViewById(R.id.updated_at);
        arrow = (ImageView)headerView.findViewById(R.id.arrow);
        progress_bar = (ProgressBar)headerView.findViewById(R.id.progress_bar);

        //测量并获取头部高度
        measureView(headerView);
        mHeaderHeight = headerView.getMeasuredHeight();

        //列表
        mRecyclerView = new RecyclerView(context);
        mRecyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        //创建默认的线性LayoutManager
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        //添加布局
        setOrientation(VERTICAL);
        addView(headerView, new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        addView(mRecyclerView, new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1));

        //隐藏头部
        setTopPadding(-mHeaderHeight);

        setLinsteners();

        *//**
         * 添加旋转动画
         *//*
        Animation animation= AnimationUtils.loadAnimation(context, R.anim.anim_rotate_earth);
        LinearInterpolator lin = new LinearInterpolator();
        animation.setInterpolator(lin);
        iv_head.startAnimation(animation);

    }*/

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    /**
     * 设置布局管理器
     * @param layoutManager
     */
    public void setmLayoutManager(LinearLayoutManager layoutManager){
        this.mLayoutManager = layoutManager;
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    /**
     * 获取布局管理器
     * @return
     */
    public RecyclerView.LayoutManager getmLayoutManager(){
        return mLayoutManager;
    }


    /**
     * 设置adapter
     * @param mAdapter
     */
//    public void setAdapter(BaseAdapter mAdapter){
//        this.mAdapter = mAdapter;
//        mRecyclerView.setAdapter(mAdapter);
//    }

    /**
     * 获取recyclerview
     * @return
     */
    public RecyclerView getmRecyclerView(){
        return mRecyclerView;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        Log.i(TAG, "onFling: " + Math.abs(v1));
        if(Math.abs(v1) > 4000){
//            mAdapter.setScrolling(true);
        }
        return false;
    }

    /**
     * 加载监听器
     */
    public interface LoadLinsteners{
        void onLoadMore();
        void onRefresh();
    }

    /**
     * 设置监听器
     * @param loadLinsteners
     * @param id
     */
    public void setLoadLinsteners(LoadLinsteners loadLinsteners, int id){
        this.loadLinsteners = loadLinsteners;
        this.id = id;
//        refreshUpdatedAtValue();
    }
    /**
     * 设置监听器
     * @param loadLinsteners
     */
    public void setLoadLinsteners(LoadLinsteners loadLinsteners){
        this.loadLinsteners = loadLinsteners;
        this.id = -1;
//        refreshUpdatedAtValue();
    }

    /**
     * 滚动监听接口
     */
    public  interface ScrollLinsteners{
        void onScrolled(int firstVisibleItem, int dx, int dy);
    }


    public interface CardShowLinsteners{
        void cardshow(int visiblePostion, long begin_time, long end_time, boolean clicked);
    }

    private CardShowLinsteners cardShowLinsteners;
    public void setCardShowLinsteners(CardShowLinsteners cardShowLinsteners){
        this.cardShowLinsteners = cardShowLinsteners;
    }


    public void getItemClickTime(int postion){
        if(cardShowLinsteners != null && maps.size() > postion){
            cardShowLinsteners.cardshow(postion, maps.get(postion), System.currentTimeMillis(), true);
        }
    }

    /**
     * 设置滚动监听
     * @param scrollLinsteners
     */
    public void setScrollLinsteners(ScrollLinsteners scrollLinsteners){
        this.scrollLinsteners = scrollLinsteners;
    }

    /**
     * 获取最大滚动位置
     * @return
     */
    public int getReadCount(){
        return readCount;
    }


    /**
     * 获取滚动次数
     */
    public int getScrollCount(){
        return scroll_count;
    }

    public void setScrollCount(int scroll_count){
        this.scroll_count = scroll_count;
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return !canScroll;
    }

    private float moveY, startY = -1, dY;

    private void setLinsteners() {
        /**
         * 添加触摸监听，实现下拉效果
         */
        mRecyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                mGestureDetector.onTouchEvent(event);

                if (canRefresh && firstVisibleItemPostion == 0 && !isLoading && hasRefresh) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            startY = -1;
                            Log.i("touch----", "down   startY "+ startY + "  moveY " + moveY);

                            break;
                        case MotionEvent.ACTION_MOVE:
                            moveY = event.getRawY();
                            Log.i("touch----b", "move_b   startY "+ startY + "   moveY " + moveY);
                            if(startY == -1) {
                                startY = moveY;
                            }
                            dY = moveY - startY;
                            Log.i("touch----", "move   startY "+ startY + "   moveY " + moveY + "   dY " + dY);
                            if (dY > 30) {
                                dY = dY - 30;
                                int maxLength = mHeaderHeight * 6;
                                if (dY < maxLength && dY >= 30) {
                                    description.setText(R.string.pull_to_refresh);
                                } else if (dY >= maxLength) {
                                    description.setText(R.string.release_to_refresh);
                                    dY = maxLength;
                                }

                                if(dY > mHeaderHeight){
                                    dY = (dY + mHeaderHeight)/2;
                                }
                                setTopPadding((int)(dY - mHeaderHeight));
                            } else {
                                setTopPadding(- mHeaderHeight);
                                return false;
                            }
                            break;
                        case MotionEvent.ACTION_UP:
                            Log.i("touch----", "up   startY "+ startY + "   moveY " + moveY + "   dY " + dY);
                            if (dY > mHeaderHeight) {
                                isLoading = true;
                                canScroll = false;
                                canRefresh = false;
                                description.setText(R.string.refreshing);
                                arrow.setVisibility(View.GONE);
                                progress_bar.setVisibility(View.VISIBLE);
                                new RefreshingTask().execute();
                            } else {
                                startY = -1;
                                new HideHeaderTask().execute();
                            }
                            dY = 0;
                            startY = -1;
                            moveY = 0;
                            return false;
                    }
                    return true;
                }
                return false;
            }
        });

        /**
         * 添加滚动监听，判断加载更多
         */
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if(dy != 0){
                    scrlled = true;
                }

                firstVisibleItemPostion = mLayoutManager.findFirstVisibleItemPosition();
                int lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
                int totalItemCount = mLayoutManager.getItemCount();
                if (readCount <= lastVisibleItem) {
                    readCount = lastVisibleItem;
                }

                //数据统计(用来统计每个卡片被展示的起始时间和位置)
                if(cardShowLinsteners != null) {
                    int size = lastVisibleItem - firstVisibleItemPostion;
                    if (size > 0) {
                        long time = System.currentTimeMillis();
                        Iterator<Map.Entry<Integer, Long>> it = maps.entrySet().iterator();
                        while(it.hasNext()){
                            Map.Entry<Integer, Long> entry=it.next();
                            int key=entry.getKey();
                            if (key > lastVisibleItem || key < firstVisibleItemPostion) {
                                Long ttime = entry.getValue();
                                it.remove();
                                if (time - ttime > 2000) {
                                    cardShowLinsteners.cardshow(key, ttime, time, false);
                                }
                            }
                        }

                        for (int i = 0; i < size; i++) {
                            if (!maps.containsKey(firstVisibleItemPostion + i)) {//没有
                                maps.put(firstVisibleItemPostion + i, time);
                            }
                        }
                    }
                }




                //lastVisibleItem >= totalItemCount - 4 表示剩下4个item自动加载
                // dy > 0 表示向下滑动
                if (lastVisibleItem >= totalItemCount - 4 && dy >= 0) {
                    if (hasMore && !isLoading) {//可以下拉刷新并且没有加载中
                        isLoading = true;
                        canScroll = true;
                        if (loadLinsteners != null) {
                            loadLinsteners.onLoadMore();
                        }
                    }
                }

                //如果列表在头部
                if (firstVisibleItemPostion == 0 && mLayoutManager.getChildAt(0).getTop() == 0 && hasRefresh) {
                    canRefresh = true;
//                    startY = -1;
                } else {
                    canRefresh = false;
                }

                if (scrollLinsteners != null) {
                    scrollLinsteners.onScrolled(firstVisibleItemPostion, dx, dy);
                }
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                Log.i(TAG, "stated:" + newState + "  time:" + System.currentTimeMillis());
                switch (newState){
                    case RecyclerView.SCROLL_STATE_IDLE: // The RecyclerView is not currently scrolling.
                        scroll_count ++;
//                        Log.i("scroll_state", "state:" + "停止");
//                        if(mAdapter.getScrolling() && scrlled) {
//                            //对于滚动不加载图片的尝试
//                            mAdapter.setScrolling(false);
//                            mAdapter.notifyDataSetChanged();
//                        }

                        scrlled = false;
                        break;
                    case RecyclerView.SCROLL_STATE_DRAGGING: // The RecyclerView is currently being dragged by outside input such as user touch input.
//                        mAdapter.setScrolling(false);
//                        Log.i("scroll_state", "state:" + "拖拽");
                        break;
                    case RecyclerView.SCROLL_STATE_SETTLING: // The RecyclerView is currently animating to a final position while not under
//                        mAdapter.setScrolling(true);
//                        Log.i("scroll_state", "state:" + "滚动到某地");
                        break;
                }
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
    }


    /**
     * 设置顶部padding值
     */
    public void setTopPadding(int top){
        topPadding = top;
        setPadding(0, top, 0, 0);
    }


    /**
     * 停止下拉刷新
     */
    public void onStopRefresh(){
        new HideHeaderTask().execute();
        canRefresh = true;
        isLoading = false;
        canScroll = true;
        arrow.setVisibility(View.GONE);
        progress_bar.setVisibility(View.GONE);
        saveTv_refresh_time();
    }

    /**
     * 停止加载更多
     */
    public void onStopMore(){
        isLoading = false;
    }

    /**
     * 保存刷新时间
     */
    public void saveTv_refresh_time(){
        if(id == -1)return;
        saveSPLongData(TAG + id, System.currentTimeMillis());
//        refreshUpdatedAtValue();
    }



    public void setId(int id){
        this.id = id;
    }

    /**
     * 是否可以加载更多
     * @param hasMore
     */
//    public void setHasMore(boolean hasMore){
//        this.hasMore = hasMore;
//        if(mAdapter != null) {
//            mAdapter.setHasMore(hasMore);
//        }
//    }

    /**
     * 是否可以下拉刷新
     * @param hasRefresh
     */
    public void setHasRefresh(boolean hasRefresh){
        this.hasRefresh = hasRefresh;
    }

    /**
     * 测量布局
     */
    private void measureView(View child) {
        ViewGroup.LayoutParams params = child.getLayoutParams();
        if (params == null) {
            params = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        int childWidthSpec = ViewGroup.getChildMeasureSpec(0, 0, params.width);
        int lpHeight = params.height;
        int childHeightSpec;
        if (lpHeight > 0) {
            childHeightSpec = MeasureSpec.makeMeasureSpec(lpHeight, MeasureSpec.EXACTLY);
        } else {
            childHeightSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        }
        child.measure(childWidthSpec, childHeightSpec);
    }


    /**
     * 刷新下拉头中上次更新时间的文字描述。
     */
   /* private void refreshUpdatedAtValue() {
        if(id == -1)return;
        lastUpdateTime = getSPLongData(TAG + id);
        long currentTime = System.currentTimeMillis();
        long timePassed = currentTime - lastUpdateTime;
        long timeIntoFormat;
        String updateAtValue;
        if (lastUpdateTime == -1) {
            updateAtValue = getResources().getString(R.string.not_updated_yet);
        } else if (timePassed < 0) {
            updateAtValue = getResources().getString(R.string.time_error);
        } else if (timePassed < ONE_MINUTE) {
            updateAtValue = getResources().getString(R.string.updated_just_now);
        } else if (timePassed < ONE_HOUR) {
            timeIntoFormat = timePassed / ONE_MINUTE;
            String value = timeIntoFormat + "分钟";
            updateAtValue = String.format(getResources().getString(R.string.updated_at), value);
        } else if (timePassed < ONE_DAY) {
            timeIntoFormat = timePassed / ONE_HOUR;
            String value = timeIntoFormat + "小时";
            updateAtValue = String.format(getResources().getString(R.string.updated_at), value);
        } else if (timePassed < ONE_MONTH) {
            timeIntoFormat = timePassed / ONE_DAY;
            String value = timeIntoFormat + "天";
            updateAtValue = String.format(getResources().getString(R.string.updated_at), value);
        } else if (timePassed < ONE_YEAR) {
            timeIntoFormat = timePassed / ONE_MONTH;
            String value = timeIntoFormat + "个月";
            updateAtValue = String.format(getResources().getString(R.string.updated_at), value);
        } else {
            timeIntoFormat = timePassed / ONE_YEAR;
            String value = timeIntoFormat + "年";
            updateAtValue = String.format(getResources().getString(R.string.updated_at), value);
        }
        updated_at.setText(updateAtValue);
    }*/


    /**
     * 正在刷新的任务，在此任务中会去回调注册进来的下拉刷新监听器。
     */
    class RefreshingTask extends AsyncTask<Void, Integer, Integer> {

        @Override
        protected Integer doInBackground(Void... params) {
            int tp = topPadding;
            long curMills = System.currentTimeMillis();
            while (true) {
                long nowMills = System.currentTimeMillis();
                if(nowMills - curMills >= 10){
                    curMills = nowMills;
                    tp = tp + SCROLL_SPEED * 2;
                    if (tp <= 0) {
                        tp = 0;
                        break;
                    }
                    publishProgress(tp);
                }
            }
//            mAdapter.setScrolling(false);
            if(loadLinsteners != null) {
                loadLinsteners.onRefresh();
            }
            return tp;
        }

        @Override
        protected void onProgressUpdate(Integer... tp) {
            setTopPadding(tp[0]);
        }

        @Override
        protected void onPostExecute(Integer tp) {
            setTopPadding(tp);
        }
    }

    /**
     * 隐藏下拉头的任务，当未进行下拉刷新或下拉刷新完成后，此任务将会使下拉头重新隐藏。
     */
    class HideHeaderTask extends AsyncTask<Void, Integer, Integer> {

        @Override
        protected Integer doInBackground(Void... params) {
            int tp = topPadding;
            long curMills = System.currentTimeMillis();
            while (true) {
                long nowMills = System.currentTimeMillis();
                if(nowMills - curMills >= 10) {
                    curMills = nowMills;
                    tp = tp + SCROLL_SPEED;
                    if (tp <= -mHeaderHeight) {
                        tp = -mHeaderHeight;
                        break;
                    }
                    publishProgress(tp);
                    canScroll = true;
                }
            }
            return tp;
        }

        @Override
        protected void onProgressUpdate(Integer... tp) {
            setTopPadding(tp[0]);
        }

        @Override
        protected void onPostExecute(Integer tp) {
            setTopPadding(tp);
        }
    }



    /**
     * 获取账户管理sp
     * @return
     */
    private SharedPreferences getAccountSP() {
        return context.getSharedPreferences("account", Context.MODE_PRIVATE);
    }

    /**
     * 保存Long值
     * @param key
     * @param value
     */
    public void saveSPLongData(String key, long value) {
        getAccountSP().edit().putLong(key, value).commit();
    }


    /**
     * 获取存储的Long值
     * @param key
     * @return
     */
    public Long getSPLongData(String key) {
        return getAccountSP().getLong(key, -1);
    }

}