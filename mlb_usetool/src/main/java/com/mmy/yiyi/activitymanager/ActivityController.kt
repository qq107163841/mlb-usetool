package com.mlb.fangkaiyan.util

import android.app.Activity
import java.util.*

/*
 * 
 * 创建自帅气的 清川 on 2020/7/2
 */
class ActivityController {
    var activitystack : Stack<Activity>?=null
    var controller: ActivityController? = null
    constructor(){
        activitystack = Stack<Activity>()
    }

    // 单例模式
    fun getInstance(): ActivityController? {
        if (controller == null) {
            controller = ActivityController()
        }
        return controller
    }
    // 把一个activity压入栈中
    fun pushOneActivity(activity: Activity) {
        activitystack?.add(activity)
    }
    // 获取栈顶的activity，先进后出原则
    fun getLastActivity(): Activity? {
        return activitystack?.lastElement()
    }

    // 移除一个activity
    fun removeOneActivity(activity: Activity?) {
        activitystack?.remove(activity)
    }

    // 退出所有activity
    fun finishAllActivity() {
        while (activitystack?.size!! > 0) {
            val activity = getLastActivity() ?: break
            removeOneActivity(activity)
        }
    }
    //stack长度
    fun getActivitySize(): Int {
        return activitystack?.size!!
    }

}