package cn.lovepet.shops.view.ui.activity.content.albumhomegoods.banner.transformer;

import android.support.v4.view.ViewCompat;
import android.view.View;

import cn.lovepet.shops.view.ui.activity.content.albumhomegoods.banner.BGAPageTransformer;


/**
 * 创建时间:15/6/19 上午8:41
 * 描述:
 */
public class FadePageTransformer extends BGAPageTransformer {

    @Override
    public void handleInvisiblePage(View view, float position) {
    }

    @Override
    public void handleLeftPage(View view, float position) {
        ViewCompat.setTranslationX(view, -view.getWidth() * position);
        ViewCompat.setAlpha(view, 1 + position);
    }

    @Override
    public void handleRightPage(View view, float position) {
        ViewCompat.setTranslationX(view, -view.getWidth() * position);
        ViewCompat.setAlpha(view, 1 - position);
    }

}