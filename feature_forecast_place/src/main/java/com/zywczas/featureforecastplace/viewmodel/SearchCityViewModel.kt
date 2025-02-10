package com.zywczas.featureforecastplace.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.zywczas.commonutil.BaseViewModel
import com.zywczas.commonutil.Resource
import com.zywczas.commonutil.StringProvider
import com.zywczas.commonutil.logD
import com.zywczas.networkplaces.params.LocationsParams
import com.zywczas.networkplaces.usecase.GetLocationsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

internal class SearchCityViewModel(
    private val stringProvider: StringProvider,
    private val getLocationsUseCase: GetLocationsUseCase
) : BaseViewModel() {

    var searchText by mutableStateOf("")
        private set

    var cities by mutableStateOf<List<City>>(emptyList())
        private set

    fun init() {
        cities = listOf(City(name = "Bydgoszcz", lat = 52.2297, lon = 21.0122))
        viewModelScope.launch(Dispatchers.IO) {
            getPlaces()
        }
    }

    fun onSearchTextChanged(text: String) {
        searchText = text
    }

    private suspend fun getPlaces() {
        when (val result = getLocationsUseCase.get(LocationsParams(placeName = "Warszawa"))) {
            is Resource.Success -> logD(result.data)
            is Resource.Error -> showError(stringProvider.getString(result.message))
        }
    }
}
