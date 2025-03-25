package com.zywczas.networkforecast.response

import com.google.gson.annotations.SerializedName

data class PrecipitationResponse(

    @SerializedName("1h")
    val mmPerHour: Double = 0.0
)
