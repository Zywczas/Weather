package com.zywczas.commonutil.extensions

import java.util.Locale

fun Double.roundTo2DecimalPlaces(): String = String.format(Locale.UK, "%.2f", this)
