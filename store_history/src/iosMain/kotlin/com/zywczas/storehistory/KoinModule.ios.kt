package com.zywczas.storehistory

import com.zywczas.storehistory.database.DatabaseDriverFactory
import com.zywczas.storehistory.database.IOSDatabaseDriverFactory
import org.koin.dsl.module

actual val storeHistoryDatabaseModule = module {
    single<DatabaseDriverFactory> { IOSDatabaseDriverFactory() }
}
