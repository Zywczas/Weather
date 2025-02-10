package com.zywczas.featureforecastplace

import com.zywczas.featureforecastplace.viewmodel.PlaceForecastViewModel
import com.zywczas.featureforecastplace.viewmodel.SearchLocationViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val featureForecastPlaceModule = module {
    viewModelOf(::PlaceForecastViewModel)
    viewModelOf(::SearchLocationViewModel)
}
