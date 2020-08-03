package com.mmy.yiyi.alertdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mmy.yiyi.R;

/*
 *
 * 创建自帅气的 清川 on 2020/8/3
 */
public class TipDialog {
    public final static String SUCCESS  = "TOASTER_SUCCESS";
    public final static String ERROR  = "TOASTER_ERROR";
    public final static String WARNING  = "TOASTER_WARNING";
    public final static String INFO  = "TOASTER_INFO";

    /**
     * Shows Rainbow Dialog.
     * @param activity
     * @param title
     * @param message
     * @param dialogType
     */
    public static void showRainbow(Activity activity, String title, String message, String dialogType){
        AlertDialog.Builder dialogBuilder;
        AlertDialog alertDialog;
        dialogBuilder = new AlertDialog.Builder(activity);
        View layoutView = activity.getLayoutInflater().inflate(R.layout.dialog_rainbow, null);
        RelativeLayout layoutDialog = layoutView.findViewById(R.id.dialog_layout);
        switch (dialogType){
            case ERROR:
                layoutDialog.setBackgroundColor(activity.getResources().getColor(R.color.toaster_error));
                break;
            case SUCCESS:
                layoutDialog.setBackgroundColor(activity.getResources().getColor(R.color.toaster_success));
                break;
            case WARNING:
                layoutDialog.setBackgroundColor(activity.getResources().getColor(R.color.toaster_warning));
                break;
            case INFO:
                layoutDialog.setBackgroundColor(activity.getResources().getColor(R.color.toaster_info));
                break;
        }
        ImageView imgClose = layoutView.findViewById(R.id.image_close);
        TextView textTitle = layoutView.findViewById(R.id.text_title);
        TextView textMessage = layoutView.findViewById(R.id.text_message);
        textMessage.setText(message);
        textTitle.setText(title);
        dialogBuilder.setView(layoutView);
        alertDialog = dialogBuilder.create();
        alertDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.getWindow().setGravity(Gravity.BOTTOM);
        alertDialog.show();
        int height = activity.getResources().getDimensionPixelSize(R.dimen.popup_height_emoji_dialog);
        alertDialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,height);
        imgClose.setOnClickListener(view -> alertDialog.dismiss());
    }

}
