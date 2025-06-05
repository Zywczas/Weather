package com.zywczas.weather.di

import com.zywczas.featureforecastplace.featureForecastPlaceModule
import com.zywczas.networkcaller.networkCallerModule
import com.zywczas.networkforecast.networkForecastModule
import com.zywczas.networkplaces.networkPlacesModule
import com.zywczas.storehistory.storeHistoryDatabaseModule
import com.zywczas.storehistory.storeHistoryModule

val koinModules = listOf(
    featureForecastPlaceModule,
    networkCallerModule,
    networkForecastModule,
    networkPlacesModule,
    storeHistoryDatabaseModule,
    storeHistoryModule,
)
