package com.zywczas.networkforecast.response

import com.google.gson.annotations.SerializedName

data class WeatherResponse(

    @SerializedName("main")
    val condition: String = ""
)
