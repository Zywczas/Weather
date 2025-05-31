package com.zywczas.networkopenweatherapi

enum class WeatherApiWeatherCondition(val value: String) {
    Clear("Clear"),
    Clouds("Clouds"),
    Rain("Rain"),
    Snow("Snow"),
    Atmosphere("Atmosphere"),
    Drizzle("Drizzle"),
    Thunderstorm("Thunderstorm");

    companion object {
        fun get(name: String): WeatherApiWeatherCondition? = WeatherApiWeatherCondition.entries.find { name == it.name }
    }
}
