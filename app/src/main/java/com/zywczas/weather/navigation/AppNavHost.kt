package com.zywczas.weather.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zywczas.weather.screens.cityweatherdetails.CityWeatherDetailsScreen
import com.zywczas.weather.screens.searchcity.SearchCityScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Destinations.SearchCity.name) {
        composable(Destinations.SearchCity.name) {
            SearchCityScreen(
                onCityClick = { navController.navigate(Destinations.CityWeatherDetails.name) }
            )
        }
        composable(Destinations.CityWeatherDetails.name) { CityWeatherDetailsScreen() }
    }
}
