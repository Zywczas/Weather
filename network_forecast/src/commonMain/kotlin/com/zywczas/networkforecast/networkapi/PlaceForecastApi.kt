package com.zywczas.networkforecast.networkapi

import com.zywczas.networkcaller.ApiKeys
import com.zywczas.networkcaller.openweatherapi.WeatherApiConstants
import com.zywczas.networkcaller.openweatherapi.WeatherApiEndpoint
import com.zywczas.networkcaller.openweatherapi.WeatherApiExcludedReports
import com.zywczas.networkcaller.openweatherapi.WeatherApiLanguage
import com.zywczas.networkcaller.openweatherapi.WeatherApiUnits
import com.zywczas.networkforecast.response.PlaceForecastResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.http.URLProtocol

internal class PlaceForecastApi(private val networkCaller: HttpClient) {

    suspend fun getForecast(
        lat: Double,
        lon: Double,
        apiKey: String = ApiKeys.OPEN_WEATHER_MAP,
        units: String = WeatherApiUnits.Metric.value,
        exclude: String = "${WeatherApiExcludedReports.Daily.value},${WeatherApiExcludedReports.Alerts.value},${WeatherApiExcludedReports.Minutely.value}",
        language: String = WeatherApiLanguage.English.value
        //    ):  HttpResponse = client.get {
    ): PlaceForecastResponse = networkCaller.get { //todo jak zadziala to zamienic na response
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
