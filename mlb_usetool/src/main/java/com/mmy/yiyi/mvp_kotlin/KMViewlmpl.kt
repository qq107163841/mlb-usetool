package com.mmy.yiyi.mvp_kotlin

import com.mmy.yiyi.mvp_okhttp.ICall
import okhttp3.Response
import java.io.IOException
import java.util.HashMap

/*
 * 
 * 创建自帅气的 清川 on 2020/6/18
 */
class KMViewlmpl :KMView {

    private var KNetwork:KNetwork?=null

    constructor(){
        KNetwork = KNetwork()
    }

    override fun onRequest(url: String, map: HashMap<String, String>, cla: Class<*>, iCall: KICall) {
        KNetwork?.PostBaseHttpRequest(url,map,object : KNetwork.KMyNetCall{
            override fun success(response: Response) {
                iCall.onCallSuccess(response)
            }

            override fun failed(e: IOException) {
                iCall.onCallError(e.message!!)
            }
        })
    }

}