package com.zywczas.storehistory.usecase

import com.zywczas.storehistory.entity.LocationLocal

//todo update to KMM
class SaveLocationUseCase internal constructor(
//    private val dao: LocationDao
) {

    suspend fun save(locationLocal: LocationLocal): Long = 1
//        dao.insert(locationLocal) //todo update to KMM
}
