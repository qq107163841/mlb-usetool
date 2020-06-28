package com.mmy.yiyi.widget;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * 创建自帅气的 清川
 * viewpager 的滑动效果
 * viewPager.setPageTransformer(false,new MyPageTransformer());
 */
public class MyPageTransformer implements ViewPager.PageTransformer {
    //透明度和高度最小值
    private static final float MIN_SCALE = 0.50f;
    private static final float MIN_ALPHA = 0;

    @Override
    public void transformPage(@NonNull View page, float position) {
        int width = page.getWidth();
        int offset = 20 / width;

        if(position < -1 - offset){
            page.setAlpha(MIN_ALPHA);
            page.setScaleY(MIN_SCALE);
        }else if(position <= 1 + offset){//在[-1-offset,1+offset]范围
            if(position == 0){ //当前页面
                page.setAlpha(1.0f);
                page.setScaleY(1.0f);
            }else{
                if(position < 0){ //在[-1-offset,0]范围
                    //平滑变化
                    float f = MIN_ALPHA + (1 - MIN_ALPHA) * (1 + position + offset);
                    page.setAlpha(f);
                    float s = MIN_SCALE +(1 - MIN_SCALE) * (1+position + offset);
                    page.setScaleY(s);
                }else{ //在[0，1+offset]范围
                    //平滑变化
                    float f = MIN_ALPHA + (1 - MIN_ALPHA) * (1 - position + offset);
                    page.setAlpha(f);
                    float s = MIN_SCALE +(1 - MIN_SCALE) * (1 - position + offset);
                    page.setScaleY(s);
                }

            }
        }
    }
}
