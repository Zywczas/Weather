package com.zywczas.commonutils

object UnitsConverter {

    fun mPerSecToKmPerH(mPerSec: Double): Double = mPerSec * METERS_IN_KILOMETER / SECONDS_IN_HOUR

    private const val METERS_IN_KILOMETER = 1000
    private const val SECONDS_IN_HOUR = 3600
}
