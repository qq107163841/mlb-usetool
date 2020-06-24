package com.mmy.yiyi.dataformat;

import com.mmy.yiyi.logtool.Logg;

/*
 *
 * 创建自帅气的 清川 on 2020/6/18
 */
public class testtime {
    public static void main(String[] args) {
        /**
         * 转化格式：  20200618
         */
        long l1 = TimeDateUtils.currentTimeMillis();
        String string1 = TimeDateUtils.long2String(l1, TimeDateUtils.FORMAT_TYPE_1);
        Logg.i("mlb","转换 + " +string1);
        //
        /**
         * 转化格式：  06月18日 09:29
         */
        long l2 = TimeDateUtils.currentTimeMillis();
        String string2 = TimeDateUtils.long2String(l2, TimeDateUtils.FORMAT_TYPE_2);
        Logg.i("mlb","转换 + " +string2);
        //
        /**
         * 转化格式：  2020-06-18 09:29:06
         */
        long l3 = TimeDateUtils.currentTimeMillis();
        String string3 = TimeDateUtils.long2String(l3, TimeDateUtils.FORMAT_TYPE_3);
        Logg.i("mlb","转换 + " +string3);
        //
        /**
         * 转化格式：  2020年06月18日 09时23分48秒
         */
        long l4 = TimeDateUtils.currentTimeMillis();
        String string4 = TimeDateUtils.long2String(l4, TimeDateUtils.FORMAT_TYPE_4);
        Logg.i("mlb","转换 + " +string4);
        //


    }
}
