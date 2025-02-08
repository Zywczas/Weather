package com.zywczas.network_forecast.response

import com.google.gson.annotations.SerializedName

internal data class PlaceForecastResponse(

    @SerializedName("current")
    val current: CurrentResponse
)
