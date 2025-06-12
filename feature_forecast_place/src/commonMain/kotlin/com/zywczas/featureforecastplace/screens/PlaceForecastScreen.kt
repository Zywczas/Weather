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
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
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
import com.zywczas.commoncompose.theme.Color
import com.zywczas.commoncompose.theme.Spacing
import com.zywczas.commoncompose.theme.Theme
import com.zywczas.commonutils.OnClick
import com.zywczas.commonutils.weather.TemperatureColor
import com.zywczas.commonutils.weather.WeatherCondition
import com.zywczas.featureforecastplace.viewmodel.HourlyForecastViewEntity
import com.zywczas.featureforecastplace.viewmodel.PlaceForecastViewEntity
import com.zywczas.featureforecastplace.viewmodel.PlaceForecastViewModel
import com.zywczas.weather.resources.commonutils.Res
import com.zywczas.weather.resources.commonutils.close
import com.zywczas.weather.resources.commonutils.content_description_precipitation_probability
import com.zywczas.weather.resources.commonutils.ic_rain_drop
import com.zywczas.weather.resources.commonutils.next_hours_title
import kotlinx.coroutines.flow.collectLatest
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun PlaceForecastScreen(location: SelectedLocation, goBackAction: OnClick) {

    val viewModel: PlaceForecastViewModel = koinViewModel()
    val snackbarHostState = remember { SnackbarHostState() }
    var showHourlyForecast by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) { viewModel.init(location) }

    PlaceForecastScreen(
        viewEntity = viewModel.placeForecastViewEntity,
        goBackAction = goBackAction,
        onShowHourlyForecastClick = { showHourlyForecast = true }
    )

    if (showHourlyForecast) {
        HourlyForecast(
            viewEntity = viewModel.hourlyForecastViewEntity,
            closeAction = { showHourlyForecast = false }
        )
    }

    Snackbar(snackbarHostState, withBottomBarInsetSpacer = true)

    LaunchedEffect(Unit) {
        viewModel.announcement.collectLatest { text ->
            snackbarHostState.showSnackbar(text)
        }
    }
}

@Composable
private fun PlaceForecastScreen(
    viewEntity: PlaceForecastViewEntity,
    goBackAction: OnClick,
    onShowHourlyForecastClick: OnClick
) {
    Column {
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
            text = stringResource(Res.string.next_hours_title),
            modifier = Modifier
                .padding(horizontal = Spacing.screenBorder)
                .fillMaxWidth(),
            onClick = onShowHourlyForecastClick
        )

        Spacer(Modifier.height(Spacing.screenBorder))

        BottomBarInsetSpacer()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HourlyForecast(
    viewEntity: List<HourlyForecastViewEntity>,
    closeAction: OnClick,
) {
    ModalBottomSheet(
        onDismissRequest = closeAction,
        content = {
            Column {
                LazyRow(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    item {
                        Spacer(Modifier.width(Spacing.screenBorder))
                    }

                    itemsIndexed(
                        items = viewEntity,
                        key = { index, item -> item.hashCode() }
                    ) { index, item ->
                        HourlyListItem(item)

                        if (index < viewEntity.lastIndex) {
                            VerticalListItemDivider(Modifier.height(120.dp))
                        }
                    }

                    item {
                        Spacer(Modifier.width(Spacing.screenBorder))
                    }
                }

                PrimaryButton(
                    text = stringResource(Res.string.close),
                    onClick = closeAction,
                    modifier = Modifier
                        .padding(Spacing.screenBorder)
                        .fillMaxWidth()
                )
            }
        }
    )
}

@Composable
private fun HourlyListItem(viewEntity: HourlyForecastViewEntity) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 8.dp),
    ) {
        Text(viewEntity.hour)

        Spacer(Modifier.height(Spacing.listItemVerticalOuter))

        SmallIcon(
            icon = viewEntity.weatherCondition.icon,
            contentDescription = viewEntity.weatherCondition.contentDescription
        )

        Spacer(Modifier.height(Spacing.listItemVerticalInner))

        Text(viewEntity.temperature)

        Spacer(Modifier.height(Spacing.listItemVerticalOuter))

        SmallIcon(
            icon = Res.drawable.ic_rain_drop,
            contentDescription = Res.string.content_description_precipitation_probability,
            tint = if (viewEntity.isPrecipitationProbabilityLow) Color.FunctionDisabledLight else Color.Weather.LightCloud
        )

        Spacer(Modifier.height(Spacing.listItemVerticalInner))

        Text(viewEntity.precipitationProbability)
    }
}

@Preview
@Composable
private fun PreviewPlaceForecastScreen() {
    Theme.Preview {
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
            goBackAction = {},
            onShowHourlyForecastClick = {}
        )
    }
}

@Preview
@Composable
private fun PreviewHourlyListItem() {
    Theme.Preview {
        HourlyListItem(
            viewEntity = HourlyForecastViewEntity(
                hour = AnnotatedString("1400"),
                weatherCondition = WeatherCondition.Clear,
                temperature = "7°",
                precipitationProbability = "7%",
                isPrecipitationProbabilityLow = false
            )
        )
    }
}
