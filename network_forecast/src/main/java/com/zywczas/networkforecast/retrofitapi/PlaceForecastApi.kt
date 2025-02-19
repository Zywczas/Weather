package com.zywczas.networkforecast.retrofitapi

import com.zywczas.networkcaller.ApiKeys
import com.zywczas.networkcaller.openweatherapi.Endpoint
import com.zywczas.networkcaller.openweatherapi.ExcludedReports
import com.zywczas.networkcaller.openweatherapi.Units
import com.zywczas.networkforecast.response.PlaceForecastResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface PlaceForecastApi {

    @GET(Endpoint.FORECAST)
    suspend fun getForecast(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") apiKey: String = ApiKeys.OPEN_WEATHER_MAP,
        @Query("units") units: String = Units.Metric.value,
        @Query("exclude") exclude: String = "${ExcludedReports.Daily.value},${ExcludedReports.Hourly.value},${ExcludedReports.Alerts.value}",
    ): Response<PlaceForecastResponse>
}
