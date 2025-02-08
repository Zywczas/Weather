package com.zywczas.network_forecast.retrofitapi

import com.zywczas.network_forecast.openweatherapi.Endpoint
import com.zywczas.network_forecast.openweatherapi.ExcludedReports
import com.zywczas.network_forecast.openweatherapi.Units
import com.zywczas.network_forecast.response.PlaceForecastResponse
import com.zywczas.networkcaller.ApiKeys
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface PlaceForecastApi {

    @GET(Endpoint.FORECAST)
    suspend fun getForecast(
        @Query("lat") lat: Double = 52.2297,
        @Query("lon") lon: Double = 21.0122,
        @Query("appid") apiKey: String = ApiKeys.OPEN_WEATHER_MAP,
        @Query("units") units: String = Units.Metric.value,
        @Query("exclude") exclude: String = "${ExcludedReports.Daily.value},${ExcludedReports.Hourly.value},${ExcludedReports.Alerts.value}",
    ): Response<PlaceForecastResponse>
}
