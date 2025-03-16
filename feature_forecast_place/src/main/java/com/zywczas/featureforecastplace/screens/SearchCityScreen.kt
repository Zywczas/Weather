package com.zywczas.featureforecastplace.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.zywczas.commoncompose.components.LocationListItem
import com.zywczas.commoncompose.components.OutlinedTextInput
import com.zywczas.commoncompose.components.Snackbar
import com.zywczas.commoncompose.components.Toolbar
import com.zywczas.commoncompose.theme.PreviewTheme
import com.zywczas.commoncompose.theme.Spacing
import com.zywczas.commonutil.R
import com.zywczas.featureforecastplace.domain.Location
import com.zywczas.featureforecastplace.viewmodel.SearchLocationViewModel
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.koinViewModel

@Composable
fun SearchLocationScreen(
    onCityClick: (PlaceForecastArgs) -> Unit,
) {
    val viewModel: SearchLocationViewModel = koinViewModel()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) { viewModel.init() }

    SearchLocationScreen(
        locations = viewModel.locations,
        onCityClick = onCityClick,
        searchText = viewModel.searchText,
        onSearchTextChanged = viewModel::onSearchTextChanged
    )

    Snackbar(snackbarHostState)

    LaunchedEffect(Unit) {
        viewModel.announcement.collectLatest { text ->
            snackbarHostState.showSnackbar(text)
        }
    }
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

        Row(Modifier.padding(horizontal = Spacing.m)) {
            OutlinedTextInput(value = searchText, onValueChange = onSearchTextChanged)
        }

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
