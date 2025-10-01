package com.zywczas.featureforecastplace.viewmodel

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.AnnotatedString
import com.zywczas.commonutils.weather.WeatherCondition

@Immutable
data class HourlyForecastViewEntity(
    val hour: AnnotatedString,
    val weatherCondition: WeatherCondition,
    val temperature: String,
    val precipitationProbability: String,
    val isPrecipitationProbabilityLow: Boolean
)
