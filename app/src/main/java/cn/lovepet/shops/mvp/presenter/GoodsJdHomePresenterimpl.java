package cn.lovepet.shops.mvp.presenter;


import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

import cn.lovepet.shops.base.Constants;
import cn.lovepet.shops.base.MApplication;
import cn.lovepet.shops.bean.GoodsNewsBean;
import cn.lovepet.shops.mvp.base.GoodsJDHomeContract;
import cn.lovepet.shops.mvp.base.GoodsNewsContract;
import cn.lovepet.shops.util.FileUtils;
import cn.lovepet.shops.view.ui.activity.content.albumhomegoods.HomeIndex;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dingcl
 * 商品jd首页业务处理
 */

public class GoodsJdHomePresenterimpl<S> implements GoodsJDHomeContract.Presenter{
    private GoodsJDHomeContract.View mJDHomeView;
    private Context context;
    public GoodsJdHomePresenterimpl(Context context,GoodsJDHomeContract.View view) {
        this.mJDHomeView = view;
        this.context = context;

    }
//    @Override
//    public void getHomeIndexData(int flag) {
//        InputStream is = null;
//        try {
//            is = MApplication.getContext().getAssets().open(Constants.ASSET_GOODS_NEWS);
//            String text = FileUtils.readTextFromFile(is);
//            Gson gson = new Gson();
//            GoodsNewsBean goodsNewsBean = gson.fromJson(text, GoodsNewsBean.class);
//            mFindView.setHomeIndexData(goodsNewsBean);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void getHomeIndexData(int flag) {
        HomeIndex multiIndexData = (HomeIndex) getMultiIndexData((Class<S>) HomeIndex.class, flag == 1 ? Constants.ASSET_GOODS_JD_HOME : Constants.ASSET_GOODS_JD_HOME_EVENT);
        mJDHomeView.setHomeIndexData(multiIndexData);
    }


    @Override
    public void getRecommendedWares() {
        HomeIndex multiIndexData = (HomeIndex)getMultiIndexData((Class<S>) HomeIndex.class, Constants.ASSET_GOODS_JD_RECOMMEND);
        mJDHomeView.setRecommendedWares(multiIndexData);
    }

    @Override
    public void getMoreRecommendedWares() {
        HomeIndex multiIndexData = (HomeIndex)getMultiIndexData((Class<S>) HomeIndex.class, Constants.ASSET_GOODS_JD_RECOMMENDED);
        mJDHomeView.setMoreRecommendedWares(multiIndexData);
    }


    public S getMultiIndexData(final Class<S> clazz , final String fillName) {
        InputStream is = null;
        S s = null;
        try {
            is = context.getAssets().open(fillName);
            String text = FileUtils.readTextFromFile(is);
            Gson gson = new Gson();
            s = gson.fromJson(text, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return s;

    }
}
