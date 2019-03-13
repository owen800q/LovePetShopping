package cn.lovepet.shops.helper.customview;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * @author JSYL-DCL
 * @date 2018/10/24 16:37
 * @des
 */
public class MyTextView extends TextView
{
    public MyTextView(Context paramContext)
    {
        super(paramContext);
    }

    public MyTextView(Context paramContext, AttributeSet paramAttributeSet)
    {
        super(paramContext, paramAttributeSet);
    }

    public MyTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
        super(paramContext, paramAttributeSet, paramInt);
    }

    @TargetApi(21)
    public MyTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
    {
        super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    }

//    public void setDelete(boolean paramBoolean)
//    {
//        if (paramBoolean) {
//            getPaint().setFlags(16);
//        }
//        for (;;)
//        {
//            getPaint().setAntiAlias(true);
//            return;
//            getPaint().setFlags(0);
//        }
//    }

    public void setGone()
    {
        if (getVisibility() != View.GONE) {
            setVisibility(View.GONE);
        }
    }

    public void setInVisible()
    {
        if (getVisibility() != View.INVISIBLE) {
            setVisibility(View.INVISIBLE);
        }
    }

    public void setTextHtml(String paramString)
    {
        setText(Html.fromHtml(paramString));
    }

    public void setUnderLine()
    {
        getPaint().setFlags(8);
        getPaint().setAntiAlias(true);
    }

    public void setVisible()
    {
        if (getVisibility() != View.VISIBLE) {
            setVisibility(View.VISIBLE);
        }
    }
}
