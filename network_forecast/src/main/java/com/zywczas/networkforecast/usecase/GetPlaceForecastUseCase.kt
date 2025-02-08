package com.zywczas.networkforecast.usecase

import com.zywczas.commonutil.Resource
import com.zywczas.commonutil.logD
import com.zywczas.networkforecast.R
import com.zywczas.networkforecast.request.PlaceForecastRequest
import com.zywczas.networkforecast.response.PlaceForecastResponse
import com.zywczas.networkforecast.retrofitapi.PlaceForecastApi

class GetPlaceForecastUseCase internal constructor(private val api: PlaceForecastApi) {

    suspend fun get(request: PlaceForecastRequest): Resource<PlaceForecastResponse> = try {
        Resource.Success(
            api.getForecast(lat = request.lat, lon = request.lon)
                .body()!!
        )
    } catch (e: Exception) {
        logD(e.message)
        Resource.Error(R.string.error_forecast_download)
    }
}
