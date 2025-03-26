package com.zywczas.commonutil.extensions

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * @return just hour number, e.g. '14'
 */
val Date.hour: String get() = SimpleDateFormat("HH", Locale.getDefault()).format(this)

