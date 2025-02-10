package com.zywczas.storehistory.usecase

import com.zywczas.storehistory.dao.LocationDao
import com.zywczas.storehistory.entity.LocationLocal

class SaveLocationUseCase internal constructor(private val dao: LocationDao) {

    suspend fun save(locationLocal: LocationLocal): Long = dao.insert(locationLocal)
}
