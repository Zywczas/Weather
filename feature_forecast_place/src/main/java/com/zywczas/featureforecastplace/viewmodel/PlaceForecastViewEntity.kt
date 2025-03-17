package com.zywczas.featureforecastplace.viewmodel

import androidx.compose.ui.graphics.Color
import com.zywczas.commoncompose.components.KeyValueViewEntity
import com.zywczas.commoncompose.theme.TemperatureColor
import com.zywczas.commonutil.WeatherCondition

internal data class PlaceForecastViewEntity(
    val toolbarTitle: String = "",
    val keyValueItems: List<KeyValueViewEntity> = emptyList(),
    val weatherCondition: WeatherCondition? = null,
    val temperatureColor: Color = TemperatureColor.Neutral.value,
    val temperatureText: String = "",
)
