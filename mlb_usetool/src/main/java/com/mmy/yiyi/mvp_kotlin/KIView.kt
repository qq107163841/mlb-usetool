package com.mmy.yiyi.mvp_kotlin

import java.util.*

/*
 * 
 * 创建自帅气的 清川 on 2020/6/18
 */
interface KIView {
    abstract fun onSuccess(t: String)
    abstract fun onError(msg: String)
}