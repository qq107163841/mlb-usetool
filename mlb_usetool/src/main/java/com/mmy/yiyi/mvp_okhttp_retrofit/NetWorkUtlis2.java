package com.mmy.yiyi.mvp_okhttp_retrofit;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetWorkUtlis2 {

    private static volatile NetWorkUtlis2 netWorkUtlis;
    private OkHttpClient mOkHttpClient;
    private final Retrofit retrofit;
    private final RetrofitAPI retrofitAPI;

    private NetWorkUtlis2(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(60000, TimeUnit.MILLISECONDS);
        builder.readTimeout(60000, TimeUnit.MILLISECONDS);
        builder.followSslRedirects(false);
        builder.addInterceptor(logging);
        builder.followRedirects(false);
        mOkHttpClient =builder.build();
        //创建Retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl("http://preapi.eupregna.cn:9002/api/pts/")
                .addConverterFactory(GsonConverterFactory.create()) // 设置数据解析器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())// 支持RxJava平台
                .client(mOkHttpClient)//载入Okhttp
                .build();
        retrofitAPI = retrofit.create(RetrofitAPI.class);

    }


    public static NetWorkUtlis2 getNetWorkUtlis() {
        if(netWorkUtlis==null){
            synchronized (NetWorkUtlis2.class){
                if(netWorkUtlis==null){
                    netWorkUtlis=new NetWorkUtlis2();
                }
            }
        }
        return netWorkUtlis;
    }

    public  interface OkCall{
        void success(Response response) throws IOException;
        void failed(IOException e);

    }
    public  interface RetrofitCall{
        void success(retrofit2.Response response);
        void failed(Throwable t);
    }

    public  void PostBaseHttpRequest4(Map<String,String> map, final RetrofitCall retrofitCall){
        retrofitAPI.Login(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DefaultObserver(retrofitCall));
    }

    private class DefaultObserver implements Observer<retrofit2.Response> {
        RetrofitCall retrofitCall;
        public DefaultObserver(RetrofitCall retrofitCalls) {
            this.retrofitCall=retrofitCalls;
        }

        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(retrofit2.Response o) {
            retrofitCall.success(o);
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    }

    public  void PostBaseHttpRequest2(Map<String,String> map, final RetrofitCall retrofitCall){

        //Observable<Bean2> login = retrofitAPI.Login(map);

        retrofit2.Call call = retrofitAPI.Login2(map);
        call.enqueue(new retrofit2.Callback() {
            @Override
            public void onResponse(retrofit2.Call call, retrofit2.Response response) {
                retrofitCall.success(response);
            }

            @Override
            public void onFailure(retrofit2.Call call, Throwable t) {
                retrofitCall.failed(t);
            }
        });


    }

    public  void PostBaseHttpRequest3(Map<String,String> map, final OkCall okCall){
        Call call = retrofitAPI.Login3(map);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                okCall.failed(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                okCall.success(response);
            }
        });


    }

    /**
     * 普通post请求
     * @param url
     * @param paramsMap
     * @param okCall
     */
    public  void PostBaseHttpRequest(String url, Map<String, String > paramsMap, final OkCall okCall) {

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
                okCall.failed(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                okCall.success(response);
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
    public  void PostBaseHttpRequestImage(String url, Map<String, String > paramsMap, final File files, final OkCall myNetCall) {
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
                myNetCall.failed(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                myNetCall.success(response);
            }
        });

    }
}
