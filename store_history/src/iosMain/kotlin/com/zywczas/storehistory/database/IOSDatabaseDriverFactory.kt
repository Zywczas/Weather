package com.zywczas.storehistory.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.zywczas.storehistory.cache.HistoryDatabase

class IOSDatabaseDriverFactory : DatabaseDriverFactory {

    override fun createDriver(): SqlDriver = NativeSqliteDriver(HistoryDatabase.Schema, HistoryDatabaseConstants.NAME)
}
