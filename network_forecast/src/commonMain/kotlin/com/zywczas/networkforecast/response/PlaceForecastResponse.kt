package com.zywczas.networkforecast.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlaceForecastResponse(

    @SerialName("current")
    val current: CurrentResponse = CurrentResponse(),

    @SerialName("hourly")
    val hourly: List<HourlyResponse> = emptyList()
)
