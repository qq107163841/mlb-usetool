package com.mmy.yiyi.mvp_kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mmy.yiyi.R
import com.mmy.yiyi.logtool.Logg
import com.mmy.yiyi.mvp_okhttp.PViewlmpl
import com.mmy.yiyi.mvp_okhttp_retrofit.Bean2
import java.util.*

class KotlinActivity : AppCompatActivity(),KIView {
    private val loginUrl9002 = "http://preapi.eupregna.cn:9002/api/pts/login/lemonpassword"
    override fun onSuccess(t: String) {
        Logg.i("mlb","okok")
    }


    override fun onError(msg: String) {
        Logg.i("mlb","not okok")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        val map = HashMap<String, String>()
        map["username"] = "ab"
        map["password"] = "ab"
        map["cellType"] = "android"
        //初始化类
        var kpViewlmpl = KPViewlmpl(this)

        kpViewlmpl.onRequest(loginUrl9002,map,Bean2::class.java)


    }



}
