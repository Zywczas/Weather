package com.zywczas.networkplaces.usecase

import com.zywczas.commonutils.Resource
import com.zywczas.commonutils.logD
import com.zywczas.networkplaces.networkapi.LocationsApi
import com.zywczas.networkplaces.params.LocationsParams
import com.zywczas.networkplaces.response.LocationResponse
import com.zywczas.weather.resources.commonutils.Res
import com.zywczas.weather.resources.commonutils.error_locations_download
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse

class GetNetworkLocationsUseCase internal constructor(private val api: LocationsApi) {

    suspend fun get(params: LocationsParams): Resource<List<LocationResponse>> = try {
        val response: HttpResponse = api.getLocations(params.placeName)
        Resource.Success(response.body())
    } catch (e: Exception) {
        logD(e.message)
        Resource.Error(Res.string.error_locations_download)
    }
}
