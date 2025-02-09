package com.zywczas.featureforecastplace.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.zywczas.commoncompose.components.CityListItem
import com.zywczas.commoncompose.components.OutlinedTextInput
import com.zywczas.commoncompose.components.Toolbar
import com.zywczas.commoncompose.theme.PreviewTheme
import com.zywczas.commoncompose.theme.Spacing
import com.zywczas.commonutil.R
import com.zywczas.commonutil.RegexExps
import com.zywczas.featureforecastplace.viewmodel.City
import com.zywczas.featureforecastplace.viewmodel.SearchCityViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun SearchCityScreen(
    onCityClick: (PlaceForecastArgs) -> Unit,
) {
    val viewModel: SearchCityViewModel = koinViewModel()

    LaunchedEffect(Unit) { viewModel.init() }

    SearchCityScreen(
        cities = viewModel.cities,
        onCityClick = onCityClick,
        searchText = viewModel.searchText,
        onSearchTextChanged = viewModel::onSearchTextChanged
    )
}

@Composable
private fun SearchCityScreen(
    cities: List<City>,
    onCityClick: (PlaceForecastArgs) -> Unit,
    searchText: String,
    onSearchTextChanged: (String) -> Unit
) {
    Column {
        Toolbar(stringResource(R.string.search_city_screen))

        OutlinedTextInput(
            value = searchText,
            onValueChange = onSearchTextChanged,
            modifier = Modifier.padding(horizontal = Spacing.m),
            regexFilter = RegexExps.INPUT_CITY_TYPING
        )

        Spacer(Modifier.height(Spacing.s))

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

@Preview(showBackground = true)
@Composable
private fun PreviewSearchCityScreen() {
    PreviewTheme {
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
            searchText = "Warszawa",
            onSearchTextChanged = {}
        )
    }
}
