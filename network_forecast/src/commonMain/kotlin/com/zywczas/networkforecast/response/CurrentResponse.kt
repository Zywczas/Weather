package com.zywczas.networkforecast.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentResponse(

    @SerialName("temp")
    val temperature: Double = 0.0,

    @SerialName("humidity")
    val humidityPercentage: Int = 0,

    @SerialName("clouds")
    val cloudsPercentage: Int = 0,

    @SerialName("rain")
    val rain: PrecipitationResponse? = null,

    @SerialName("snow")
    val snow: PrecipitationResponse? = null,

    @SerialName("weather")
    val weather: List<WeatherResponse> = emptyList(),

    @SerialName("pressure")
    val pressure: Int = 0,

    @SerialName("visibility")
    val visibility: Int = 0,

    @SerialName("wind_speed")
    val windSpeed: Double = 0.0,
)
