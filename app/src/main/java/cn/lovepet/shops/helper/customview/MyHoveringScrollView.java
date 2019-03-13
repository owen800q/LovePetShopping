package cn.lovepet.shops.helper.customview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;

import cn.lovepet.shops.R;
import cn.lovepet.shops.util.DensityUtil;

/**
 * Created by dingcl on 2018/8/19.
 */
public class MyHoveringScrollView extends FrameLayout {
    private ViewGroup mTopView;
    private ViewGroup mContentView;
    private int mTopViewTop;
    private View mTopContent;

    private FrameLayout mTitleView;

    public MyHoveringScrollView(@NonNull Context context) {
        this(context,null);
    }

    public MyHoveringScrollView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyHoveringScrollView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        post(new Runnable() {
            @Override
            public void run() {
                mContentView = (ViewGroup) getChildAt(0);
                mTitleView = mContentView.findViewById(R.id.ll_title);
                removeAllViews();
                MyScrollView scrollView = new MyScrollView(getContext(), MyHoveringScrollView.this);
                scrollView.addView(mContentView);
                addView(scrollView);
            }
        });
    }

    public void setTopView(final int id) {
        post(new Runnable() {
            @Override
            public void run() {
                mTopView = (ViewGroup) mContentView.findViewById(id);
                mTitleView = ((FrameLayout) mTopView.findViewById(R.id.ll_title));
                int height = mTopView.getChildAt(0).getMeasuredHeight();
                ViewGroup.LayoutParams params = mTopView.getLayoutParams();
                params.height = height;
                mTopView.setLayoutParams(params);
                mTopViewTop = mTopView.getTop();
                mTopContent = mTopView.getChildAt(0);
            }
        });
    }

    private static class MyScrollView extends ScrollView {
        private MyHoveringScrollView mScrollView;

        public MyScrollView(Context context, MyHoveringScrollView scrollView) {
            super(context);
            mScrollView = scrollView;
        }

        @Override
        protected void onScrollChanged(int l, int t, int oldl, int oldt) {
            super.onScrollChanged(l, t, oldl, oldt);
            mScrollView.onScroll(t);
        }
    }

    public void onScroll(final int scrollY) {
        post(new Runnable() {
            @Override
            public void run() {
                if (mTopView==null){
                    return;
                }
                if (scrollY >= mTopViewTop- DensityUtil.dip2px(getContext(),50)&&mTopContent.getParent()==mTopView){
                    mTopView.removeView(mTopContent);
                    addView(mTopContent);
                    mTitleView.setVisibility(VISIBLE);
                }else if(scrollY < mTopViewTop-DensityUtil.dip2px(getContext(),50)&&mTopContent.getParent() == MyHoveringScrollView.this){
                    removeView(mTopContent);
                    mTopView.addView(mTopContent);
                    mTitleView.setVisibility(GONE);
                }
            }
        });
    }
}
