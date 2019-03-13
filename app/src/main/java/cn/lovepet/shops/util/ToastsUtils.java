

package cn.lovepet.shops.util;

import android.content.Context;
import android.widget.Toast;


/**
 * Toast工具类
 * 2018-05
 */
public class ToastsUtils {
    public static Context sContext;
    private ToastsUtils() {
    }
    public static void register(Context context) {
        sContext = context.getApplicationContext();
    }
    private static void check() {
        if (sContext == null) {
            throw new NullPointerException(
                    "Must initial call ToastUtils.register(Context context) in your " +
                            "<? " +
                            "extends Application class>");
        }
    }
    public static void showShort(int resId) {
        check();
        Toast.makeText(sContext, resId, Toast.LENGTH_SHORT).show();
    }
    public static void showShort(String message) {
        check();
        Toast.makeText(sContext, message, Toast.LENGTH_SHORT).show();
    }
    public static void showLong(int resId) {
        check();
        Toast.makeText(sContext, resId, Toast.LENGTH_LONG).show();
    }
    public static void showLong(String message) {
        check();
        Toast.makeText(sContext, message, Toast.LENGTH_LONG).show();
    }
    public static void showLongX2(String message) {
        showLong(message);
        showLong(message);
    }
    public static void showLongX2(int resId) {
        showLong(resId);
        showLong(resId);
    }
    public static void showLongX3(int resId) {
        showLong(resId);
        showLong(resId);
        showLong(resId);
    }
    public static void showLongX3(String message) {
        showLong(message);
        showLong(message);
        showLong(message);
    }
}
