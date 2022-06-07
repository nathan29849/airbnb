package com.example.airbnb.common

import android.app.ActivityManager

const val CHANNEL_ID = "downLoadChannel"

fun isAppInForegrounded(): Boolean {
    val appProcessInfo = ActivityManager.RunningAppProcessInfo();
    ActivityManager.getMyMemoryState(appProcessInfo);
    return (appProcessInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND ||
            appProcessInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_VISIBLE)
}
