package com.zywczas.storehistory.database

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.zywczas.storehistory.cache.HistoryDatabase

class AndroidDatabaseDriverFactory(private val context: Context) : DatabaseDriverFactory {

    override fun createDriver(): SqlDriver = AndroidSqliteDriver(HistoryDatabase.Schema, context, HistoryDatabaseConstants.NAME)
}
