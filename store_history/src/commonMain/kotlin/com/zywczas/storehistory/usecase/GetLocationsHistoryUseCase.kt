package com.zywczas.storehistory.usecase

import com.zywczas.storehistory.dao.HistoryDatabaseDao
import com.zywczas.storehistory.entity.LocationLocal
import com.zywczas.storehistory.entity.toLocal

class GetLocationsHistoryUseCase internal constructor(
    private val dao: HistoryDatabaseDao
) {

    fun get(): List<LocationLocal> = dao.dbQuery.getLocations().executeAsList().map { it.toLocal() }
}
