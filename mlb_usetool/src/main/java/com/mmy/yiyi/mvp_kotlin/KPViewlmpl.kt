package com.mmy.yiyi.mvp_kotlin

import android.util.Log
import com.mmy.yiyi.mvp_okhttp.ICall
import okhttp3.Response
import java.util.HashMap

/*
 * 
 * 创建自帅气的 清川 on 2020/6/18
 */
class KPViewlmpl(kpViews : KIView) : KPView {
    //声明变量 可为空
    private var kpView : KIView? = null
    private var kmViewlmpl : KMViewlmpl? =null
    //初始化
    init {
        this.kpView=kpViews
        kmViewlmpl = KMViewlmpl()
    }

    override fun onRequest(url: String, map: HashMap<String, String>, cla: Class<*>) {
        kmViewlmpl?.onRequest(url,map,cla,object : KICall{
            override fun onCallError(msg: String) {
                kpView?.onError(msg)
            }

            override fun onCallSuccess(`object`: Response) {
                kpView?.onSuccess(`object`.body().toString())
            }

        })
    }

}