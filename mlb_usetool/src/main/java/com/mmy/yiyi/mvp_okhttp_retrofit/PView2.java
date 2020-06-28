package com.mmy.yiyi.mvp_okhttp_retrofit;

import java.util.HashMap;
import java.util.Map;

/*
 *
 * 创建自帅气的 清川
 */
public interface PView2 {

    void onRequest(String url, HashMap<String, String> map, Class cla);
    void onRequest2(Map<String, String> map, Class cla);
    void onRequest3(Map<String, String> map, final Class cla);
    void onRequest4(Map<String, String> map, final Class cla);

}
