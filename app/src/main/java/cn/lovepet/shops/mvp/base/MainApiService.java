package cn.lovepet.shops.mvp.base;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @author：dingcl on 2018/4/20 18:26.
 */

public interface MainApiService extends BaseApiService{

    @FormUrlEncoded
    @POST("userRegister/login")
    Observable<ResponseBody> login(@Field("mobile") String mobile, @Field("code") String code);
}
