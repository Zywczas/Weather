package com.zywczas.networkplaces.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocationResponse(

    @SerialName("name")
    val name: String = "",

    @SerialName("country")
    val country: String = "",

    @SerialName("state")
    val state: String? = null,

    @SerialName("lat")
    val lat: Double = 0.0,

    @SerialName("lon")
    val lon: Double = 0.0
)
