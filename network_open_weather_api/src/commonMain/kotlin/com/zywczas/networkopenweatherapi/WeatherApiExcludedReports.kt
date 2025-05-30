package com.zywczas.networkopenweatherapi

enum class WeatherApiExcludedReports(val value: String) {
    Hourly("hourly"),
    Daily("daily"),
    Alerts("alerts"),
    Current("current"),
    Minutely("minutely")
}
