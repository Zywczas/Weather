package com.zywczas.featureforecastplace.viewmodel

import com.example.commoncompose.theme.TempColor

data class PlaceForecastViewEntity(
    val temp: Double = 0.0,
    val humidityPercentage: Int = 0,
    val cloudsPercentage: Int = 0,
    val rainMmPerHour: Double? = null,
    val tempColor: TempColor = TempColor.get(temp)
)
