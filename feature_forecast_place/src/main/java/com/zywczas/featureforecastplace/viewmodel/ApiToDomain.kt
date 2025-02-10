package com.zywczas.featureforecastplace.viewmodel

import androidx.compose.ui.text.style.TextAlign
import com.zywczas.commoncompose.components.KeyValueViewEntity
import com.zywczas.commoncompose.theme.TemperatureColor
import com.zywczas.commonutil.R
import com.zywczas.commonutil.StringProvider
import com.zywczas.featureforecastplace.domain.Location
import com.zywczas.networkforecast.response.PlaceForecastResponse
import com.zywczas.networkplaces.response.LocationResponse
import com.zywczas.storehistory.entity.LocationLocal

internal fun PlaceForecastResponse.toDomain(
    toolbarTitle: String,
    stringProvider: StringProvider
): PlaceForecastViewEntity {
    val textAlign = TextAlign.Center
    return PlaceForecastViewEntity(
        toolbarTitle = toolbarTitle,
        keyValueItems = listOfNotNull(
            KeyValueViewEntity(
                textAlign = textAlign,
                key = stringProvider.getString(R.string.temperature_title),
                value = stringProvider.getString(R.string.temperature_value, current.temperature),
                valueTextColor = TemperatureColor.get(current.temperature).value,
            ),
            KeyValueViewEntity(
                textAlign = textAlign,
                key = stringProvider.getString(R.string.cloud_cover_title),
                value = stringProvider.getString(R.string.cloud_cover_value, current.cloudsPercentage),
            ),
            current.rain?.let { rain ->
                KeyValueViewEntity(
                    textAlign = textAlign,
                    key = stringProvider.getString(R.string.precipitation_title),
                    value = stringProvider.getString(R.string.precipitation_value, rain.mmPerHour)
                )
            },
            KeyValueViewEntity(
                textAlign = textAlign,
                key = stringProvider.getString(R.string.humidity_title),
                value = stringProvider.getString(R.string.humidity_value, current.humidityPercentage)
            ),
        )
    )
}

internal fun LocationResponse.toDomain() = Location(
    name = "$name, $state, $country",
    lat = lat,
    lon = lon,
)

internal fun LocationLocal.toDomain() = Location(
    name = name,
    lat = lat,
    lon = lon,
)
