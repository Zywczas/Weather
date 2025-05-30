package com.zywczas.networkforecast.networkapi

import com.zywczas.networkopenweatherapi.WeatherApiKeys
import com.zywczas.networkopenweatherapi.WeatherApiConstants
import com.zywczas.networkopenweatherapi.WeatherApiEndpoint
import com.zywczas.networkopenweatherapi.WeatherApiExcludedReports
import com.zywczas.networkopenweatherapi.WeatherApiLanguage
import com.zywczas.networkopenweatherapi.WeatherApiUnits
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.URLProtocol
import io.ktor.http.path

internal class PlaceForecastApi(private val networkCaller: HttpClient) {

    suspend fun getForecast(
        lat: Double,
        lon: Double,
        apiKey: String = WeatherApiKeys.OPEN_WEATHER_MAP,
        units: String = WeatherApiUnits.Metric.value,
        exclude: String = "${WeatherApiExcludedReports.Daily.value},${WeatherApiExcludedReports.Alerts.value},${WeatherApiExcludedReports.Minutely.value}",
        language: String = WeatherApiLanguage.English.value
    ): HttpResponse = networkCaller.get {
        url {
            protocol = URLProtocol.HTTPS
            host = WeatherApiConstants.WEATHER_API_BASE_URL
            path(WeatherApiEndpoint.FORECAST)
            parameters.append("lat", lat.toString())
            parameters.append("lon", lon.toString())
            parameters.append("appid", apiKey)
            parameters.append("units", units)
            parameters.append("exclude", exclude)
            parameters.append("lang", language)
        }
    }
}
