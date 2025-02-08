package com.zywczas.networkforecast.domain

import com.zywczas.networkforecast.response.PlaceForecastResponse

internal fun PlaceForecastResponse.toDomain() = PlaceForecast(
    temp = current.temp,
    humidityPercentage = current.humidityPercentage,
    rainMmPerHour = current.rain?.mmPerHour
)
