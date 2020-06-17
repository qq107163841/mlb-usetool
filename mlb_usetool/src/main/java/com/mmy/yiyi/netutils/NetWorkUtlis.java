package com.mmy.yiyi.netutils;

import android.content.Context;
import android.support.annotation.Nullable;

import com.mmy.yiyi.base.BaseApplication;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import okhttp3.Authenticator;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;

public class NetWorkUtlis {

    private static volatile NetWorkUtlis netWorkUtlis;
    public final static int READ_TIMEOUT = 100;
    public final static int CONNECT_TIMEOUT = 60;
    public final static int WRITE_TIMEOUT = 60;
    private OkHttpClient mOkHttpClient;

    private NetWorkUtlis(){
        //mOkHttpClient =
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        /*builder.authenticator(new Authenticator() {
                    @Nullable
                    @Override
                    public Request authenticate(Route route, okhttp3.Response response) throws IOException {
                        Request.Builder builder = response.request().newBuilder();
                        Request.Builder authenticator = builder.addHeader(header1, header2);
                        return authenticator
                                .build();
                    }});*/
        builder.connectTimeout(60000, TimeUnit.MILLISECONDS);
        builder.readTimeout(60000, TimeUnit.MILLISECONDS);
        builder.followSslRedirects(false);
        builder.followRedirects(false);
        mOkHttpClient =builder.build();
    }

    public static NetWorkUtlis getNetWorkUtlis() {
        if(netWorkUtlis==null){
            synchronized (NetWorkUtlis.class){
                if(netWorkUtlis==null){
                    netWorkUtlis=new NetWorkUtlis();
                }
            }
        }
        return netWorkUtlis;
    }



    public  interface MyNetCall{
        void success(Call call, Response response) throws IOException;
        void failed(Call call, IOException e);
    }

    /**
     * 普通post请求
     * @param url
     * @param paramsMap
     * @param myNetCall
     */
    public  void PostBaseHttpRequest(String url, Map<String, String > paramsMap, final MyNetCall myNetCall) {

        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        Set<String> keySet = paramsMap.keySet();
        for(String key:keySet) {
            String value = paramsMap.get(key);
            formBodyBuilder.add(key,value);
        }
        FormBody formBody = formBodyBuilder.build();
        Request request = new Request
                .Builder()
                .post(formBody)
                .url(url)
                .build();
        //2 将Request封装为Call
        Call call = mOkHttpClient.newCall(request);
        //3 执行Call
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                myNetCall.failed(call,e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                myNetCall.success(call,response);
            }
        });

    }

    /**
     * post上传图片
     * @param url
     * @param paramsMap
     * @param files
     * @param myNetCall
     */
    public  void PostBaseHttpRequestImage(String url, Map<String, String > paramsMap, final File files, final MyNetCall myNetCall) {
        MultipartBody.Builder multipartBodyBuilder = new MultipartBody.Builder();
        multipartBodyBuilder.setType(MultipartBody.FORM);
        //遍历map中所有参数到builder
        if (paramsMap != null){
            for (String key : paramsMap.keySet()) {
                multipartBodyBuilder.addFormDataPart(key, paramsMap.get(key));
            }
        }
        //遍历paths中所有图片绝对路径到builder，并约定key如“upload”作为后台接受多张图片的key
        if (files != null){
            multipartBodyBuilder.addFormDataPart("file", files.getName(), RequestBody.create(MediaType.parse("image/png"), files));
        }
        //构建请求体
        RequestBody requestBody = multipartBodyBuilder.build();

        Request.Builder RequestBuilder = new Request.Builder();
        RequestBuilder.url(url);// 添加URL地址
        RequestBuilder.post(requestBody);

        Request request = RequestBuilder.build();
        //2 将Request封装为Call
        Call call = mOkHttpClient.newCall(request);
        //3 执行Call
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                myNetCall.failed(call,e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                myNetCall.success(call,response);
            }
        });

    }
}
