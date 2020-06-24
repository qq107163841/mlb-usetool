package com.mmy.yiyi.mvp_okhttp;

import android.content.Intent;
import android.os.Bundle;

import com.mmy.yiyi.R;
import com.mmy.yiyi.base.BaseActivity;
import com.mmy.yiyi.logtool.Logg;

import java.util.HashMap;

public class MainActivity extends BaseActivity {
    private String loginUrl9002="http://preapi.eupregna.cn:9002/api/pts/login/lemonpassword";

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
        pViewlmpl.onRequest(loginUrl9002,map,Bean.class);
        myAlertDialog.showLoadingDialog("请求中");



    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(Object o) {

        if(o instanceof Bean){
            Logg.i("Main","okok");
        }

    }

    @Override
    public void onError(String mes) {



    }

    @Override
    public void onDissmiss() {
        myAlertDialog.dissmiss();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        pViewlmpl.onPDetach();
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
