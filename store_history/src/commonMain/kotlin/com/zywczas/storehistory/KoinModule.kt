package com.zywczas.storehistory

import com.zywczas.storehistory.usecase.GetLocationsHistoryUseCase
import com.zywczas.storehistory.usecase.SaveLocationUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

//todo update to KMM
//private fun getHistoryDatabase(): HistoryDatabase = GlobalContext.get().get<HistoryDatabase>()

val storeHistoryModule = module {
//    single { Room.databaseBuilder(get(), HistoryDatabase::class.java, "com.zywczas.storehistory.database.HistoryDatabase").build() }
//    single { getHistoryDatabase().locationDao() }
    singleOf(::SaveLocationUseCase)
    singleOf(::GetLocationsHistoryUseCase)
}
