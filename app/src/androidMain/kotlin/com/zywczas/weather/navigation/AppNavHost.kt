package com.zywczas.weather.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.zywczas.featureforecastplace.screens.PlaceForecastScreen
import com.zywczas.featureforecastplace.screens.SearchLocationScreen
import com.zywczas.featureforecastplace.screens.SelectedLocation

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Destination.SearchCity) {

        composable<Destination.SearchCity> {
            SearchLocationScreen(
                onLocationClick = { location ->
                    navController.navigate(Destination.PlaceForecast(lat = location.lat, lon = location.lon, placeName = location.name))
                }
            )
        }

        composable<Destination.PlaceForecast> { backStackEntry ->
            val route: Destination.PlaceForecast = backStackEntry.toRoute()
            PlaceForecastScreen(
                location = SelectedLocation(lat = route.lat, lon = route.lon, name = route.placeName),
                goBackAction = { navController.navigateUp() },
            )
        }
    }
}
