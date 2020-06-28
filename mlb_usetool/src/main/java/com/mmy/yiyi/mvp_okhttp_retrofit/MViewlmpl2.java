package com.mmy.yiyi.mvp_okhttp_retrofit;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Response;

/*
 *
 * 创建自帅气的 清川
 */
public class MViewlmpl2 implements MView2 {
    private NetWorkUtlis2 netWorkUtlis2;
    public MViewlmpl2() {
        netWorkUtlis2 = NetWorkUtlis2.getNetWorkUtlis();
    }

    @Override
    public void onRequest(String url, HashMap<String, String> map, Class cla, final ICall2 iCall) {
        netWorkUtlis2.PostBaseHttpRequest(url, map, new NetWorkUtlis2.OkCall() {
            @Override
            public void success(Response response) throws IOException {
                iCall.onCallSuccess(response);
            }

            @Override
            public void failed(IOException e) {
                iCall.onCallError(e.getMessage());
            }
        });
    }

    @Override
    public void onRequest2(Map<String, String> map, final ICall2 iCall) {
        netWorkUtlis2.PostBaseHttpRequest2(map, new NetWorkUtlis2.RetrofitCall() {
            @Override
            public void success(retrofit2.Response response) {
                iCall.onCallSuccess(response);
            }

            @Override
            public void failed(Throwable t) {
                iCall.onCallError(t.getMessage());
            }
        });
    }

    @Override
    public void onRequest3(Map<String, String> map, final ICall2 iCall) {
        netWorkUtlis2.PostBaseHttpRequest3(map, new NetWorkUtlis2.OkCall() {
            @Override
            public void success(Response response) throws IOException {
                iCall.onCallSuccess(response);
            }

            @Override
            public void failed(IOException e) {
                iCall.onCallError(e.getMessage());
            }
        });
    }

    @Override
    public void onRequest4(Map<String, String> map,final ICall2 iCall) {
        netWorkUtlis2.PostBaseHttpRequest4(map, new NetWorkUtlis2.RetrofitCall() {
            @Override
            public void success(retrofit2.Response response) {
                iCall.onCallSuccess(response);
            }

            @Override
            public void failed(Throwable t) {
                iCall.onCallError(t.getMessage());
            }
        });
    }

}
