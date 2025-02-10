package com.zywczas.weather.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zywczas.featureforecastplace.screens.PlaceForecastScreen
import com.zywczas.featureforecastplace.screens.SearchLocationScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = DestinationSearchCity.route) {

        composable(DestinationSearchCity.route) {
            SearchLocationScreen(
                onCityClick = { navArgs ->
                    navController.navigate(DestinationPlaceForecast.getDestinationWithArgs(navArgs))
                }
            )
        }

        DestinationPlaceForecast.composableWithArgs(this) { _, args ->
            PlaceForecastScreen(args = args)
        }
    }
}
