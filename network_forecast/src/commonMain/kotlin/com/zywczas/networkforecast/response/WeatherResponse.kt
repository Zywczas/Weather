package com.zywczas.networkforecast.response

import com.zywczas.networkopenweatherapi.WeatherApiWeatherCondition
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(

    @SerialName("main")
    private val main: String = ""
) {

    val condition: WeatherApiWeatherCondition? = WeatherApiWeatherCondition.get(main)
}
