package cn.lovepet.shops.util;

import android.graphics.Paint;
import android.widget.TextView;

/**
 * @author JSYL-DCL
 * @date 2018/11/19 16:56
 * @des
 */
public class ViewUtils {
    /**
     * textView设置横线，用于商品原价
     * @param textview
     * @param isMiddle
     */
    public static void setPriceLine(TextView textview,int isMiddle){
        if (isMiddle == 0){
            textview.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG ); //中间横线
        }else {
            textview.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//下划线
        }
        textview.getPaint().setAntiAlias(true);// 抗锯齿
    }
}