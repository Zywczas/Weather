package com.zywczas.featureforecastplace.viewmodel

import androidx.compose.ui.text.AnnotatedString
import com.zywczas.commonutil.weather.WeatherCondition

data class HourlyForecastViewEntity(
    val hour: AnnotatedString,
    val weatherCondition: WeatherCondition,
    val temperature: String,
    val precipitationProbability: String,
    val isPrecipitationProbabilityLow: Boolean
)
