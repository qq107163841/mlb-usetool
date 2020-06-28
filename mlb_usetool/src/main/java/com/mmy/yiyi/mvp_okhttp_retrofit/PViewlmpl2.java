package com.mmy.yiyi.mvp_okhttp_retrofit;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/*
 *
 * 创建自帅气的 清川
 */
public class PViewlmpl2 implements PView2 {

    private IView2 IView;
    private MViewlmpl2 mViewlmpl;
    public PViewlmpl2(IView2 views) {
        this.IView =views;
        mViewlmpl = new MViewlmpl2();
    }

    @Override
    public void onRequest(String url, HashMap<String, String> map, final Class cla) {
        mViewlmpl.onRequest(url, map, cla, new ICall2() {
            @Override
            public void onCallSuccess(Object object) {
                Object o = new Gson().fromJson(object.toString(), cla);
                IView.onSuccess(o);
            }

            @Override
            public void onCallError(String msg) {
                IView.onError(msg);
            }
        });
    }

    @Override
    public void onRequest2(Map<String, String> map, final Class cla) {
       mViewlmpl.onRequest2(map, new ICall2() {
           @Override
           public void onCallSuccess(Object object) {
               Object o = new Gson().fromJson(object.toString(), cla);
               IView.onSuccess(o);
           }

           @Override
           public void onCallError(String msg) {
               IView.onError(msg);
           }
       });
    }

    @Override
    public void onRequest3(Map<String, String> map, final Class cla) {
        mViewlmpl.onRequest3(map, new ICall2() {
            @Override
            public void onCallSuccess(Object object) {
                Object o = new Gson().fromJson(object.toString(), cla);
                IView.onSuccess(o);
            }

            @Override
            public void onCallError(String msg) {
                IView.onError(msg);
            }
        });
    }

    @Override
    public void onRequest4(Map<String, String> map,final Class cla) {
        mViewlmpl.onRequest4(map, new ICall2() {
            @Override
            public void onCallSuccess(Object object) {
                Object o = new Gson().fromJson(object.toString(), cla);
                IView.onSuccess(o);
            }

            @Override
            public void onCallError(String msg) {
                IView.onError(msg);
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
