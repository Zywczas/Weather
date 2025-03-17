package com.zywczas.featureforecastplace.viewmodel

import com.zywczas.commoncompose.components.KeyValueViewEntity
import com.zywczas.commoncompose.theme.TemperatureColor
import com.zywczas.commonutil.R
import com.zywczas.commonutil.StringProvider
import com.zywczas.commonutil.UnitsConverter
import com.zywczas.commonutil.WeatherCondition
import com.zywczas.commonutil.extensions.roundTo2DecimalPlaces
import com.zywczas.featureforecastplace.domain.Location
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
        weatherCondition = current.weather.firstOrNull()?.toDomain(),
        temperatureColor = TemperatureColor.get(current.temperature).value,
        temperatureText = stringProvider.getString(R.string.temperature_value, current.temperature),
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
                value = stringProvider.getString(R.string.wind_speed_value, UnitsConverter.mPerSecToKmPerH(current.windSpeed).roundTo2DecimalPlaces())
            ),
        ),
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

internal fun WeatherResponse.toDomain(): WeatherCondition? = when (condition) {
    "Clear" -> WeatherCondition.Clear
    "Clouds" -> WeatherCondition.Clouds
    "Rain" -> WeatherCondition.Rain
    "Snow" -> WeatherCondition.Snow
    "Atmosphere" -> WeatherCondition.Atmosphere
    "Drizzle" -> WeatherCondition.Drizzle
    "Thunderstorm" -> WeatherCondition.Thunderstorm
    else -> null
}
