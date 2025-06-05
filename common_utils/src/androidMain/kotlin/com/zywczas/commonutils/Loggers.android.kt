package com.zywczas.commonutils

import android.util.Log

actual fun logD(msg: Any?) {
    Log.d(LOG_TAG, msg.toString())
}
