package com.zywczas.networkplaces.response

import com.google.gson.annotations.SerializedName

internal data class LocationResponse(

    @SerializedName("name")
    val name: String = "",

    @SerializedName("country")
    val country: String = "",

    @SerializedName("state")
    val state: String = "",

    @SerializedName("lat")
    val lat: Double = 0.0,

    @SerializedName("lon")
    val lon: Double = 0.0
)
