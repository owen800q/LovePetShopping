package cn.lovepet.shops.view.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 *    time   : 2018/10/18
 *    desc   : 禁用水平滑动的ViewPager（一般用于APP主页的ViewPager + Fragment）
 */
public class SimpleNoScrollViewPager extends ViewPager {

    public SimpleNoScrollViewPager(Context context) {
        super(context);
    }

    public SimpleNoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    // 不拦截这个事件
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    // 不处理这个事件
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }
}