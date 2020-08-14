package com.mmy.yiyi.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.mmy.yiyi.R;
import com.mmy.yiyi.mvp_okhttp.IView;
import com.mmy.yiyi.mvp_okhttp.PViewlmpl;
import com.mmy.yiyi.activitymanager.ActivityManager;
import com.mmy.yiyi.utils.MPermissionHelper;
import com.mmy.yiyi.toast.ToastUtils;



/**
 * 创建自帅气的 清川
 * baseactivity mlb
 */
public abstract class BaseActivity2 extends AppCompatActivity implements MPermissionHelper.PermissionCallBack, IView {
    public ActivityManager activityManager;
    public ToastUtils toastUtils ;
    public MPermissionHelper permissionHelper;
    //沉浸式格式设置
    private boolean isImmersion=false;
    public PViewlmpl pViewlmpl;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayout());
        bindData();
        initView();
        initData();
    }

    protected abstract void initView();
    //初始化baseActivity数据
    private void bindData(){
        activityManager = new ActivityManager();
        activityManager.pushOneActivity(this);
        toastUtils = ToastUtils.getToast();
        permissionHelper = new MPermissionHelper(this);
        pViewlmpl = new PViewlmpl(this);
        //
        //bind = ButterKnife.bind(this);
    }
    //初始化数据
    protected abstract void initData();

    /**
     * 沉浸式格式设置
     * @param isImmersion
     */
    protected void isImmersion(boolean isImmersion){
        if(isImmersion){
            Window window = getWindow();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(getResources().getColor(R.color.a));
            }
        }
    }

    //设置状态栏颜色
    protected void setStatusBarColor(Activity activity, int barColor){
        StatusBarUtils.setWindowStatusBarColor(activity,barColor);
    }
    //开关沉浸式
    protected void setImmersion(boolean immersion) {
        isImmersion = immersion;
    }

    protected abstract int bindLayout();

    /**
     * 页面跳转
     * @param clz
     */
    protected void startActivity(Class<?> clz) {
        startActivity(new Intent(BaseActivity2.this, clz));
    }
    /**
     * 页面跳转并关闭当前界面
     * @param clz
     */
    protected void startActivity(Class<?> clz, boolean isFinish) {
        startActivity(new Intent(BaseActivity2.this, clz));
        if (isFinish) {
            this.finish();
        }
    }
    /**
     * 携带数据的页面跳转
     * @param clz
     * @param bundle
     */
    protected void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        activityManager.removeOneActivity(this);
    }

}
