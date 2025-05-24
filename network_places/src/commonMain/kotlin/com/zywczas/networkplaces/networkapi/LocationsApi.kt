package com.zywczas.networkplaces.networkapi

import com.zywczas.networkcaller.ApiKeys
import com.zywczas.networkcaller.openweatherapi.WeatherApiConstants
import com.zywczas.networkcaller.openweatherapi.WeatherApiEndpoint
import com.zywczas.networkplaces.response.LocationResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.http.URLProtocol

internal class LocationsApi(private val client: HttpClient) {

    //    @GET(WeatherApiEndpoint.LOCATION)
    //    suspend fun getLocations(
    //        @Query("q") cityName: String,
    //        @Query("limit") resultsLimit: Int = WeatherApiConstants.LOCATIONS_RESULTS_LIMIT,
    //        @Query("appid") apiKey: String = ApiKeys.OPEN_WEATHER_MAP,
    //    ): Response<List<LocationResponse>>

    suspend fun getLocations(
        cityName: String,
        resultsLimit: Int = WeatherApiConstants.LOCATIONS_RESULTS_LIMIT,
        apiKey: String = ApiKeys.OPEN_WEATHER_MAP,
//    ):  HttpResponse = client.get {
    ):  List<LocationResponse> = client.get { //todo jak zadziala to zamienic na response
        url {
            protocol = URLProtocol.HTTPS
            host = WeatherApiConstants.WEATHER_API_BASE_URL
            path(WeatherApiEndpoint.LOCATION)
//            path("${WeatherApiConstants.WEATHER_API_BASE_URL}${WeatherApiEndpoint.LOCATION}")
            parameters.append("q", cityName)
            parameters.append("limit", resultsLimit.toString())
            parameters.append("appid", apiKey)
        }
    }
}
