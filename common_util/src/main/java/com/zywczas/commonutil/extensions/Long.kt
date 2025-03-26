package com.zywczas.commonutil.extensions

import java.util.Date

fun Long.unixDateTimeToDate(): Date = Date(this * UNIX_DATE_TIME_MULTIPLIER_TO_JAVA_DATE)

private const val UNIX_DATE_TIME_MULTIPLIER_TO_JAVA_DATE = 1000
