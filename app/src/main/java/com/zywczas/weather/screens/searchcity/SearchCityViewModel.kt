package com.zywczas.weather.screens.searchcity

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.zywczas.weather.models.City

class SearchCityViewModel : ViewModel() {

    private val mockedCities = listOf(
        City(id = 67, name = "Bydgoszcz"),
        City(id = 2, name = "Warszawa"),
        City(id = 3, name = "Kraków"),
        City(id = 4, name = "Gdańsk"),
        City(id = 5, name = "Poznań"),
        City(id = 6, name = "Wrocław"),
        City(id = 7, name = "Zakopane"),
        City(id = 8, name = "Karpacz"),
    )

    var cities by mutableStateOf<List<City>>(mockedCities)
        private set

    fun init() {
        loadCities()
    }

    private fun loadCities() {
        cities = mockedCities2
    }

    private val mockedCities2 = listOf(
        City(id = 3, name = "Rzeszów"),
        City(id = 5, name = "Katowice"),
    )
}
