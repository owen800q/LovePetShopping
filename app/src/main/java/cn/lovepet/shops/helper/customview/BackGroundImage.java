package cn.lovepet.shops.helper.customview;

/**
 * @author JSYL-DCL
 * @date 2018/11/22 16:07
 * @des
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.List;

public class BackGroundImage extends View {
    private float mDegree;
    private List<Drawable> mDrawableLists;
    private Drawable mNext;
    private int mPosition;
    private int mPrePosition = 0;

    public BackGroundImage(Context paramContext) {
        super(paramContext);
    }

    public BackGroundImage(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public BackGroundImage(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    protected void onDraw(Canvas paramCanvas) {
        Log.i("111", "onDraw");
        if (this.mDrawableLists == null) {
            return;
        }
        int i = (int) (255.0F - this.mDegree * 255.0F);
        Drawable localDrawable = (Drawable) this.mDrawableLists.get(this.mPosition);
        localDrawable.setBounds(0, 0, getWidth(), getHeight());
        this.mNext.setBounds(0, 0, getWidth(), getHeight());
        if (this.mPrePosition != this.mPosition) {
            if (this.mPosition == this.mDrawableLists.size() - 1) {
//                break;
            }
        }
        label169:
        for (this.mNext = ((Drawable) this.mDrawableLists.get(this.mPosition + 1)); ; this.mNext = ((Drawable) this.mDrawableLists.get(this.mPosition))) {
            localDrawable.setAlpha(i);
            this.mNext.setAlpha(255);
            this.mNext.draw(paramCanvas);
            localDrawable.draw(paramCanvas);
            this.mPrePosition = this.mPosition;
            super.onDraw(paramCanvas);
            return;
        }
    }

    public void setmDegree(float paramFloat) {
        this.mDegree = paramFloat;
    }

    public void setmDrawableLists(List<Drawable> paramList) {
        this.mDrawableLists = paramList;
        if (paramList.size() > 0) {
        }
        for (int i = 1; ; i = 0) {
            this.mNext = ((Drawable) paramList.get(i));
            return;
        }
    }

    public void setmPosition(int paramInt) {
        this.mPosition = paramInt;
    }
}
