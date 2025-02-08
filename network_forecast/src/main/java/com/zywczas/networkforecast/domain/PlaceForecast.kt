package com.zywczas.networkforecast.domain

import com.zywczas.commonutil.theme.TempColor

data class PlaceForecast(
    val temp: Double = 0.0,
    val humidityPercentage: Int = 0,
    val cloudsPercentage: Int = 0,
    val rainMmPerHour: Double? = null,
    val tempColor: TempColor = TempColor.get(temp)
)
