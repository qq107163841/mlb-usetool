package com.mmy.yiyi.mvp_okhttp_retrofit;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

/*
 *
 * 创建自帅气的 清川 on 2020/6/16
 */
public interface RetrofitAPI {

    @FormUrlEncoded
    @POST("login/lemonpassword")
    Observable<Response> Login(@QueryMap Map<String, String> map);

    @FormUrlEncoded
    @POST("login/lemonpassword")
    Call Login2(@QueryMap Map<String, String> map);

    @FormUrlEncoded
    @POST("login/lemonpassword")
    okhttp3.Call Login3(@QueryMap Map<String, String> map);



}
