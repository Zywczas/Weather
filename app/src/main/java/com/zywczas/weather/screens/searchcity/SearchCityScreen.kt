package com.zywczas.weather.screens.searchcity

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.zywczas.commoncompose.components.CityListItem
import com.zywczas.commoncompose.components.Toolbar
import com.zywczas.featureforecastplace.screens.PlaceForecastArgs
import com.zywczas.weather.R
import com.zywczas.weather.models.City
import org.koin.androidx.compose.koinViewModel

@Composable
fun SearchCityScreen(
    onCityClick: (PlaceForecastArgs) -> Unit,
    viewModel: SearchCityViewModel = koinViewModel()
) {
    LaunchedEffect(Unit) { viewModel.init() }

    SearchCityScreen(
        cities = viewModel.cities,
        onCityClick = onCityClick,
    )
}

@Composable
private fun SearchCityScreen(
    cities: List<City>,
    onCityClick: (PlaceForecastArgs) -> Unit,
) {
    Column {
        Toolbar(stringResource(R.string.search_city_screen))
        LazyColumn {
            items(cities) { city ->
                CityListItem(
                    city.name,
                    onClick = { onCityClick(PlaceForecastArgs(lat = city.lat, lon = city.lon, placeName = city.name)) }
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewSearchCityScreen() {
    SearchCityScreen(
        cities = listOf(
            City(name = "Bydgoszcz"),
            City(name = "Warszawa"),
            City(name = "Kraków"),
            City(name = "Gdańsk"),
            City(name = "Poznań"),
            City(name = "Wrocław"),
            City(name = "Zakopane"),
            City(name = "Karpacz"),
        ),
        onCityClick = {},
    )
}
