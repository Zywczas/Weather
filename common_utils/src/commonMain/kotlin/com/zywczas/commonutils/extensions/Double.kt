package com.zywczas.commonutils.extensions

//todo update to KMM
//fun Double.roundTo1DecimalPlace(): String = String.format(Locale.UK, "%.1f", this)
fun Double.roundTo1DecimalPlace(): String = this.toString()

//fun Double.roundTo0DecimalPlaces(): String = String.format(Locale.UK, "%.0f", this)
fun Double.roundTo0DecimalPlaces(): String = this.toString()
