package com.zywczas.weather.screens.searchcity

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.zywczas.weather.R
import com.zywczas.weather.models.City
import com.zywczas.weather.uicomponents.CityListItem
import com.zywczas.weather.uicomponents.Toolbar
import org.koin.androidx.compose.koinViewModel

@Composable
fun SearchCityScreen(
    onCityClick: () -> Unit,
    viewModel: SearchCityViewModel = koinViewModel()
) {
    LaunchedEffect(Unit) { viewModel.init() }

    SearchCityScreen(
        cities = viewModel.cities,
        onCityClick = onCityClick,
        timeZone = viewModel.timeZone
    )
}

@Composable
private fun SearchCityScreen(
    cities: List<City>,
    onCityClick: () -> Unit,
    timeZone: String,
) {
    Column {
        Toolbar(stringResource(R.string.search_city_screen))
        Text(timeZone)
        LazyColumn {
            items(cities) { city ->
                CityListItem(city, onClick = onCityClick)
            }
        }
    }
}

@Preview
@Composable
private fun PreviewSearchCityScreen() {
    SearchCityScreen(
        cities = listOf(
            City(id = 1, name = "Bydgoszcz"),
            City(id = 2, name = "Warszawa"),
            City(id = 3, name = "Kraków"),
            City(id = 4, name = "Gdańsk"),
            City(id = 5, name = "Poznań"),
            City(id = 6, name = "Wrocław"),
            City(id = 7, name = "Zakopane"),
            City(id = 8, name = "Karpacz"),
        ),
        onCityClick = {},
        timeZone = "Warsaw"
    )
}
