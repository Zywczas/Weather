package com.zywczas.featureforecastplace.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zywczas.commoncompose.components.KeyValue
import com.zywczas.commoncompose.components.KeyValueViewEntity
import com.zywczas.commoncompose.components.Snackbar
import com.zywczas.commoncompose.components.Toolbar
import com.zywczas.commoncompose.theme.PreviewTheme
import com.zywczas.commoncompose.theme.Spacing
import com.zywczas.commoncompose.theme.TemperatureColor
import com.zywczas.featureforecastplace.viewmodel.PlaceForecastViewEntity
import com.zywczas.featureforecastplace.viewmodel.PlaceForecastViewModel
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.koinViewModel

@Composable
fun PlaceForecastScreen(args: PlaceForecastArgs) {

    val viewModel: PlaceForecastViewModel = koinViewModel()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) { viewModel.init(args) }

    PlaceForecastScreen(
        viewEntity = viewModel.viewEntity
    )

    Snackbar(snackbarHostState)

    LaunchedEffect(Unit) {
        viewModel.announcement.collectLatest { text ->
            snackbarHostState.showSnackbar(text)
        }
    }
}

@Composable
private fun PlaceForecastScreen(
    viewEntity: PlaceForecastViewEntity,
) {
    Column {
        Toolbar(viewEntity.toolbarTitle)
        Spacer(Modifier.height(Spacing.l))
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(Spacing.s)
        ) {
            items(viewEntity.keyValueItems) { item ->
                KeyValue(item)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewPlaceForecastScreen() {
    PreviewTheme {
        PlaceForecastScreen(
            viewEntity = PlaceForecastViewEntity(
                toolbarTitle = "Bydgoszcz",
                keyValueItems = listOf(
                    KeyValueViewEntity(
                        key = "Temperature",
                        value = "35 °C",
                        valueTextColor = TemperatureColor.Hot.value
                    ),
                    KeyValueViewEntity(
                        key = "Temperature",
                        value = "5 °C",
                        valueTextColor = TemperatureColor.Cold.value
                    ),
                    KeyValueViewEntity(
                        key = "Temperature",
                        value = "15 °C",
                        valueTextColor = TemperatureColor.Neutral.value
                    ),
                    KeyValueViewEntity(
                        key = "Clouds",
                        value = "10 %",
                    )
                )
            )
        )
    }
}
