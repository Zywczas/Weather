package com.zywczas.featureforecastplace.viewmodel

import androidx.lifecycle.viewModelScope
import com.zywczas.commonutil.BaseViewModel
import com.zywczas.commonutil.Resource
import com.zywczas.commonutil.StringProvider
import com.zywczas.commonutil.logD
import com.zywczas.networkforecast.usecase.GetPlaceForecastUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlaceForecastViewModel(
    private val stringProvider: StringProvider,
    private val getPlaceForecastUseCase: GetPlaceForecastUseCase,
) : BaseViewModel() {


    fun init() {
        viewModelScope.launch(Dispatchers.IO) {
            getForecast()
        }
    }

    private suspend fun getForecast() {
        when (val response = getPlaceForecastUseCase.get()) {
            is Resource.Success -> logD(response.data.toDomain().toString())
            is Resource.Error -> showError(stringProvider.getString(response.message))
        }
    }
}
