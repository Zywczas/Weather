package com.zywczas.networkforecast.response

import com.google.gson.annotations.SerializedName

internal data class RainResponse(

    @SerializedName("1h")
    val mmPerHour: Double = 0.0
)
