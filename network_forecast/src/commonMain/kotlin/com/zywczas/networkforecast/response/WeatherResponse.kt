package com.zywczas.networkforecast.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(

    @SerialName("main")
    val condition: String = ""
)
