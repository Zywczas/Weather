package com.zywczas.commonutil.extensions

import java.util.Locale

fun Double.roundTo1DecimalPlace(): String = String.format(Locale.UK, "%.1f", this)

fun Double.roundTo0DecimalPlaces(): String = String.format(Locale.UK, "%.0f", this)
