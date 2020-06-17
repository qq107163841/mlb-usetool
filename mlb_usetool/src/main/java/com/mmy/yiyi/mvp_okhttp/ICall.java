package com.mmy.yiyi.mvp_okhttp;

import okhttp3.Response;

/*
 *
 * 创建自帅气的 清川 on 2020/6/16
 */
public interface ICall {
    void onCallSuccess(Response object);
    void onCallError(String msg);
}
