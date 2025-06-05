package com.zywczas.featureforecastplace.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.zywczas.commonutils.BaseViewModel
import com.zywczas.commonutils.Resource
import com.zywczas.featureforecastplace.domain.toDomain
import com.zywczas.featureforecastplace.screens.SelectedLocation
import com.zywczas.networkforecast.params.PlaceForecastParams
import com.zywczas.networkforecast.usecase.GetPlaceForecastUseCase
import com.zywczas.storehistory.entity.LocationLocal
import com.zywczas.storehistory.usecase.SaveLocationUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.getString

internal class PlaceForecastViewModel(
    private val getPlaceForecastUseCase: GetPlaceForecastUseCase,
    private val saveLocationsUseCase: SaveLocationUseCase
) : BaseViewModel() {

    var placeForecastViewEntity by mutableStateOf(PlaceForecastViewEntity())
        private set

    var hourlyForecastViewEntity by mutableStateOf<List<HourlyForecastViewEntity>>(emptyList())
        private set

    fun init(location: SelectedLocation) {
        viewModelScope.launch(Dispatchers.IO) {
            getForecast(location)
        }
        viewModelScope.launch(Dispatchers.IO) {
            saveSearchLocation(location)
        }
    }

    private suspend fun getForecast(args: SelectedLocation) {
        when (val response = getPlaceForecastUseCase.get(PlaceForecastParams(lat = args.lat, lon = args.lon))) {
            is Resource.Success -> {
                placeForecastViewEntity = response.data.current.toDomain(toolbarTitle = args.name)
                hourlyForecastViewEntity = response.data.hourly.map { it.toDomain() }
            }
            is Resource.Error -> showError(getString(response.message))
        }
    }

    private suspend fun saveSearchLocation(args: SelectedLocation) {
        saveLocationsUseCase.save(
            LocationLocal(
                name = args.name,
                lat = args.lat,
                lon = args.lon
            )
        )
    }
}
