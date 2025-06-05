package com.zywczas.weather.navigation

import kotlinx.serialization.Serializable

interface Destination {

    @Serializable
    object SearchLocation

    @Serializable
    data class PlaceForecast(val lat: Double, val lon: Double, val placeName: String)
}
