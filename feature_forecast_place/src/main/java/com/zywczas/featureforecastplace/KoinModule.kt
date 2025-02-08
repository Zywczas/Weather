package com.zywczas.featureforecastplace

import com.zywczas.featureforecastplace.viewmodel.PlaceForecastViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val featureForecastPlaceModule = module {
    viewModelOf(::PlaceForecastViewModel)
}
