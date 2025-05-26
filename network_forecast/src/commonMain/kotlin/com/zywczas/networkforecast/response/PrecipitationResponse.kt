package com.zywczas.networkforecast.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PrecipitationResponse(

    @SerialName("1h")
    val mmPerHour: Double = 0.0
)
