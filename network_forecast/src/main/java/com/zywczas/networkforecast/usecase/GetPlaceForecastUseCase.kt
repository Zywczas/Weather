package com.zywczas.networkforecast.usecase

import com.zywczas.commonutil.R
import com.zywczas.commonutil.Resource
import com.zywczas.commonutil.logD
import com.zywczas.networkforecast.params.PlaceForecastParams
import com.zywczas.networkforecast.response.PlaceForecastResponse
import com.zywczas.networkforecast.retrofitapi.PlaceForecastApi
//todo update to KMM
class GetPlaceForecastUseCase internal constructor(
//    private val api: PlaceForecastApi
) {

    suspend fun get(params: PlaceForecastParams): Resource<PlaceForecastResponse> = try {
        Resource.Success(
            PlaceForecastResponse()
//            api.getForecast(lat = params.lat, lon = params.lon)
//                .body()!!
        )
    } catch (e: Exception) {
        logD(e.message)
        Resource.Error(R.string.error_forecast_download)
    }
}
