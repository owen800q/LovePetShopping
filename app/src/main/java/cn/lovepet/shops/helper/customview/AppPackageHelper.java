package cn.lovepet.shops.helper.customview;

/**
 * @author JSYL-DCL
 * @date 2018/11/22 16:24
 * @des
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class AppPackageHelper {
    public static Activity getActivityByView(Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            return (Activity) context;
        }
        Activity mContext = null;
        if (context.getClass().getName().contains("com.android.internal.policy.DecorContext")) {
        }
        for (; ; ) {
            try {
                Field localField = context.getClass().getDeclaredField("mPhoneWindow");
                localField.setAccessible(true);
                Object localObject = localField.get(context);
                Activity getContext = (Activity) context.getClass().getMethod("getContext", new Class[0]).invoke(context, new Object[0]);
                return getContext;
            } catch (NoSuchMethodException exception) {
                exception.printStackTrace();
//                paramContext = localObject;
                continue;
            } catch (IllegalAccessException paramContext) {
                paramContext.printStackTrace();
//                paramContext = localObject;
                continue;
            } catch (InvocationTargetException paramContext) {
                paramContext.printStackTrace();
//                paramContext = localObject;
                continue;
            } catch (NoSuchFieldException paramContext) {
                paramContext.printStackTrace();
//                paramContext = localObject;
                continue;
            }
//            return (Activity) context;
        }
    }

    public static Activity getActivityByView(View paramView) {
        return getActivityByView(paramView.getContext());
    }

    public static void getRecommendApp(Context paramContext, String paramString1, String paramString2) {
        getRecommendApp(paramContext, paramString1, paramString2, null);
    }

    public static void getRecommendApp(Context context, String param1, String paramString2, String paramString3) {
        if ((param1 == null) || (param1.length() <= 1)) {
            if (paramString2 != null) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(paramString2));
                context.startActivity(intent);
            }
        }
        String str = "";
        do {
//            return;
            str = "market://details?id=" + param1;
            if (paramString3 == null) {
                break;
            }
            try {
                if (!paramString3.equals("meizu")) {
                    break;
                }
                Intent intent3 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent3.setPackage("com.meizu.mstore");
                intent3.putExtra("source_apkname", param1);
                intent3.addFlags(268435456);
                context.startActivity(intent3);
                return;
            } catch (Exception ex) {
            }
        } while (paramString2 == null);
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setData(Uri.parse(paramString2));
        intent2.addFlags(268435456);
        context.startActivity(intent2);
//        return;
        Intent intent1 = new Intent("android.intent.action.VIEW");
        intent1.setData(Uri.parse(str));
        intent1.addFlags(268435456);
        context.startActivity(intent1);
    }

    public static boolean isAppInstalled(Context paramContext, String paramString) {
        if (paramString == null) {
            return false;
        }
        List<PackageInfo> installedPackages = paramContext.getPackageManager().getInstalledPackages(0);
        if (installedPackages != null) {
            int i = 0;
            while (i < installedPackages.size()) {
                if (((PackageInfo) installedPackages.get(i)).packageName.equalsIgnoreCase(paramString)) {
                    return true;
                }
                i += 1;
            }
        }
        return false;
    }

    public static void launchApp(Context context, String param2) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(param2);
        if (launchIntentForPackage != null) {
            context.startActivity(launchIntentForPackage);
        }
    }
}
