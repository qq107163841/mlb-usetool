package com.mmy.yiyi.mvp_kotlin

import java.util.*

/*
 * 
 * 创建自帅气的 清川 on 2020/6/18
 */
interface KPView {
    abstract fun onRequest(url: String, map: HashMap<String, String>, cla: Class<*>)

}