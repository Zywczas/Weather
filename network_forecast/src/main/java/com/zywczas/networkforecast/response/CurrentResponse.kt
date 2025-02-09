package com.zywczas.networkforecast.response

import com.google.gson.annotations.SerializedName

data class CurrentResponse(

    @SerializedName("temp")
    val temperature: Double = 0.0,

    @SerializedName("humidity")
    val humidityPercentage: Int = 0,

    @SerializedName("clouds")
    val cloudsPercentage: Int = 0,

    @SerializedName("rain")
    val rain: RainResponse? = null
)
