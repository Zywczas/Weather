package com.zywczas.networkforecast

import com.zywczas.networkforecast.networkapi.PlaceForecastApi
import com.zywczas.networkforecast.usecase.GetPlaceForecastUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val networkForecastModule = module {
    singleOf(::PlaceForecastApi)
    singleOf(::GetPlaceForecastUseCase)
}
