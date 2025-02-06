package com.zywczas.network_forecast.usecase

import com.zywczas.common_utils.logD
import com.zywczas.network_forecast.R
import com.zywczas.network_forecast.api.PlaceForecastApi
import com.zywczas.network_forecast.domain.PlaceForecast
import com.zywczas.network_forecast.domain.toDomain
import com.zywczas.networkcaller.Resource

class GetPlaceForecastUseCase internal constructor(private val api: PlaceForecastApi) {

    suspend fun get(): Resource<PlaceForecast> = try {
        Resource.Success(api.getForecast().body()!!.toDomain())
    } catch (e: Exception) {
        logD(e.message)
        Resource.Error(R.string.error_forecast_download)
    }
}
