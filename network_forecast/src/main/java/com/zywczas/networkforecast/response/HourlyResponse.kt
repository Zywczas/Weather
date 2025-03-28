package com.zywczas.networkforecast.response

import com.google.gson.annotations.SerializedName

data class HourlyResponse(

    @SerializedName("dt")
    val unixDateTime: Long = 0,

    @SerializedName("temp")
    val temperature: Double = 0.0,

    @SerializedName("rain")
    val rain: PrecipitationResponse? = null,

    @SerializedName("snow")
    val snow: PrecipitationResponse? = null,

    @SerializedName("pop")
    val precipitationProbability: Double = 0.0,

    @SerializedName("weather")
    val weather: List<WeatherResponse> = emptyList(),

    @SerializedName("clouds")
    val cloudsPercentage: Int = 0,
)
