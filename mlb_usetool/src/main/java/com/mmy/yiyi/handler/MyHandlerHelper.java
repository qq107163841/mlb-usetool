package com.mmy.yiyi.handler;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.mmy.yiyi.base.BaseApplication;
import com.mmy.yiyi.logtool.Logg;

import java.lang.ref.WeakReference;

/*
 * {Nothing is Importance}
 */
public abstract  class MyHandlerHelper<T extends Context> extends Handler{
    private static final String TAG = "MyHandlerHelper";
    //弱引用
    protected WeakReference<T> weakReference;
    public MyHandlerHelper(T t){
        super();
        this.weakReference = new WeakReference<T>(t);
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        int number = msg.what;
        //判空
        if(weakReference == null||weakReference.get()==null){
            Logg.i(TAG,"handler is null");
            return;
        }
        //0代表 网络请求 code！=200 只需要提示错误title
        if(number==0){
            handleErr((String) msg.obj,number);
        }else{
            handleSuc(msg,number);//反之就处理obj
        }
    }
    //接口回调
    public abstract void handleSuc(Message msg, int what);
    public abstract void handleErr(String msg, int what);

}
