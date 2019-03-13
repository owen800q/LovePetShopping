package cn.lovepet.shops.view.ui.activity.content.albumhomegoods.banner;

import android.support.v4.view.ViewPager;
import android.view.View;

import cn.lovepet.shops.view.ui.activity.content.albumhomegoods.banner.transformer.AccordionPageTransformer;
import cn.lovepet.shops.view.ui.activity.content.albumhomegoods.banner.transformer.AlphaPageTransformer;
import cn.lovepet.shops.view.ui.activity.content.albumhomegoods.banner.transformer.CubePageTransformer;
import cn.lovepet.shops.view.ui.activity.content.albumhomegoods.banner.transformer.DefaultPageTransformer;
import cn.lovepet.shops.view.ui.activity.content.albumhomegoods.banner.transformer.DepthPageTransformer;
import cn.lovepet.shops.view.ui.activity.content.albumhomegoods.banner.transformer.FadePageTransformer;
import cn.lovepet.shops.view.ui.activity.content.albumhomegoods.banner.transformer.FlipPageTransformer;
import cn.lovepet.shops.view.ui.activity.content.albumhomegoods.banner.transformer.RotatePageTransformer;
import cn.lovepet.shops.view.ui.activity.content.albumhomegoods.banner.transformer.StackPageTransformer;
import cn.lovepet.shops.view.ui.activity.content.albumhomegoods.banner.transformer.ZoomCenterPageTransformer;
import cn.lovepet.shops.view.ui.activity.content.albumhomegoods.banner.transformer.ZoomFadePageTransformer;
import cn.lovepet.shops.view.ui.activity.content.albumhomegoods.banner.transformer.ZoomPageTransformer;
import cn.lovepet.shops.view.ui.activity.content.albumhomegoods.banner.transformer.ZoomStackPageTransformer;


/**
 * BGAPageTransformer
 */
public abstract class BGAPageTransformer implements ViewPager.PageTransformer {

    public void transformPage(View view, float position) {
        if (position < -1.0f) {
            // [-Infinity,-1)
            // This page is way off-screen to the left.
            handleInvisiblePage(view, position);
        } else if (position <= 0.0f) {
            // [-1,0]
            // Use the default slide transition when moving to the left page
            handleLeftPage(view, position);
        } else if (position <= 1.0f) {
            // (0,1]
            handleRightPage(view, position);
        } else {
            // (1,+Infinity]
            // This page is way off-screen to the right.
            handleInvisiblePage(view, position);
        }
    }

    public abstract void handleInvisiblePage(View view, float position);

    public abstract void handleLeftPage(View view, float position);

    public abstract void handleRightPage(View view, float position);

//    public static BGAPageTransformer getPageTransformer(TransitionEffect effect) {
    public static BGAPageTransformer getPageTransformer(TransitionEffect effect) {
        switch (effect) {
            case Default:
                return new DefaultPageTransformer();
            case Alpha:
                return new AlphaPageTransformer();
            case Rotate:
                return new RotatePageTransformer();
            case Cube:
                return new CubePageTransformer();
            case Flip:
                return new FlipPageTransformer();
            case Accordion:
                return new AccordionPageTransformer();
            case ZoomFade:
                return new ZoomFadePageTransformer();
            case Fade:
                return new FadePageTransformer();
            case ZoomCenter:
                return new ZoomCenterPageTransformer();
            case ZoomStack:
                return new ZoomStackPageTransformer();
            case Stack:
                return new StackPageTransformer();
            case Depth:
                return new DepthPageTransformer();
            case Zoom:
                return new ZoomPageTransformer();
            default:
                return new DefaultPageTransformer();
        }
    }
}