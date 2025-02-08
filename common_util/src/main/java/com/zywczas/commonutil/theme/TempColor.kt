package com.zywczas.commonutil.theme

import androidx.compose.ui.graphics.Color

enum class TempColor(val value: Color) {
    Cold(Color(0xFF00528D)),
    Neutral(Color(0xFF000000)),
    Hot(Color(0xFFD01717));

    companion object {
        fun get(temp: Double): TempColor = when {
            temp < MIN_NEUTRAL_TEMP -> Cold
            temp > MAX_NEUTRAL_TEMP -> Hot
            else -> Neutral
        }
    }
}

private const val MIN_NEUTRAL_TEMP = 10.0
private const val MAX_NEUTRAL_TEMP = 20.0
