package com.zywczas.networkforecast.usecase

import com.zywczas.commonutils.Resource
import com.zywczas.commonutils.logD
import com.zywczas.networkforecast.networkapi.PlaceForecastApi
import com.zywczas.networkforecast.params.PlaceForecastParams
import com.zywczas.networkforecast.response.PlaceForecastResponse
import com.zywczas.weather.resources.commonutils.Res
import com.zywczas.weather.resources.commonutils.error_forecast_download

class GetPlaceForecastUseCase internal constructor(private val api: PlaceForecastApi) {

    suspend fun get(params: PlaceForecastParams): Resource<PlaceForecastResponse> = try {
        Resource.Success(
            api.getForecast(lat = params.lat, lon = params.lon)
        )
    } catch (e: Exception) {
        logD(e.message)
        Resource.Error(Res.string.error_forecast_download)
    }
}
