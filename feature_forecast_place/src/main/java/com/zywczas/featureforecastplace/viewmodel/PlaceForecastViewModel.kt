package com.zywczas.featureforecastplace.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.zywczas.commonutil.BaseViewModel
import com.zywczas.commonutil.Resource
import com.zywczas.commonutil.StringProvider
import com.zywczas.featureforecastplace.screens.PlaceForecastArgs
import com.zywczas.networkforecast.params.PlaceForecastParams
import com.zywczas.networkforecast.usecase.GetPlaceForecastUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

internal class PlaceForecastViewModel(
    private val stringProvider: StringProvider,
    private val getPlaceForecastUseCase: GetPlaceForecastUseCase,
) : BaseViewModel() {

    var viewEntity by mutableStateOf(PlaceForecastViewEntity())
        private set

    fun init(args: PlaceForecastArgs) {
        viewModelScope.launch(Dispatchers.IO) {
            getForecast(args)
        }
    }

    private suspend fun getForecast(args: PlaceForecastArgs) {
        when (val response = getPlaceForecastUseCase.get((PlaceForecastParams(lat = args.lat, lon = args.lon)))) {
            is Resource.Success -> viewEntity = response.data.toDomain(toolbarTitle = args.placeName, stringProvider = stringProvider)
            is Resource.Error -> showError(stringProvider.getString(response.message))
        }
    }
}
