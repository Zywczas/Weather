package com.zywczas.commonutils.extensions

import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.pow

enum class RoundingMode {
    HALF_UP,
}

fun Double.round(decimalPlaces: Int, mode: RoundingMode = RoundingMode.HALF_UP): Double {
    val factor = 10.0.pow(decimalPlaces)
    val scaledValue = this * factor

    val resultScaled: Double = when (mode) {
        RoundingMode.HALF_UP -> if (scaledValue >= 0.0) floor(scaledValue + 0.5) else ceil(scaledValue - 0.5)
    }
    return resultScaled / factor
}
