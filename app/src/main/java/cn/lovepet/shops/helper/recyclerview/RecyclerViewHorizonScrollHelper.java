package cn.lovepet.shops.helper.recyclerview;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.HorizontalScrollView;

/**
 * @author JSYL-DCL
 * @date 2018/12/12 13:44
 * @des
 */
public class RecyclerViewHorizonScrollHelper {

    /**
     * 滑动到指定位置
     * @param mRecyclerView
     * @param position
     */
    //目标项是否在最后一个可见项之后
    private boolean mShouldScroll;
    //记录目标项位置
    private int mToPosition;
    public void smoothMoveToPosition(RecyclerView mRecyclerView, final int position) {
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
     * HorizontalScrollView 横向点击滑动定位
     * @param childAt
     */
    public void horizontalScrollViewTo(Activity activity,View childAt,HorizontalScrollView mHorizontalScrollView) {
        //获取屏幕宽度
        int screenWidth= activity.getResources().getDisplayMetrics().widthPixels;
        //计算控件居正中时距离左侧屏幕的距离
        int middleLeftPosition=(screenWidth - childAt.getWidth())/2;
        //正中间位置需要向左偏移的距离
        int offset = childAt.getLeft()-middleLeftPosition;
        //让水平的滚动视图按照执行的x的偏移量进行移动
        mHorizontalScrollView.smoothScrollTo(offset,0);
    }
}