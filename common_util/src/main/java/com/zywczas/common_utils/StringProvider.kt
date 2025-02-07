package com.zywczas.common_utils

import android.content.Context
import androidx.annotation.StringRes

class StringProvider(private val context: Context) {

    fun getString(@StringRes res: Int, vararg params: String) = context.getString(res, *params)
}
