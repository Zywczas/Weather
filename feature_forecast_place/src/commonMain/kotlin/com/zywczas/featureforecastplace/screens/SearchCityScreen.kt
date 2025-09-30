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
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import com.zywczas.commoncompose.components.BottomBarInsetSpacer
import com.zywczas.commoncompose.components.HorizontalListItemDivider
import com.zywczas.commoncompose.components.ListHeader
import com.zywczas.commoncompose.components.LocationListItem
import com.zywczas.commoncompose.components.OutlinedTextInput
import com.zywczas.commoncompose.components.Snackbar
import com.zywczas.commoncompose.components.Toolbar
import com.zywczas.commoncompose.theme.Spacing
import com.zywczas.commoncompose.theme.Theme
import com.zywczas.commonutils.RegexExps
import com.zywczas.featureforecastplace.domain.SearchListItem
import com.zywczas.featureforecastplace.viewmodel.SearchLocationViewModel
import com.zywczas.weather.resources.commonutils.Res
import com.zywczas.weather.resources.commonutils.search_city_screen
import kotlinx.coroutines.flow.collectLatest
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SearchLocationScreen(onLocationClick: (SelectedLocation) -> Unit) {

    val viewModel: SearchLocationViewModel = koinViewModel()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) { viewModel.init() }

    var searchText by rememberSaveable { mutableStateOf("") }
    var searchTextSelectionEnd by rememberSaveable { mutableStateOf(0) }
    val textFieldValue by derivedStateOf { TextFieldValue(searchText, TextRange(searchTextSelectionEnd)) }

    val onSearchTextChanged: (TextFieldValue) -> Unit = { textFieldValue ->
        if (CITY_NAME_PATTERN.matches(textFieldValue.text)) {
            searchText = textFieldValue.text
            searchTextSelectionEnd = textFieldValue.selection.end
            viewModel.onSearchTextChanged(textFieldValue.text)
        }
    }

    SearchLocationScreen(
        locations = viewModel.locations,
        onLocationClick = onLocationClick,
        searchText = textFieldValue,
        onSearchTextChanged = onSearchTextChanged
    )

    Snackbar(snackbarHostState, withBottomBarInsetSpacer = true)

    LaunchedEffect(Unit) {
        viewModel.announcement.collectLatest { text ->
            snackbarHostState.showSnackbar(text)
        }
    }
}

@Composable
private fun SearchLocationScreen(
    locations: List<SearchListItem>,
    onLocationClick: (SelectedLocation) -> Unit,
    searchText: TextFieldValue,
    onSearchTextChanged: (TextFieldValue) -> Unit
) {
    Column {
        Toolbar(stringResource(Res.string.search_city_screen))

        Row(Modifier.padding(horizontal = Spacing.screenBorder)) {
            OutlinedTextInput(value = searchText, onValueChange = onSearchTextChanged)
        }

        Spacer(Modifier.height(Spacing.screenComponentsVertical))

        LazyColumn {
            itemsIndexed(
                items = locations,
                key = { index, item -> item.hashCode() }
            ) { index, location ->
                when (location) {
                    is SearchListItem.Header -> ListHeader(location.text)
                    is SearchListItem.Location -> {
                        LocationListItem(
                            location.name,
                            onClick = { onLocationClick(SelectedLocation(lat = location.lat, lon = location.lon, name = location.name)) }
                        )
                        if (index < locations.lastIndex) {
                            HorizontalListItemDivider()
                        }
                    }
                }
            }

            item {
                BottomBarInsetSpacer()
            }
        }
    }
}

@Preview
@Composable
private fun PreviewSearchCityScreen() {
    Theme.Preview {
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
            onLocationClick = {},
            searchText = TextFieldValue("Warszawa"),
            onSearchTextChanged = {}
        )
    }
}

private val CITY_NAME_PATTERN = Regex(RegexExps.INPUT_CITY_TYPING)
