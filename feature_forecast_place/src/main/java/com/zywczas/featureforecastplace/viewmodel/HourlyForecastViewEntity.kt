package com.zywczas.featureforecastplace.viewmodel

import com.zywczas.commonutil.weather.WeatherCondition

data class HourlyForecastViewEntity(
    val hour: String,
    val weatherCondition: WeatherCondition,
    val temperature: String,
    val precipitationProbability: String,
    val isPrecipitationProbabilityLow: Boolean
)
