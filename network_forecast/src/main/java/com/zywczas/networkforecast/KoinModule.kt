package com.zywczas.networkforecast

import com.zywczas.networkcaller.createRetrofitService
import com.zywczas.networkforecast.retrofitapi.PlaceForecastApi
import com.zywczas.networkforecast.usecase.GetPlaceForecastUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val networkForecastModule = module {
    single { createRetrofitService<PlaceForecastApi>() }
    singleOf(::GetPlaceForecastUseCase)
}
