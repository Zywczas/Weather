package com.zywczas.storehistory.usecase

import com.zywczas.storehistory.dao.LocationDao
import com.zywczas.storehistory.entity.LocationLocal

class GetLocationsHistoryUseCase internal constructor(private val dao: LocationDao) {

    suspend fun get(): List<LocationLocal> = dao.getLocations()
}
