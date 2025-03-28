package com.zywczas.networkplaces.response

import com.google.gson.annotations.SerializedName

data class LocationResponse(

    @SerializedName("name")
    val name: String = "",

    @SerializedName("country")
    val country: String = "",

    @SerializedName("state")
    val state: String? = null,

    @SerializedName("lat")
    val lat: Double = 0.0,

    @SerializedName("lon")
    val lon: Double = 0.0
)
