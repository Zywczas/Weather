package com.zywczas.network_forecast.openweatherapi

internal enum class ExcludedReports(val value: String) {
    Hourly("hourly"),
    Daily("daily"),
    Alerts("alerts")
}
