package com.zywczas.commonutil

import androidx.annotation.DrawableRes

enum class WeatherCondition(@DrawableRes val icon: Int) {
    Clear(R.drawable.ic_condition_sunny),
    Thunderstorm(R.drawable.ic_condition_thunder),
    Drizzle(R.drawable.ic_condition_drizzle),
    Rain(R.drawable.ic_condition_rain),
    Snow(R.drawable.ic_condition_snowy),
    Atmosphere(R.drawable.ic_condition_fog),
    Clouds(R.drawable.ic_condition_cloudy),
}
