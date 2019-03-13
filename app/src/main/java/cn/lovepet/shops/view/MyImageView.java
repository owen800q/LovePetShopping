package cn.lovepet.shops.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * @author JSYL-DCL
 * @date 2018/10/18 10:27
 * @des
 */
public class MyImageView extends ImageView
{
    public MyImageView(Context paramContext)
    {
        super(paramContext);
        initViews();
    }

    public MyImageView(Context paramContext, AttributeSet paramAttributeSet)
    {
        super(paramContext, paramAttributeSet);
        initViews();
    }

    public MyImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
        super(paramContext, paramAttributeSet, paramInt);
        initViews();
    }

    @TargetApi(21)
    public MyImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
    {
        super(paramContext, paramAttributeSet, paramInt1, paramInt2);
        initViews();
    }

    protected void initViews() {}
}
