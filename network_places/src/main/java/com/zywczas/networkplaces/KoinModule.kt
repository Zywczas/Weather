package com.zywczas.networkplaces

import com.zywczas.networkcaller.createRetrofitService
import com.zywczas.networkplaces.retrofitapi.LocationsApi
import com.zywczas.networkplaces.usecase.GetNetworkLocationsUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val networkPlacesModule = module {
    single { createRetrofitService<LocationsApi>() }
    singleOf(::GetNetworkLocationsUseCase)
}
