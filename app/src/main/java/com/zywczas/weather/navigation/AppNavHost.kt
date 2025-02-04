package com.zywczas.weather.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zywczas.weather.screens.CityWeatherDetailsScreen
import com.zywczas.weather.screens.SearchCityScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Destinations.SearchCity.name) {
        composable(Destinations.SearchCity.name) { SearchCityScreen() }
        composable(Destinations.CityWeatherDetails.name) { CityWeatherDetailsScreen() }
    }
}
