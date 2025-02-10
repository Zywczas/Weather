package com.zywczas.featureforecastplace.screens

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.zywczas.commoncompose.components.LocationListItem
import com.zywczas.commoncompose.components.OutlinedTextInput
import com.zywczas.commoncompose.components.Toolbar
import com.zywczas.commoncompose.theme.PreviewTheme
import com.zywczas.commoncompose.theme.Spacing
import com.zywczas.commonutil.R
import com.zywczas.commonutil.RegexExps
import com.zywczas.featureforecastplace.viewmodel.SearchLocationViewModel
import com.zywczas.networkplaces.domain.Location
import org.koin.androidx.compose.koinViewModel

@Composable
fun SearchLocationScreen(
    onCityClick: (PlaceForecastArgs) -> Unit,
) {
    val viewModel: SearchLocationViewModel = koinViewModel()

    LaunchedEffect(Unit) { viewModel.init() }

    SearchLocationScreen(
        locations = viewModel.locations,
        onCityClick = onCityClick,
        searchText = viewModel.searchText,
        onSearchTextChanged = viewModel::onSearchTextChanged
    )
}

@Composable
private fun SearchLocationScreen(
    locations: List<Location>,
    onCityClick: (PlaceForecastArgs) -> Unit,
    searchText: TextFieldValue,
    onSearchTextChanged: (TextFieldValue) -> Unit
) {
    Column {
        Toolbar(stringResource(R.string.search_city_screen))

        OutlinedTextInput(
            value = searchText,
            onValueChange = onSearchTextChanged,
            modifier = Modifier.padding(horizontal = Spacing.m),
            regexFilter = RegexExps.INPUT_CITY_TYPING
        )

        Spacer(Modifier.height(Spacing.l))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(Spacing.xxs)
        ) {
            items(locations) { location ->
                LocationListItem(
                    location.name,
                    onClick = { onCityClick(PlaceForecastArgs(lat = location.lat, lon = location.lon, placeName = location.name)) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSearchCityScreen() {
    PreviewTheme {
        SearchLocationScreen(
            locations = listOf(
                Location(name = "Bydgoszcz"),
                Location(name = "Warszawa"),
                Location(name = "Kraków"),
                Location(name = "Gdańsk"),
                Location(name = "Poznań"),
                Location(name = "Wrocław"),
                Location(name = "Zakopane"),
                Location(name = "Karpacz"),
            ),
            onCityClick = {},
            searchText = TextFieldValue("Warszawa"),
            onSearchTextChanged = {}
        )
    }
}
