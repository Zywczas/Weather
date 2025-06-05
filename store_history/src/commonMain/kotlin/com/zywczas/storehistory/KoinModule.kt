package com.zywczas.storehistory

import com.zywczas.storehistory.dao.HistoryDatabaseDao
import com.zywczas.storehistory.usecase.GetLocationsHistoryUseCase
import com.zywczas.storehistory.usecase.SaveLocationUseCase
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val storeHistoryModule = module {
    singleOf(::HistoryDatabaseDao)
    singleOf(::SaveLocationUseCase)
    singleOf(::GetLocationsHistoryUseCase)
}

expect val storeHistoryDatabaseModule: Module
