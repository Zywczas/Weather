package com.zywczas.networkforecast.response

import com.google.gson.annotations.SerializedName
import com.zywczas.commonutil.WeatherCondition

data class WeatherResponse(

    @SerializedName("main")
    private val main: String = ""
) {

    val condition: WeatherCondition? = when (main) {
        "Clear" -> WeatherCondition.Clear
        "Clouds" -> WeatherCondition.Clouds
        "Rain" -> WeatherCondition.Rain
        "Snow" -> WeatherCondition.Snow
        "Atmosphere" -> WeatherCondition.Atmosphere
        "Drizzle" -> WeatherCondition.Drizzle
        "Thunderstorm" -> WeatherCondition.Thunderstorm
        else -> null
    }
}
