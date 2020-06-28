package com.mmy.yiyi.toast;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.view.Gravity;
import android.widget.Toast;

import com.mmy.yiyi.base.BaseApplication;
import com.mmy.yiyi.netutils.NetWorkUtlis;

/**
 * 创建自帅气的 清川
 * toast
 */
public class ToastUtils {
    private static Toast toast = null;
    private static volatile ToastUtils toastUtils;
    @SuppressLint("ShowToast")
    public static void show(Context context, String text) {
        try {
            if (toast != null) {
                toast.setText(text);
            } else {
                toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
            }
            toast.show();
        } catch (Exception e) {
            e.printStackTrace();
            //解决在子线程中调用Toast的异常情况处理
            Looper.prepare();
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
            Looper.loop();
        }
    }

    private Context mContext = BaseApplication.getContent();
    private Resources mResources;

    public static ToastUtils getToast() {
        if(toastUtils==null){
            synchronized (NetWorkUtlis.class){
                if(toastUtils==null){
                    toastUtils=new ToastUtils();
                }
            }
        }
        return toastUtils;
    }

    private ToastUtils() {
        super();
    }


    public void showShortToast(Context context,String msg) {
        showToast(context, msg, Toast.LENGTH_SHORT);
    }

    public void showLongToast(Context context,String msg) {
        showToast(context, msg, Toast.LENGTH_LONG);
    }


    public void showToast(Context context, String msg, int duration){
        showToast(context, msg, duration, Gravity.BOTTOM);
    }

    public void showToast(Context context, String msg, int duration,int gravity){
        Toast toast = Toast.makeText(context, msg, duration);
        toast.setGravity(gravity, 0, 0);
        //toast.show();
        try {
            if (toast != null) {
                toast.setText(msg);
            } else {
                toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
            }
            toast.show();
        } catch (Exception e) {
            e.printStackTrace();
            //解决在子线程中调用Toast的异常情况处理
            Looper.prepare();
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
            Looper.loop();
        }


    }

}
