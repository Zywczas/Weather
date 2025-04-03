package com.zywczas.networkplaces.usecase

import com.zywczas.commonutils.Resource
import com.zywczas.commonutils.logD
import com.zywczas.networkplaces.params.LocationsParams
import com.zywczas.networkplaces.response.LocationResponse
import com.zywczas.weather.resources.commonutils.Res
import com.zywczas.weather.resources.commonutils.error_locations_download

//todo update to KMM

class GetNetworkLocationsUseCase internal constructor(
//    private val api: LocationsApi
) {

    suspend fun get(params: LocationsParams): Resource<List<LocationResponse>> = try {
        Resource.Success(
            emptyList()
//            api.getLocations(params.placeName).body()!!
        )
    } catch (e: Exception) {
        logD(e.message)
        Resource.Error(Res.string.error_locations_download)
    }
}
