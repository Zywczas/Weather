package com.zywczas.commonutil.extensions

import java.util.Locale

fun Double.roundTo1DecimalPlace(): String = String.format(Locale.UK, "%.1f", this)
