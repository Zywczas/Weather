package com.zywczas.networkforecast

import com.zywczas.networkforecast.retrofitapi.PlaceForecastApi
import com.zywczas.networkforecast.usecase.GetPlaceForecastUseCase
import org.koin.core.context.GlobalContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit

private inline fun <reified T> createService(): T = GlobalContext.get().get<Retrofit>().create(T::class.java)

val networkForecastModule = module {
    single { createService<PlaceForecastApi>() }
    singleOf(::GetPlaceForecastUseCase)
}
