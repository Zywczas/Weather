package com.zywczas.featureforecastplace.viewmodel

import com.zywczas.commoncompose.components.KeyValueViewEntity
import com.zywczas.commonutil.R
import com.zywczas.commonutil.StringProvider
import com.zywczas.commonutil.UnitsConverter
import com.zywczas.commonutil.extensions.roundTo1DecimalPlace
import com.zywczas.commonutil.weather.TemperatureColor
import com.zywczas.commonutil.weather.TemperatureColor.Cold
import com.zywczas.commonutil.weather.TemperatureColor.Hot
import com.zywczas.commonutil.weather.TemperatureColor.Neutral
import com.zywczas.commonutil.weather.WeatherCondition
import com.zywczas.featureforecastplace.domain.SearchListItem
import com.zywczas.networkforecast.response.PlaceForecastResponse
import com.zywczas.networkforecast.response.WeatherResponse
import com.zywczas.networkplaces.response.LocationResponse
import com.zywczas.storehistory.entity.LocationLocal

internal fun PlaceForecastResponse.toDomain(
    toolbarTitle: String,
    stringProvider: StringProvider
): PlaceForecastViewEntity {
    return PlaceForecastViewEntity(
        toolbarTitle = toolbarTitle,
        weatherCondition = current.weather.firstOrNull()?.toDomain(cloudsPercentage = current.cloudsPercentage),
        temperatureColor = getTemperatureColor(current.temperature).value,
        temperatureText = stringProvider.getString(R.string.temperature_value, current.temperature.roundTo1DecimalPlace()),
        keyValueItems = listOfNotNull(
            KeyValueViewEntity(
                key = stringProvider.getString(R.string.cloud_cover_title),
                value = stringProvider.getString(R.string.cloud_cover_value, current.cloudsPercentage),
            ),
            current.rain?.let { rain ->
                KeyValueViewEntity(
                    key = stringProvider.getString(R.string.precipitation_title),
                    value = stringProvider.getString(R.string.precipitation_value, rain.mmPerHour)
                )
            },
            KeyValueViewEntity(
                key = stringProvider.getString(R.string.humidity_title),
                value = stringProvider.getString(R.string.humidity_value, current.humidityPercentage)
            ),
            KeyValueViewEntity(
                key = stringProvider.getString(R.string.pressure_title),
                value = stringProvider.getString(R.string.pressure_value, current.pressure)
            ),
            KeyValueViewEntity(
                key = stringProvider.getString(R.string.visibility_title),
                value = stringProvider.getString(R.string.visibility_value, current.visibility)
            ),
            KeyValueViewEntity(
                key = stringProvider.getString(R.string.wind_speed_title),
                value = stringProvider.getString(R.string.wind_speed_value, UnitsConverter.mPerSecToKmPerH(current.windSpeed).roundTo1DecimalPlace())
            ),
        ),
    )
}

internal fun LocationResponse.toDomain() = SearchListItem.Location(
    name = state?.let { state ->
        "$name, $state, $country"
    } ?: "$name, $country",
    lat = lat,
    lon = lon,
)

internal fun LocationLocal.toDomain() = SearchListItem.Location(
    name = name,
    lat = lat,
    lon = lon,
)

private fun WeatherResponse.toDomain(cloudsPercentage: Int): WeatherCondition? = when (condition) {
    "Clear" -> WeatherCondition.Clear
    "Clouds" -> if (cloudsPercentage < PARTIAL_CLOUDS_MAX_PERCENTAGE) WeatherCondition.PartialClouds else WeatherCondition.Clouds
    "Rain" -> WeatherCondition.Rain
    "Snow" -> WeatherCondition.Snow
    "Atmosphere" -> WeatherCondition.Atmosphere
    "Drizzle" -> WeatherCondition.Drizzle
    "Thunderstorm" -> WeatherCondition.Thunderstorm
    else -> null
}

private fun getTemperatureColor(temp: Double): TemperatureColor = when {
    temp < MIN_NEUTRAL_TEMP -> Cold
    temp > MAX_NEUTRAL_TEMP -> Hot
    else -> Neutral
}

private const val MIN_NEUTRAL_TEMP = 10.0
private const val MAX_NEUTRAL_TEMP = 20.0
private const val PARTIAL_CLOUDS_MAX_PERCENTAGE = 60
