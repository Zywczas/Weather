package com.zywczas.networkforecast.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HourlyResponse(

    @SerialName("dt")
    val unixDateTime: Long = 0,

    @SerialName("temp")
    val temperature: Double = 0.0,

    @SerialName("rain")
    val rain: PrecipitationResponse? = null,

    @SerialName("snow")
    val snow: PrecipitationResponse? = null,

    @SerialName("pop")
    val precipitationProbability: Double = 0.0,

    @SerialName("weather")
    val weather: List<WeatherResponse> = emptyList(),

    @SerialName("clouds")
    val cloudsPercentage: Int = 0,
)
