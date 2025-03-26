package com.zywczas.featureforecastplace.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.zywczas.commoncompose.components.HorizontalListItemDivider
import com.zywczas.commoncompose.components.ListHeader
import com.zywczas.commoncompose.components.LocationListItem
import com.zywczas.commoncompose.components.OutlinedTextInput
import com.zywczas.commoncompose.components.Snackbar
import com.zywczas.commoncompose.components.Toolbar
import com.zywczas.commoncompose.theme.PreviewTheme
import com.zywczas.commoncompose.theme.Spacing
import com.zywczas.commonutil.R
import com.zywczas.featureforecastplace.domain.SearchListItem
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
    locations: List<SearchListItem>,
    onCityClick: (PlaceForecastArgs) -> Unit,
    searchText: TextFieldValue,
    onSearchTextChanged: (TextFieldValue) -> Unit
) {
    Column {
        Toolbar(stringResource(R.string.search_city_screen))

        Row(Modifier.padding(horizontal = Spacing.screenBorder)) {
            OutlinedTextInput(value = searchText, onValueChange = onSearchTextChanged)
        }

        Spacer(Modifier.height(Spacing.screenComponentsVertical))

        LazyColumn {
            itemsIndexed(locations) { index, location ->
                when (location) {
                    is SearchListItem.Header -> ListHeader(location.text)
                    is SearchListItem.Location -> {
                        LocationListItem(
                            location.name,
                            onClick = { onCityClick(PlaceForecastArgs(lat = location.lat, lon = location.lon, placeName = location.name)) }
                        )
                        if (index < locations.lastIndex) {
                            HorizontalListItemDivider()
                        }
                    }
                }
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
                SearchListItem.Header("Recent searches"),
                SearchListItem.Location(name = "Bydgoszcz"),
                SearchListItem.Location(name = "Warszawa"),
                SearchListItem.Location(name = "Kraków"),
                SearchListItem.Location(name = "Gdańsk"),
                SearchListItem.Location(name = "Poznań"),
                SearchListItem.Location(name = "Wrocław"),
                SearchListItem.Location(name = "Zakopane"),
                SearchListItem.Location(name = "Karpacz"),
            ),
            onCityClick = {},
            searchText = TextFieldValue("Warszawa"),
            onSearchTextChanged = {}
        )
    }
}
