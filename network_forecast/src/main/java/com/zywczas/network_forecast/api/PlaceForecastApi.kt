package com.zywczas.network_forecast.api

import com.zywczas.network_forecast.response.PlaceForecastResponse
import com.zywczas.networkcaller.NetworkConstants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface PlaceForecastApi {

    @GET(Endpoint.FORECAST)
    suspend fun getForecast(
        @Query("lat") lat: Double = 52.2297,
        @Query("lon") lon: Double = 21.0122,
        @Query("appid") apiKey: String = NetworkConstants.API_KEY,
    ): Response<PlaceForecastResponse>
}
