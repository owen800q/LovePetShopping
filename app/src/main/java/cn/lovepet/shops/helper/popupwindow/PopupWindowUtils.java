package cn.lovepet.shops.helper.popupwindow;

import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.widget.PopupWindow;

/**
 * @author JSYL-DCL
 * @date 2018/12/25 16:19
 * @des
 */
public class PopupWindowUtils {
    public void setBaseAnchorViewBg(PopupWindow mPopupWindow, View baseView){
        if (Build.VERSION.SDK_INT != Build.VERSION_CODES.N) {
            //只有24这个版本有问题，源码的问题
            mPopupWindow.showAsDropDown(baseView);
        } else {
            int[] location = new int[2];
            baseView.getLocationOnScreen(location);
            int y = location[1];
            mPopupWindow.showAtLocation(baseView, Gravity.NO_GRAVITY, 0, y + baseView.getHeight() );
        }
    }
}