package cn.lovepet.shops.mvp.base;

import cn.lovepet.shops.view.ui.activity.content.albumhomegoods.HomeIndex;

/**
 * @author dingcl
 */

public interface GoodsJDHomeContract {
    interface View {
        void setHomeIndexData(HomeIndex find);
        void setRecommendedWares(HomeIndex find);
        void setMoreRecommendedWares(HomeIndex find);
    }
    interface Presenter {
        void getHomeIndexData(int flag);
        void getRecommendedWares();
        void getMoreRecommendedWares();
    }

}