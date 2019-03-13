package cn.lovepet.shops.bean;

import android.graphics.drawable.Drawable;

/**
 * @author JSYL-DCL
 * @date 2018/11/6 17:33
 * @des
 */
public class AppBean {
    private CharSequence name;
    private String packageName;
    private Drawable icon;

    //这类代码可别逞英雄手动写哦，IDE（Android Studio和Eclipse都有的）里可以直接生成
    public CharSequence getName() {
        return name;
    }

    public void setName(CharSequence name) {
        this.name = name;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }
}