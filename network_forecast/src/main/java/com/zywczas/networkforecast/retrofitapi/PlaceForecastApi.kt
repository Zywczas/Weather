package com.zywczas.networkforecast.retrofitapi

import com.zywczas.networkcaller.ApiKeys
import com.zywczas.networkcaller.openweatherapi.WeatherApiEndpoint
import com.zywczas.networkcaller.openweatherapi.WeatherApiExcludedReports
import com.zywczas.networkcaller.openweatherapi.WeatherApiLanguage
import com.zywczas.networkcaller.openweatherapi.WeatherApiUnits
import com.zywczas.networkforecast.response.PlaceForecastResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface PlaceForecastApi {

    @GET(WeatherApiEndpoint.FORECAST)
    suspend fun getForecast(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") apiKey: String = ApiKeys.OPEN_WEATHER_MAP,
        @Query("units") units: String = WeatherApiUnits.Metric.value,
        @Query("exclude") exclude: String = "${WeatherApiExcludedReports.Daily.value},${WeatherApiExcludedReports.Hourly.value},${WeatherApiExcludedReports.Alerts.value}",
        @Query("lang") language: String = WeatherApiLanguage.English.value
    ): Response<PlaceForecastResponse>
}
