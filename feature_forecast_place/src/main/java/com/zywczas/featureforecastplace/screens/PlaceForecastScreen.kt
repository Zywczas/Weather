package com.zywczas.featureforecastplace.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.zywczas.commoncompose.components.Toolbar
import com.zywczas.featureforecastplace.viewmodel.PlaceForecastViewEntity
import com.zywczas.featureforecastplace.viewmodel.PlaceForecastViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun PlaceForecastScreen(args: PlaceForecastArgs) {

    val viewModel: PlaceForecastViewModel = koinViewModel()

    LaunchedEffect(Unit) { viewModel.init(args) }

    CityWeatherDetailsScreen(
        toolbarTitle = args.placeName,
        viewEntity = viewModel.viewEntity
    )
}

@Composable
private fun CityWeatherDetailsScreen(
    toolbarTitle: String,//todo move to view entity
    viewEntity: PlaceForecastViewEntity,
) {
    Column {
        Toolbar(toolbarTitle)
        Text(toolbarTitle)

    }
}
