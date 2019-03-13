package cn.lovepet.shops.mvp.presenter;


import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

import cn.lovepet.shops.base.Constants;
import cn.lovepet.shops.base.MApplication;
import cn.lovepet.shops.bean.GoodsNewsBean;
import cn.lovepet.shops.mvp.base.GoodsNewsContract;
import cn.lovepet.shops.util.FileUtils;

/**
 * Created by dingcl
 * 商品资讯数据处理层
 */

public class GoodsNewsPresenterImpl implements GoodsNewsContract.Presenter{
    private GoodsNewsContract.View mFindView;

    public GoodsNewsPresenterImpl(GoodsNewsContract.View view) {
        this.mFindView = view;

    }

    @Override
    public void getGoodsNewsData() {
        InputStream is = null;
        try {
            is = MApplication.getContext().getAssets().open(Constants.ASSET_GOODS_NEWS);
            String text = FileUtils.readTextFromFile(is);
            Gson gson = new Gson();
            GoodsNewsBean goodsNewsBean = gson.fromJson(text, GoodsNewsBean.class);
            mFindView.setGoodsNewsData(goodsNewsBean);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getMoreFindData() {
        InputStream is = null;
        try {
            is = MApplication.getContext().getAssets().open(Constants.ASSET_GOODS_NEWS);
            String text = FileUtils.readTextFromFile(is);
            Gson gson = new Gson();
            GoodsNewsBean goodsNewsBean = gson.fromJson(text, GoodsNewsBean.class);
            mFindView.setMoreData(goodsNewsBean);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
