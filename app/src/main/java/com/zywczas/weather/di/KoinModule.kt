package com.zywczas.weather.di

import com.zywczas.common_utils.commonUtilModule
import com.zywczas.network_forecast.networkForecastModule
import com.zywczas.networkcaller.networkCallerModule
import com.zywczas.weather.screens.searchcity.SearchCityViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::SearchCityViewModel)
}

val koinModules = listOf(
    appModule,
    networkCallerModule,
    networkForecastModule,
    commonUtilModule,
)
