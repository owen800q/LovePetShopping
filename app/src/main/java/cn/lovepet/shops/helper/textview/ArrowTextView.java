package cn.lovepet.shops.helper.textview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * @author JSYL-DCL
 * @date 2018/12/21 14:01
 * @des 带会话箭头的textview
 */
public class ArrowTextView extends TextView {

    public ArrowTextView(Context context) {
        super(context);
    }

    public ArrowTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ArrowTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);   //设置画笔抗锯齿
        paint.setStrokeWidth(2);    //设置线宽
        paint.setColor(Color.WHITE);  //设置线的颜色

        int height = getHeight();   //获取View的高度
        int width = getWidth();     //获取View的宽度

        //框定文本显示的区域
        canvas.drawRoundRect(new RectF(getPaddingLeft() - 20,getPaddingTop() - 20,width - getPaddingRight() + 20,height - getPaddingBottom()+20),30,30,paint);

        Path path = new Path();

        //以下是绘制文本的那个箭头
        path.moveTo(width / 2, height);// 三角形顶点
        path.lineTo(width / 2 - 20, height - getPaddingBottom());   //三角形左边的点
        path.lineTo(width / 2 + 20, height - getPaddingBottom());   //三角形右边的点

        path.close();
        canvas.drawPath(path, paint);
        super.onDraw(canvas);
    }
}