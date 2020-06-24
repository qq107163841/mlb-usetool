package com.mmy.yiyi.netutils;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.mmy.yiyi.base.BaseApplication;
import com.mmy.yiyi.sharedpreferences.MySharedPreferences;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author yangming on 2018/7/19
 * OKHttpClient请求头
 */
public class HeaderInterceptor  implements Interceptor {
    MySharedPreferences mySharedPreferences = new MySharedPreferences(BaseApplication.getContent(),("user_data"));
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {

        final Request.Builder builder = chain.request().newBuilder();
        // TODO
        if(!TextUtils.isEmpty((String) mySharedPreferences.getValue("token",""))){
            builder.addHeader("Authorization", "Bearer " + mySharedPreferences.getValue("token",""));
        }
        return chain.proceed(builder.build());
    }
}
