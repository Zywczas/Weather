package com.zywczas.network_forecast.domain

import com.zywczas.network_forecast.response.PlaceForecastResponse

internal fun PlaceForecastResponse.toDomain() = PlaceForecast(
    temp = current.temp,
    humidityPercentage = current.humidityPercentage,
    rainMmPerHour = current.rain?.mmPerHour
)
