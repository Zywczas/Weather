package com.zywczas.featureforecastplace.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.zywczas.commonutil.BaseViewModel

internal class SearchCityViewModel : BaseViewModel() {

    var searchText by mutableStateOf("")
        private set

    var cities by mutableStateOf<List<City>>(emptyList())
        private set

    fun init() {
        cities = listOf(City(name = "Bydgoszcz", lat = 52.2297, lon = 21.0122))
    }

    fun onSearchTextChanged(text: String) {
        searchText = text
    }
}
