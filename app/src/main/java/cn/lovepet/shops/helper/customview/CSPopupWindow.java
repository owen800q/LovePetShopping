package cn.lovepet.shops.helper.customview;

/**
 * @author JSYL-DCL
 * @date 2018/11/22 16:23
 * @des
 */

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.PopupWindow;

public class CSPopupWindow
        extends PopupWindow {
    FrameLayout mBackGround;
    private Drawable mBackgroundDrawable;
    private Context mContext;
    private float mShowAlpha = 0.5F;

    public CSPopupWindow(Context paramContext) {
        this.mContext = paramContext;
        initBasePopupWindow();
    }

    private void addKeyListener(View paramView) {
        if (paramView != null) {
            paramView.setFocusable(true);
            paramView.setFocusableInTouchMode(true);
            paramView.setOnKeyListener(new View.OnKeyListener() {
                public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent) {
                    switch (paramAnonymousInt) {
                        default:
                            return false;
                    }
//                    CSPopupWindow.this.dismiss();
//                    return true;
                }
            });
        }
    }

    private ValueAnimator dismissAnimator() {
        ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[]{this.mShowAlpha, 1.0F});
        localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator) {
                float f = ((Float) paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
                CSPopupWindow.this.setWindowBackgroundAlpha(f);
            }
        });
        localValueAnimator.setDuration(300L);
        return localValueAnimator;
    }

    private void initBasePopupWindow() {
        setAnimationStyle(16973826);
        setHeight(-2);
        setWidth(-2);
        setOutsideTouchable(false);
        setFocusable(false);
    }

    private void setWindowBackgroundAlpha(float paramFloat) {
        if (this.mBackGround == null) {
            Window localWindow = AppPackageHelper.getActivityByView(getContext()).getWindow();
            WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
            localLayoutParams.alpha = paramFloat;
            localWindow.setAttributes(localLayoutParams);
            return;
        }
        this.mBackGround.getForeground().setAlpha((int) ((1.0F - paramFloat) * 240.0F));
    }

    private ValueAnimator showAnimator() {
        ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[]{1.0F, this.mShowAlpha});
        localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator) {
                float f = ((Float) paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
                CSPopupWindow.this.setWindowBackgroundAlpha(f);
            }
        });
        localValueAnimator.setDuration(300L);
        return localValueAnimator;
    }

    public void dismiss() {
        super.dismiss();
        dismissAnimator().start();
    }

    public Context getContext() {
        return this.mContext;
    }

    public FrameLayout getmBackGround() {
        return this.mBackGround;
    }

    public void setBackgroundDrawable(Drawable paramDrawable) {
        this.mBackgroundDrawable = paramDrawable;
        setOutsideTouchable(isOutsideTouchable());
    }

    public void setContentView(View paramView) {
        if (paramView != null) {
            paramView.measure(0, 0);
            super.setContentView(paramView);
            addKeyListener(paramView);
            AppPackageHelper.getActivityByView(getContext()).getWindow();
        }
    }

    public void setOutsideTouchable(boolean paramBoolean) {
        super.setOutsideTouchable(paramBoolean);
        if (this.mBackgroundDrawable == null) {
            this.mBackgroundDrawable = new ColorDrawable(0);
        }
        super.setBackgroundDrawable(this.mBackgroundDrawable);
    }

    public CSPopupWindow setmBackGround(FrameLayout paramFrameLayout) {
        this.mBackGround = paramFrameLayout;
        return this;
    }

    public void showAsDropDown(View paramView) {
        super.showAsDropDown(paramView);
        showAnimator().start();
    }

    public void showAsDropDown(View paramView, int paramInt1, int paramInt2) {
        super.showAsDropDown(paramView, paramInt1, paramInt2);
        showAnimator().start();
    }

    public void showAsDropDown(View paramView, int paramInt1, int paramInt2, int paramInt3) {
        super.showAsDropDown(paramView, paramInt1, paramInt2, paramInt3);
        showAnimator().start();
    }

    public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3) {
        super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
        showAnimator().start();
    }
}
