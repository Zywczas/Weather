package com.zywczas.featureforecastplace.viewmodel

import com.zywczas.commoncompose.theme.TemperatureColor

internal data class PlaceForecastViewEntity(
    val temperature: Double = 0.0,
    val humidityPercentage: Int = 0,
    val cloudsPercentage: Int = 0,
    val rainMmPerHour: Double? = null,
    val temperatureColor: TemperatureColor = TemperatureColor.get(temperature)
)
