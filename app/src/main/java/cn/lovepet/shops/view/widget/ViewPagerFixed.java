package cn.lovepet.shops.view.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * @author JSYL-DCL
 * @date 2018/10/24 15:16
 * @des
 */
public class ViewPagerFixed extends ViewPager {
    public ViewPagerFixed(Context paramContext) {
        super(paramContext);
    }

    public ViewPagerFixed(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
        try {
            boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
            return bool;
        } catch (Exception event) {
            event.printStackTrace();
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        try {
            boolean bool = super.onTouchEvent(paramMotionEvent);
            return bool;
        } catch (Exception event) {
            event.printStackTrace();
        }
        return false;
    }
}
