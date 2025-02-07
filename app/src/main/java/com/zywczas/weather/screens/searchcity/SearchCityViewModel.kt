package com.zywczas.weather.screens.searchcity

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.zywczas.common_utils.StringProvider
import com.zywczas.network_forecast.usecase.GetPlaceForecastUseCase
import com.zywczas.networkcaller.Resource
import com.zywczas.weather.BaseViewModel
import com.zywczas.weather.models.City
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchCityViewModel(
    private val stringProvider: StringProvider,
    private val getPlaceForecastUseCase: GetPlaceForecastUseCase
) : BaseViewModel() {

    var cities by mutableStateOf<List<City>>(emptyList())
        private set
    var timeZone by mutableStateOf("")
        private set

    fun init() {
        viewModelScope.launch(Dispatchers.IO) {
            getForecast()
        }
    }

    private suspend fun getForecast() {
        when (val response = getPlaceForecastUseCase.get()) {
            is Resource.Success -> timeZone = response.data.timezone
            is Resource.Error -> showError(stringProvider.getString(response.message))
        }
    }
}
