package com.zywczas.commonutil.weather

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.zywczas.commonutil.R

enum class WeatherCondition(@DrawableRes val icon: Int, @StringRes val contentDescription: Int) {
    Clear(R.drawable.ic_condition_sunny, R.string.content_description_condition_clear),
    Thunderstorm(R.drawable.ic_condition_thunder, R.string.content_description_condition_thunderstorm),
    Drizzle(R.drawable.ic_condition_drizzle, R.string.content_description_condition_drizzle),
    Rain(R.drawable.ic_condition_rain, R.string.content_description_condition_rain),
    Snow(R.drawable.ic_condition_snowy, R.string.content_description_condition_snow),
    Atmosphere(R.drawable.ic_condition_fog, R.string.content_description_condition_atmosphere),
    Clouds(R.drawable.ic_condition_cloudy, R.string.content_description_condition_clouds),
}
