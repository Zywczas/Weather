package com.zywczas.networkforecast.usecase

import com.zywczas.commonutil.logD
import com.zywczas.networkcaller.Resource
import com.zywczas.networkforecast.R
import com.zywczas.networkforecast.domain.PlaceForecast
import com.zywczas.networkforecast.domain.toDomain
import com.zywczas.networkforecast.retrofitapi.PlaceForecastApi

class GetPlaceForecastUseCase internal constructor(private val api: PlaceForecastApi) {

    suspend fun get(): Resource<PlaceForecast> = try {
        Resource.Success(api.getForecast().body()!!.toDomain())
    } catch (e: Exception) {
        logD(e.message)
        Resource.Error(R.string.error_forecast_download)
    }
}
