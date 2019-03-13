package cn.lovepet.shops.helper.imageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;

import cn.lovepet.shops.R;


/**
 * @author JSYL-DCL
 * @date 2018/12/13 13:56
 * @des 自定义圆角矩形ImageView
 */
public class RoundRectImageView extends AppCompatImageView {

    /**
     * 默认的圆角大小，单位为dp
     */
    private static final float DEFAULT_CORNER = 10;
    private Paint mPaint;
    private int mCorner;

    public RoundRectImageView(Context context) {
        this(context,null);
    }

    public RoundRectImageView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public RoundRectImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mPaint = new Paint();
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.RoundRectImageView);
        mCorner = (int) typedArray.getDimension(R.styleable.RoundRectImageView_corner, dp2px(context, DEFAULT_CORNER));
        typedArray.recycle();
    }

    /**
     * 绘制圆角矩形图片
     */
    @Override
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if ( drawable != null ) {
            Bitmap bitmap = null;
            // Drawable转Bitmap
            if(drawable instanceof GlideBitmapDrawable) {
                bitmap = ((GlideBitmapDrawable)drawable).getBitmap();
            } else if(drawable instanceof ColorDrawable){
                bitmap = Bitmap.createBitmap(getWidth(),getHeight(),
                        Config.ARGB_8888);
                bitmap.eraseColor(((ColorDrawable) drawable).getColor());//填充颜色
            }else{
                bitmap = ((BitmapDrawable)drawable).getBitmap();
            }
            Bitmap roundBitmap = getRoundBitmap(bitmap, mCorner);
            final Rect rectSrc = new Rect(0, 0, roundBitmap.getWidth(), roundBitmap.getHeight());
            final Rect rectDest = new Rect(0,0,getWidth(),getHeight());
            // 重置画笔，不然会留下黑色区域
            mPaint.reset();
            canvas.drawBitmap(roundBitmap, rectSrc, rectDest, mPaint);
        } else {
            super.onDraw(canvas);
        }
    }

    /**
     * 裁剪图片
     * @param bitmap
     * @param corner
     * @return Bitmap
     */
    private Bitmap getRoundBitmap(Bitmap bitmap, int corner) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        final Rect rect = new Rect(getPaddingLeft(), getPaddingTop(), bitmap.getWidth()-getPaddingRight(), bitmap.getHeight()-getPaddingBottom());
        final RectF rectF = new RectF(rect);
        mPaint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        mPaint.setColor(Color.WHITE);
        canvas.drawRoundRect(rectF, corner, corner, mPaint);
        // 设置图像混合模式为SRC_IN，裁剪出我们的圆角Bitmap
        mPaint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, mPaint);
        return output;
    }

    /**
     * dp转 px.
     * @param value the value
     * @return the int
     */
    public static int dp2px(Context context, float value) {
        final float scale = context.getResources().getDisplayMetrics().densityDpi;
        return (int) (value * (scale / 160) + 0.5f);
    }
}