package com.zywczas.weather.di

import com.zywczas.commonutil.commonUtilModule
import com.zywczas.featureforecastplace.featureForecastPlaceModule
import com.zywczas.networkcaller.networkCallerModule
import com.zywczas.networkforecast.networkForecastModule
import com.zywczas.networkplaces.networkPlacesModule
import com.zywczas.storehistory.storeHistoryModule

val koinModules = listOf(
    commonUtilModule,
    featureForecastPlaceModule,
    networkCallerModule,
    networkForecastModule,
    networkPlacesModule,
    storeHistoryModule,
)
