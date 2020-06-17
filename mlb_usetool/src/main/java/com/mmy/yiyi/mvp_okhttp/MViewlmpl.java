package com.mmy.yiyi.mvp_okhttp;

import com.mmy.yiyi.netutils.NetWorkUtlis;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Response;

/*
 *
 * 创建自帅气的 清川 on 2020/6/16
 */
public class MViewlmpl implements MView {
    private NetWorkUtlis netWorkUtlis;
    public MViewlmpl() {
        netWorkUtlis = NetWorkUtlis.getNetWorkUtlis();
    }
    @Override
    public void onRequest(String url,HashMap<String, String> map, Class cla,final ICall iCall) {
        netWorkUtlis.PostBaseHttpRequest(url, map, new NetWorkUtlis.MyNetCall() {
            @Override
            public void success(Call call, Response response) throws IOException {
                iCall.onCallSuccess(response);
            }

            @Override
            public void failed(Call call, IOException e) {

            }
        });
    }

}
