package com.zywczas.featureforecastplace.viewmodel

import com.zywczas.commoncompose.components.KeyValueViewEntity

internal data class PlaceForecastViewEntity(
    val toolbarTitle: String = "",
    val keyValueItems: List<KeyValueViewEntity> = emptyList()
)
