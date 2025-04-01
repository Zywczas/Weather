package com.zywczas.networkplaces.retrofitapi

import com.zywczas.networkcaller.ApiKeys
import com.zywczas.networkcaller.openweatherapi.WeatherApiEndpoint
import com.zywczas.networkcaller.openweatherapi.WeatherApiConstants
import com.zywczas.networkplaces.response.LocationResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
//todo update to KMM

internal interface LocationsApi {

//    @GET(WeatherApiEndpoint.LOCATION)
//    suspend fun getLocations(
//        @Query("q") cityName: String,
//        @Query("limit") resultsLimit: Int = WeatherApiConstants.LOCATIONS_RESULTS_LIMIT,
//        @Query("appid") apiKey: String = ApiKeys.OPEN_WEATHER_MAP,
//    ): Response<List<LocationResponse>>
}
