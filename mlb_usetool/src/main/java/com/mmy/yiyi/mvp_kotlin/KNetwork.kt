package com.mmy.yiyi.mvp_kotlin

import com.mmy.yiyi.mvp_okhttp.NetWorkUtlis
import okhttp3.*
import java.io.FileNotFoundException
import java.io.IOException
import java.util.concurrent.TimeUnit
import kotlin.reflect.KProperty

/*
 * 
 * 创建自帅气的 清川 on 2020/6/18
 */
class KNetwork {

    //var kNetwork : KNetwork?=null

    private var mOkHttpClient: OkHttpClient?=null
    //构造
    constructor(){
        val builder = OkHttpClient.Builder()
        builder.connectTimeout(60000, TimeUnit.MILLISECONDS)
        builder.readTimeout(60000, TimeUnit.MILLISECONDS)
        builder.followSslRedirects(false)
        builder.followRedirects(false)
        mOkHttpClient = builder.build()
    }

    companion object {
        val kNetwork: KNetwork by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            KNetwork()
        }
    }



    init {

    }


    fun PostBaseHttpRequest(url: String, paramsMap: Map<String, String>, kMyNetCall: KMyNetCall) {
        val formBodyBuilder = FormBody.Builder()
        val keySet = paramsMap.keys
        for (key in keySet) {
            val value = paramsMap[key]
            formBodyBuilder.add(key, value)
        }
        val formBody = formBodyBuilder.build()
        val request = Request.Builder()
                .post(formBody)
                .url(url)
                .build()
        //2 将Request封装为Call
        val call = mOkHttpClient?.newCall(request)
        //3 执行Call
        call?.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                kMyNetCall.failed( e)
            }

            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                kMyNetCall.success( response)
            }
        })

    }

    interface KMyNetCall {
        @Throws(IOException::class)
        fun success( response: Response)

        fun failed( e: IOException)
    }
    /*fun getKNet(): KNetwork? {
        if (kNetwork == null) {
            synchronized(NetWorkUtlis::class.java) {
                if (kNetwork == null) {
                    kNetwork = KNetwork()
                }
            }
        }
        return kNetwork
    }*/

    /*//kotlin实现
    class SingletonDemo private constructor() {
        companion object {
            val instance: SingletonDemo by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
                SingletonDemo()
            }
        }
    }*/

}
