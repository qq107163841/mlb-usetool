package com.mmy.yiyi.mvp_okhttp_retrofit;

/*
 *
 * 创建自帅气的 清川 on 2020/6/16
 */
public interface IView2<T> {

    void onSuccess(T t);
    void onError(String mes);

}
