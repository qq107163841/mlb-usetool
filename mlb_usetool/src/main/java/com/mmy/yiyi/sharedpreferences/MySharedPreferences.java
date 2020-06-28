package com.mmy.yiyi.sharedpreferences;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * 创建自帅气的 清川
 * MySharedPreferences 存储用户登录信息
 * //不方便引用可复制粘贴
 */
public class MySharedPreferences {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private MySharedPreferences mySharedPreferences;
    private Context context;
    private String name;
    /**
     * 构造方法
     * @param ctx  上下文
     */
    @SuppressLint("CommitPrefEdits")
    public MySharedPreferences(Context ctx,String name) {
        this.context = ctx;
        sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }


    /**
     * 存入数据
     *
     * @param key   键
     * @param value 值
     */
    public void putValue(String key, Object value) {
        if (value instanceof String) {
            editor.putString(key, String.valueOf(value));
        } else if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if (value instanceof Float) {
            editor.putFloat(key, (Float) value);
        } else if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        }

        editor.apply();
    }

    /**
     * 获取值
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return object
     */
    public Object getValue(String key, Object defaultValue) {
        if (defaultValue instanceof String) {
            return sharedPreferences.getString(key, String.valueOf(defaultValue));
        } else if (defaultValue instanceof Boolean) {
            return sharedPreferences.getBoolean(key, (Boolean) defaultValue);
        } else if (defaultValue instanceof Integer) {
            return sharedPreferences.getInt(key, (Integer) defaultValue);
        } else if (defaultValue instanceof Float) {
            return sharedPreferences.getFloat(key, (Float) defaultValue);
        } else if (defaultValue instanceof Long) {
            return sharedPreferences.getLong(key, (Long) defaultValue);
        } else {
            return defaultValue;
        }
    }

    /**
     * 清除SharedPreferences
     */
    public void clear() {
        editor.clear();
        editor.apply();
    }

    /**
     * 移除某个键对应的值
     *
     * @param key 键
     */
    public void remove(String key) {
        editor.remove(key);
        editor.apply();
    }

}
