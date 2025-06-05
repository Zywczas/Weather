package com.zywczas.storehistory.usecase

import com.zywczas.storehistory.dao.HistoryDatabaseDao
import com.zywczas.storehistory.entity.LocationLocal
import com.zywczas.storehistory.entity.toCache

class SaveLocationUseCase internal constructor(
    private val dao: HistoryDatabaseDao
) {

    fun save(location: LocationLocal) {
        dao.dbQuery.insertLocation(location.toCache())
    }
}
