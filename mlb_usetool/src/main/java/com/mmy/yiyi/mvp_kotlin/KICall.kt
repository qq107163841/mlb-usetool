package com.mmy.yiyi.mvp_kotlin

import okhttp3.Response

/*
 * 
 * 创建自帅气的 清川 on 2020/6/18
 */
interface KICall {
    abstract fun onCallSuccess(`object`: Response)
    abstract fun onCallError(msg: String)
}