package com.zywczas.networkplaces.usecase

import com.zywczas.commonutil.R
import com.zywczas.commonutil.Resource
import com.zywczas.commonutil.logD
import com.zywczas.networkplaces.domain.Location
import com.zywczas.networkplaces.domain.toDomain
import com.zywczas.networkplaces.params.LocationsParams
import com.zywczas.networkplaces.retrofitapi.LocationsApi

class GetLocationsUseCase internal constructor(private val api: LocationsApi) {

    suspend fun get(params: LocationsParams): Resource<List<Location>> = try {
        Resource.Success(api.getLocations(params.placeName).body()!!.map { it.toDomain() })
    } catch (e: Exception) {
        logD(e.message)
        Resource.Error(R.string.error_locations_download)
    }
}
