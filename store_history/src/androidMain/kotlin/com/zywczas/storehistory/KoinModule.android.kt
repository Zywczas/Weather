package com.zywczas.storehistory

import com.zywczas.storehistory.database.AndroidDatabaseDriverFactory
import com.zywczas.storehistory.database.DatabaseDriverFactory
import org.koin.dsl.module

actual val storeHistoryDatabaseModule = module {
    single<DatabaseDriverFactory> { AndroidDatabaseDriverFactory(get()) }
}
