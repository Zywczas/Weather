package com.zywczas.storehistory.usecase

import com.zywczas.storehistory.entity.LocationLocal

//todo update to KMM

class GetLocationsHistoryUseCase internal constructor(
//    private val dao: LocationDao
) {

    suspend fun get(): List<LocationLocal> = emptyList()
//todo update to KMM
//        dao.getLocations()
}
