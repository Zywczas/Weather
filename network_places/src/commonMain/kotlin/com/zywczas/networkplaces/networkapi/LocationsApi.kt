package com.zywczas.networkplaces.networkapi

import com.zywczas.networkopenweatherapi.WeatherApiKeys
import com.zywczas.networkopenweatherapi.WeatherApiConstants
import com.zywczas.networkopenweatherapi.WeatherApiEndpoint
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.URLProtocol
import io.ktor.http.path

internal class LocationsApi(private val networkCaller: HttpClient) {

    suspend fun getLocations(
        cityName: String,
        resultsLimit: Int = WeatherApiConstants.LOCATIONS_RESULTS_LIMIT,
        apiKey: String = WeatherApiKeys.OPEN_WEATHER_MAP,
    ): HttpResponse = networkCaller.get {
        url {
            protocol = URLProtocol.HTTPS
            host = WeatherApiConstants.WEATHER_API_BASE_URL
            path(WeatherApiEndpoint.LOCATION)
            parameters.append("q", cityName)
            parameters.append("limit", resultsLimit.toString())
            parameters.append("appid", apiKey)
        }
    }
}
