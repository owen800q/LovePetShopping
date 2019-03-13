package cn.lovepet.shops.mvp.base;

import android.content.Context;
import java.util.Map;

import cn.lovepet.shops.helper.http.HttpHelper;
import cn.lovepet.shops.mvp.dao.DataBaseHelper;
import cn.lovepet.shops.util.SharePreferenceHelper;

/**
 * Created by admin on 2017/3/9.
 */
public class DataManager {
    private HttpHelper httpHelper;
    private SharePreferenceHelper sharePreferenceHelper;
    private DataBaseHelper dataBaseHelper;
    private Context context;


    public DataManager(Context context , HttpHelper httpHelper , SharePreferenceHelper sharePreferenceHelper
        , DataBaseHelper dataBaseHelper) {
        this.context = context;
        this.httpHelper = httpHelper;
        this.sharePreferenceHelper = sharePreferenceHelper;
        this.dataBaseHelper = dataBaseHelper;
    }



    public <S> S getService(Class<S> serviceClass){
        return httpHelper.getService(serviceClass);
    }


    public void saveSPData(String key , String value){
        sharePreferenceHelper.saveData(key , value);
    }

    public void saveSPMapData(Map<String,String> map){
        sharePreferenceHelper.saveData(map);
    }

    public String getSPData(String key){
        return sharePreferenceHelper.getValue(key);
    }

    public void deleteSPData(){
        sharePreferenceHelper.deletePreference();
    }

    public Map<String ,String> getSPMapData(){
        return sharePreferenceHelper.readData();
    }


    public Context getContext() {
        return context;
    }
}
