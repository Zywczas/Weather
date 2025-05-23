package com.zywczas.storehistory.dao

import com.zywczas.storehistory.cache.HistoryDatabase
import com.zywczas.storehistory.database.DatabaseDriverFactory

internal class HistoryDatabaseDao(databaseDriverFactory: DatabaseDriverFactory) {

    private val database = HistoryDatabase.Companion.invoke(databaseDriverFactory.createDriver())

    val dbQuery = database.historyDatabaseQueries
}
