package com.zywczas.weather.di

import com.zywczas.weather.screens.searchcity.SearchCityViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::SearchCityViewModel)
}
