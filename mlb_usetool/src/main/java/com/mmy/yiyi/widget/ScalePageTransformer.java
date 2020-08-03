package com.mmy.yiyi.widget;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;

/*
 *
 * 创建自帅气的 清川 on 2020/7/14
 * viewpagr 滑动缩放
 */
public class ScalePageTransformer implements ViewPager.PageTransformer{
    public static final float MAX_SCALE = 1.0f;
    public static final float MIN_SCALE = 0.8f;
    private final boolean isFill;

    public ScalePageTransformer(boolean isFill) {
        this.isFill = isFill;
    }

    @Override
    public void transformPage(@NonNull View page, float position) {
        if (position < -1) {
            position = -1;
        } else if (position > 1) {
            position = 1;
        }
        float tempScale = position < 0 ? 1 + position : 1 - position;

        float slope = (MAX_SCALE - MIN_SCALE) / 1;

        float scaleValue = MIN_SCALE + tempScale * slope;
        if (isFill) {
            page.setScaleX(scaleValue);
        }
        page.setScaleY(scaleValue);
    }

}