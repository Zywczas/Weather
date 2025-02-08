package com.zywczas.networkforecast.domain

data class PlaceForecast(
    val temp: Double = 0.0,
    val humidityPercentage: Int = 0,
    val cloudsPercentage: Int = 0,
    val rainMmPerHour: Double? = null
)
