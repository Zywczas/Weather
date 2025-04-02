package com.zywczas.commonutils.extensions

import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

//todo update to KMM, check outcome
//fun Long.unixDateTimeToDate(): Date = Date(this * UNIX_DATE_TIME_MULTIPLIER_TO_JAVA_DATE)
//private const val UNIX_DATE_TIME_MULTIPLIER_TO_JAVA_DATE = 1000

fun Long.unixDateTimeToDate(): LocalDateTime = Instant.fromEpochSeconds(this).toLocalDateTime(TimeZone.currentSystemDefault())
