package com.zywczas.featureforecastplace.viewmodel

import com.zywczas.commoncompose.components.KeyValueViewEntity
import com.zywczas.commonutil.WeatherCondition

internal data class PlaceForecastViewEntity(
    val toolbarTitle: String = "",
    val keyValueItems: List<KeyValueViewEntity> = emptyList(),
    val weatherCondition: WeatherCondition? = null,
)
