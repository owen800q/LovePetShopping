package cn.lovepet.shops.base.global;

import android.content.Context;

import cn.lovepet.shops.base.MApplication;
import cn.lovepet.shops.mvp.base.DataManager;

/**
 * @author：dingcl.
 * 全局上下文
 */

public class GlobalAppComponent {
    private Context context;
//    private volatile static AppComponent mAppComponent;

//    /**
//     * 初始化全局AppComponent
//     * @param context applicationContext
//     */
//    public static void init(Context context){
//        if(mAppComponent == null){
//            synchronized (GlobalAppComponent.class){
//                if(mAppComponent == null){
//                    mAppComponent = (AppComponent) context.getApplicationContext();
////                    mAppComponent = DaggerAppComponent.builder()
////                            .applicationModule(new ApplicationModule(context.getApplicationContext()))
////                            .build();
//                }
//            }
//        }
//    }

//    public static AppComponent getAppComponent() {
//        if(mAppComponent == null){
//            throw (new NullPointerException("GlobalAppComponent必须在application中进行init初始化"));
//        }
//        return mAppComponent;
//    }
}
