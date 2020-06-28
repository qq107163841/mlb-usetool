package com.mmy.yiyi.mvp_okhttp_retrofit;

import android.content.Intent;
import android.os.Bundle;

import com.mmy.yiyi.base.BaseActivity;
import com.mmy.yiyi.logtool.Logg;

import java.util.HashMap;

/**
 * 创建自帅气的 清川
 */
public class MainActivity2 extends BaseActivity implements IView2{
    private String loginUrl9002="http://preapi.eupregna.cn:9002/api/pts/login/lemonpassword";
    private PViewlmpl2 pViewlmpl2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        HashMap<String,String> map = new HashMap<>();
        map.put("username","ab");
        map.put("password","ab");
        map.put("cellType","android");
        pViewlmpl2 = new PViewlmpl2(this);
        //pViewlmpl2.onRequest2(map,Bean2.class);
        pViewlmpl2.onRequest4(map,Bean2.class);
        myAlertDialog.showLoadingDialog("请求中");

    }

    @Override
    protected int bindLayout() {
        return com.mmy.yiyi.R.layout.activity_main;
    }

    @Override
    public void onSuccess(Object o) {

        if(o instanceof Bean2){
            Logg.i("Main","okok");
            onDissmiss();
        }

    }

    @Override
    public void onError(String mes) {



    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        pViewlmpl2.onPDetach();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

}
