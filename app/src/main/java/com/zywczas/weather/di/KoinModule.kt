package com.zywczas.weather.di

import com.zywczas.commonutil.commonUtilModule
import com.zywczas.featureforecastplace.featureForecastPlaceModule
import com.zywczas.networkcaller.networkCallerModule
import com.zywczas.networkforecast.networkForecastModule

val koinModules = listOf(
    featureForecastPlaceModule,
    networkCallerModule,
    networkForecastModule,
    commonUtilModule,
)
