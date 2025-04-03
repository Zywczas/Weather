package com.zywczas.networkforecast.response

data class PlaceForecastResponse(

    // @SerializedName("current")
    val current: CurrentResponse = CurrentResponse(),

    // @SerializedName("hourly")
    val hourly: List<HourlyResponse> = emptyList()
)
