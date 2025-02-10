package com.zywczas.networkplaces.retrofitapi

import com.zywczas.networkcaller.ApiKeys
import com.zywczas.networkcaller.openweatherapi.Endpoint
import com.zywczas.networkcaller.openweatherapi.ApiConstants
import com.zywczas.networkplaces.response.LocationResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface LocationsApi {

    @GET(Endpoint.LOCATION)
    suspend fun getLocations(
        @Query("q") cityName: String,
        @Query("limit") resultsLimit: Int = ApiConstants.LOCATIONS_RESULTS_LIMIT,
        @Query("appid") apiKey: String = ApiKeys.OPEN_WEATHER_MAP,
    ): Response<List<LocationResponse>>
}
