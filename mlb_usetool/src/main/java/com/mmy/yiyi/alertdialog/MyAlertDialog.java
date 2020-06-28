package com.mmy.yiyi.alertdialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.mmy.yiyi.R;

/**
 * 创建自帅气的 清川
 * mmy AlertDialog 弹窗工具类
 */
public class MyAlertDialog {
    //保持唯一
    private static AlertDialog alertDialog;
    private static Context context;

    public static MyAlertDialog getIntance(Context contexts){
        AlertDialog.Builder builder = new AlertDialog.Builder(contexts);
        alertDialog = builder.create();
        context=contexts;
        return new MyAlertDialog();
    }

    private boolean isShowing = false;
    //判断之前是不是显示过了
    public static boolean getIsShowing(){
        return alertDialog.isShowing();
    }
    //dissmiss
    public void  dissmiss(){
        if(alertDialog!=null){
            if(alertDialog.isShowing()){
                alertDialog.dismiss();
            }
        }
    }

    /**
     *
     * @param title tile
     * @param imageview loadin图片
     * @param width alerdialog的宽
     * @param height alerdialog的高
     * @param isOutSide 是否back可取消
     */
    public void showLoadingDialog(String title,int imageview,int width,int height,boolean isOutSide) {
        View view = LayoutInflater.from(context).inflate(R.layout.alert_dialog_loading, null);
        ImageView imageView = view.findViewById(R.id.alert_loading_image);
        TextView textView = view.findViewById(R.id.alert_loading_title);
        textView.setText(title);
        imageView.setBackgroundResource(imageview);
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.rotate);
        imageView.startAnimation(animation);
        //监听手机返回按钮
        alertDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                //返回就关掉alertdialog
                if (keyCode == KeyEvent.KEYCODE_BACK)return false;
                return true;
            }
        });
        alertDialog.show();
        alertDialog.setContentView(view);
        alertDialog.setCanceledOnTouchOutside(isOutSide);
        alertDialog.getWindow().setLayout(width,height);
        //去掉边框
        alertDialog.setView(view,0,0,0,0);

    }

    public void showLoadingDialog(String title) {
        View view = LayoutInflater.from(context).inflate(R.layout.alert_dialog_loading, null);
        ImageView imageView = view.findViewById(R.id.alert_loading_image);
        TextView textView = view.findViewById(R.id.alert_loading_title);
        textView.setText(title);
        imageView.setBackgroundResource(R.drawable.alert_loading);
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.rotate);
        imageView.startAnimation(animation);
        //监听手机返回按钮
        alertDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                //返回就关掉alertdialog false=close
                if (keyCode == KeyEvent.KEYCODE_BACK)return false;
                return true;
            }
        });
        alertDialog.show();
        alertDialog.setContentView(view);
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.getWindow().setLayout(500,300);
        //去掉边框
        alertDialog.setView(view,0,0,0,0);
    }

    /**
     * 带有确认取消按钮的自定义dialog
     *
     * @param context 上下文
     * @param message 显示的信息
     */
    public void showConfirmDialog(Context context, String message,boolean isDissmiss) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
        View view = View.inflate(context, R.layout.view_alert_dialog_confirm, null);
        TextView tvMsg = view.findViewById(R.id.tv_message_dialog);
        TextView tvCancel = view.findViewById(R.id.tv_cancel_dialog);
        TextView tvConfirm = view.findViewById(R.id.tv_confirm_dialog);
        tvMsg.setText(message);
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClickListener.onNegativeButtonClick(alertDialog);
            }
        });
        tvConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClickListener.onPositiveButtonClick(alertDialog);
            }
        });

        alertDialog.getWindow().setContentView(view);
        alertDialog.setCanceledOnTouchOutside(isDissmiss);
        alertDialog.getWindow().setLayout(800,500);
        //去掉边框
        alertDialog.setView(view,0,0,0,0);
    }

    /**
     * 带有确认取消按钮的自定义dialog
     *
     * @param context 上下文
     * @param message 显示的信息
     */
    public void showConfirmDialog(Context context, String message,String cancel,String confirm,boolean isDissmiss) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
        View view = View.inflate(context, R.layout.view_alert_dialog_confirm, null);
        TextView tvMsg = view.findViewById(R.id.tv_message_dialog);
        TextView tvCancel = view.findViewById(R.id.tv_cancel_dialog);
        TextView tvConfirm = view.findViewById(R.id.tv_confirm_dialog);
        tvMsg.setText(message);
        tvCancel.setText(cancel);
        tvConfirm.setText(confirm);
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClickListener.onNegativeButtonClick(alertDialog);
            }
        });
        tvConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClickListener.onPositiveButtonClick(alertDialog);
            }
        });

        alertDialog.getWindow().setContentView(view);
        alertDialog.setCanceledOnTouchOutside(isDissmiss);
        alertDialog.getWindow().setLayout(800,500);
        //去掉边框
        alertDialog.setView(view,0,0,0,0);
    }

    public void ShowBackTipDialog(String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(context,R.style.NobackDialog);
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
        View view = View.inflate(context, R.layout.view_alert_dialog_backtip, null);
        TextView tvMsg = view.findViewById(R.id.alert_backtip_msg);
        tvMsg.setText(msg);
        alertDialog.getWindow().setContentView(view);
        alertDialog.getWindow().setGravity(Gravity.BOTTOM);
        alertDialog.getWindow().setLayout(500,150);
        alertDialog.setView(view,0,0,0,0);

    }



    private static OnButtonClickListener onButtonClickListener;

    public void setOnButtonClickListener(OnButtonClickListener onButtonClickListener) {
        this.onButtonClickListener = onButtonClickListener;
    }

    /**
     * 按钮点击回调接口
     */
    public interface OnButtonClickListener {
        /**
         * 确定按钮点击回调方法
         *
         * @param dialog 当前 AlertDialog，传入它是为了在调用的地方对 dialog 做操作，比如 dismiss()
         *               也可以在该工具类中直接  dismiss() 掉，就不用将 AlertDialog 对象传出去了
         */
        void onPositiveButtonClick(AlertDialog dialog);

        /**
         * 取消按钮点击回调方法
         *
         * @param dialog 当前AlertDialog
         */
        void onNegativeButtonClick(AlertDialog dialog);
    }




}

