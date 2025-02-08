package com.zywczas.network_forecast.response

import com.google.gson.annotations.SerializedName

internal data class CurrentResponse(
    @SerializedName("temp")
    val temp: Double = 0.0,

    @SerializedName("humidity")
    val humidityPercentage: Int = 0,

    @SerializedName("clouds")
    val cloudsPercentage: Int = 0,

    @SerializedName("rain")
    val rain: RainResponse? = null
)
