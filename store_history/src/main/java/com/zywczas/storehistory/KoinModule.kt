package com.zywczas.storehistory

import androidx.room.Room
import com.zywczas.storehistory.database.HistoryDatabase
import com.zywczas.storehistory.usecase.GetSavedLocationsUseCase
import com.zywczas.storehistory.usecase.SaveLocationUseCase
import org.koin.core.context.GlobalContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

private fun getHistoryDatabase(): HistoryDatabase = GlobalContext.get().get<HistoryDatabase>()

val storeHistoryModule = module {
    single { Room.databaseBuilder(get(), HistoryDatabase::class.java, "com.zywczas.storehistory.database.HistoryDatabase").build() }
    single { getHistoryDatabase().locationDao() }
    singleOf(::SaveLocationUseCase)
    singleOf(::GetSavedLocationsUseCase)
}
