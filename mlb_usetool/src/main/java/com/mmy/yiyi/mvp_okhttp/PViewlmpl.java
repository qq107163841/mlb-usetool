package com.mmy.yiyi.mvp_okhttp;

import com.google.gson.Gson;

import java.util.HashMap;

import okhttp3.Response;

/*
 *
 * 创建自帅气的 清川 on 2020/6/16
 */
public class PViewlmpl implements PView {

    private IView IView;
    private MViewlmpl mViewlmpl;
    public PViewlmpl(IView views) {
        this.IView =views;
        mViewlmpl = new MViewlmpl();
    }

    @Override
    public void onRequest(String url, HashMap<String, String> map, final Class cla) {
        mViewlmpl.onRequest(url, map, cla, new ICall() {
            @Override
            public void onCallSuccess(Response object) {

                Object o = new Gson().fromJson(object.toString(), cla);
                IView.onSuccess(o);

                IView.onDissmiss();

            }

            @Override
            public void onCallError(String msg) {
                IView.onError(msg);
                IView.onDissmiss();
            }
        });
    }

    public void onPDetach(){
        if(IView !=null){
            IView =null;
        }
        if(mViewlmpl!=null){
            mViewlmpl=null;
        }
    }

}
