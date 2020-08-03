package com.mmy.yiyi.utils;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/*
 * 手机顶部通知栏的颜色
 */
public class StatusBarUtils {
    /**
     *
     * @param activity
     * @param colorResId
     * @param isblack
     */
    public static void setWindowStatusBarColor(Activity activity, int colorResId,boolean isblack) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = activity.getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                //导航栏的背景颜色
                window.setStatusBarColor(activity.getResources().getColor(colorResId));
                //
                //window.setNavigationBarColor(activity.getResources().getColor(colorResId));
                if(isblack){
                    //黑色字体 导航栏字体颜色
                    window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                }else{
                    //白色字体
                    window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setWindowStatusBarColor(Dialog dialog, int colorResId) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = dialog.getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(dialog.getContext().getResources().getColor(colorResId));

                //底部导航栏
                //window.setNavigationBarColor(activity.getResources().getColor(colorResId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setWindowStatusBarColor(Activity activity,boolean isblack) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = activity.getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                //导航栏的背景颜色
                //window.setStatusBarColor(activity.getResources().getColor(colorResId));
                //
                //window.setNavigationBarColor(activity.getResources().getColor(colorResId));
                if(isblack){
                    //黑色字体 导航栏字体颜色
                    window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                }else{
                    //白色字体
                    window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
