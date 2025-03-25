package com.zywczas.networkforecast.response

import com.google.gson.annotations.SerializedName

data class PlaceForecastResponse(

    @SerializedName("current")
    val current: CurrentResponse = CurrentResponse(),

    @SerializedName("hourly")
    val hourly: List<HourlyResponse> = emptyList()
)
