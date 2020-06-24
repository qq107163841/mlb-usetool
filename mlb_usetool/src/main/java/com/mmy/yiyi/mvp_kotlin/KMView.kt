package com.mmy.yiyi.mvp_kotlin

import com.mmy.yiyi.mvp_okhttp.ICall
import java.util.HashMap

/*
 * 
 * 创建自帅气的 清川 on 2020/6/18
 */
interface KMView {
    abstract fun onRequest(url: String, map: HashMap<String, String>, cla: Class<*>, iCall: KICall)
}