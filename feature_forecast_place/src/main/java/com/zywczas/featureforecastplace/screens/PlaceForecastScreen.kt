package com.zywczas.featureforecastplace.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zywczas.commoncompose.components.BottomBarInsetSpacer
import com.zywczas.commoncompose.components.KeyValue
import com.zywczas.commoncompose.components.KeyValueViewEntity
import com.zywczas.commoncompose.components.LargeIcon
import com.zywczas.commoncompose.components.SmallIcon
import com.zywczas.commoncompose.components.Snackbar
import com.zywczas.commoncompose.components.Toolbar
import com.zywczas.commoncompose.components.VerticalListItemDivider
import com.zywczas.commoncompose.components.buttons.PrimaryButton
import com.zywczas.commoncompose.theme.PreviewTheme
import com.zywczas.commoncompose.theme.Spacing
import com.zywczas.commonutil.R
import com.zywczas.commonutil.weather.TemperatureColor
import com.zywczas.commonutil.weather.WeatherCondition
import com.zywczas.featureforecastplace.viewmodel.PlaceForecastViewEntity
import com.zywczas.featureforecastplace.viewmodel.PlaceForecastViewModel
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.koinViewModel

@Composable
fun PlaceForecastScreen(args: PlaceForecastArgs, goBackAction: () -> Unit) {

    val viewModel: PlaceForecastViewModel = koinViewModel()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) { viewModel.init(args) }

    PlaceForecastScreen(
        viewEntity = viewModel.viewEntity,
        goBackAction = goBackAction
    )

    Snackbar(snackbarHostState)

    LaunchedEffect(Unit) {
        viewModel.announcement.collectLatest { text ->
            snackbarHostState.showSnackbar(text)
        }
    }
}

@Composable
private fun PlaceForecastScreen(viewEntity: PlaceForecastViewEntity, goBackAction: () -> Unit) {
    Column {
        var showHourlyForecast by remember { mutableStateOf(false) }

        Toolbar(
            title = viewEntity.toolbarTitle,
            onBackClick = goBackAction
        )

        Spacer(Modifier.height(Spacing.screenComponentsVertical))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            viewEntity.weatherCondition?.let {
                LargeIcon(
                    icon = it.icon,
                    contentDescription = it.contentDescription,
                )
                Spacer(Modifier.width(Spacing.screenComponentsVertical))
            }
            Text(
                text = viewEntity.temperatureText,
                color = viewEntity.temperatureColor,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(Modifier.height(Spacing.screenComponentsVertical))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(Spacing.listItemVerticalOuter),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            items(viewEntity.keyValueItems) { item ->
                KeyValue(item)
            }
        }

        Spacer(Modifier.weight(1f))

        Spacer(Modifier.height(Spacing.screenComponentsVertical))

        PrimaryButton(
            text = stringResource(R.string.next_hours_title),
            modifier = Modifier
                .padding(horizontal = Spacing.screenBorder)
                .fillMaxWidth(),
            onClick = { showHourlyForecast = true }
        )

        Spacer(Modifier.height(Spacing.screenBorder))

        BottomBarInsetSpacer()

        if (showHourlyForecast) {
            HourlyForecast(
                onDismissRequest = { showHourlyForecast = false }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HourlyForecast(
    onDismissRequest: () -> Unit,
) {
    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        content = {
            LazyRow(
                verticalAlignment = Alignment.CenterVertically
            ) {
                item {
                    Spacer(Modifier.width(Spacing.screenBorder))
                }
                val list = listOf("column1", "column2", "column3", "column4", "column5", "column6", "column7", "column8")
                itemsIndexed(list) { index, item ->
                    HourlyListItem()
                    if (index < list.lastIndex) {
                        VerticalListItemDivider(Modifier.height(120.dp))
                    }
                }
                item {
                    Spacer(Modifier.width(Spacing.screenBorder))
                }
            }
        }
    )
}

@Composable
private fun HourlyListItem() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 8.dp),
    ) {
        Text("1300")

        Spacer(Modifier.height(Spacing.listItemVerticalOuter))

        SmallIcon(
            icon = WeatherCondition.Clear.icon,
            contentDescription = WeatherCondition.Clear.contentDescription
        )

        Spacer(Modifier.height(Spacing.listItemVerticalInner))

        Text(
            text = "14°",
        )

        Spacer(Modifier.height(Spacing.listItemVerticalOuter))

        SmallIcon(
            icon = R.drawable.ic_rain_drop,
            contentDescription = R.string.content_description_precipitation_probability
        )

        Spacer(Modifier.height(Spacing.listItemVerticalInner))

        Text(
            text = "5%",
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewPlaceForecastScreen() {
    PreviewTheme {
        PlaceForecastScreen(
            viewEntity = PlaceForecastViewEntity(
                toolbarTitle = "Bydgoszcz",
                weatherCondition = WeatherCondition.Clear,
                temperatureColor = TemperatureColor.Hot.value,
                temperatureText = "35 °C",
                keyValueItems = listOf(
                    KeyValueViewEntity(
                        key = "Temperature",
                        value = "5 °C",
                    ),
                    KeyValueViewEntity(
                        key = "Temperature",
                        value = "15 °C",
                    ),
                    KeyValueViewEntity(
                        key = "Clouds",
                        value = "10 %",
                    )
                )
            ),
            goBackAction = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewHourlyForecast() {
    HourlyForecast(
        onDismissRequest = {}
    )
}
