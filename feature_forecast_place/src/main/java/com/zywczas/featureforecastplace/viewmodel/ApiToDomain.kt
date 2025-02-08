package com.zywczas.featureforecastplace.viewmodel

import com.zywczas.networkforecast.response.PlaceForecastResponse

internal fun PlaceForecastResponse.toDomain() = PlaceForecastViewEntity(
    temperature = current.temp,
    humidityPercentage = current.humidityPercentage,
    rainMmPerHour = current.rain?.mmPerHour
)
