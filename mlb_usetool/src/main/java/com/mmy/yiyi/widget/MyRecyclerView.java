package com.mmy.yiyi.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;

/*
 *
 * 创建自帅气的 清川 on 2020/6/22
 * 自定义srcollview 滑动可关闭自己定义的viewlayout
 *
 */
public class MyRecyclerView extends RecyclerView {
    private OnRecyclerChangeListener onRecyclerChangeListener;

    public MyRecyclerView(@NonNull Context context) {
        super(context);
    }

    public MyRecyclerView(@NonNull Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRecyclerView(@NonNull Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setOnRecyclerChangeListener(OnRecyclerChangeListener onRecyclerChangeListeners) {
        this.onRecyclerChangeListener = onRecyclerChangeListeners;
    }

    public interface OnRecyclerChangeListener {
        void onScrollChanged(float dy);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (onRecyclerChangeListener != null) {
            onRecyclerChangeListener.onScrollChanged(getScrollY() * 0.65f);//x0.65 使位移效果更加平滑 解决手指按住停留时抖动问题
            Log.i("mlb",getScrollY() * 0.65f+"");
        }
    }
}
