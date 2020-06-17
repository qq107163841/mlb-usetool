package com.mmy.yiyi.mvp_okhttp;

import java.util.HashMap;

/*
 *
 * 创建自帅气的 清川 on 2020/6/16
 */
public interface MView {
    void onRequest(String url,HashMap<String,String> map, Class cla, ICall iCall);
}
