package com.zywczas.featureforecastplace.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.zywczas.commoncompose.components.Toolbar
import com.zywczas.featureforecastplace.viewmodel.PlaceForecastViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun CityWeatherDetailsScreen(
    viewModel: PlaceForecastViewModel = koinViewModel()
) {
    LaunchedEffect(Unit) { viewModel.init() }

    CityWeatherDetailsScreen("add place")//todo add place
}

@Composable
private fun CityWeatherDetailsScreen(
    toolbarTitle: String,
) {
    Column {
        Toolbar(toolbarTitle)
        Text("CityWeatherDetailsScreen")

    }
}
