package com.zywczas.weather.screens.searchcity

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.zywczas.commonutil.BaseViewModel
import com.zywczas.weather.models.City

class SearchCityViewModel : BaseViewModel() {

    var cities by mutableStateOf<List<City>>(emptyList())
        private set

    fun init() {
        cities = listOf(City(name = "Bydgoszcz"))
    }
}
