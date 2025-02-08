package com.zywczas.weather.di

import com.zywczas.commonutil.commonUtilModule
import com.zywczas.featureforecastplace.featureForecastPlaceModule
import com.zywczas.networkforecast.networkForecastModule
import com.zywczas.networkcaller.networkCallerModule
import com.zywczas.weather.screens.searchcity.SearchCityViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::SearchCityViewModel)
}

val koinModules = listOf(
    appModule,
    featureForecastPlaceModule,
    networkCallerModule,
    networkForecastModule,
    commonUtilModule,
)
