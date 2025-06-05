package com.zywczas.featureforecastplace.domain

import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.zywczas.commoncompose.components.KeyValueViewEntity
import com.zywczas.commonutils.Chars
import com.zywczas.commonutils.UnitsConverter
import com.zywczas.commonutils.extensions.round
import com.zywczas.commonutils.extensions.unixDateTimeToDate
import com.zywczas.commonutils.weather.TemperatureColor
import com.zywczas.commonutils.weather.WeatherCondition
import com.zywczas.featureforecastplace.viewmodel.HourlyForecastViewEntity
import com.zywczas.featureforecastplace.viewmodel.PlaceForecastViewEntity
import com.zywczas.networkforecast.response.CurrentResponse
import com.zywczas.networkforecast.response.HourlyResponse
import com.zywczas.networkforecast.response.WeatherResponse
import com.zywczas.networkopenweatherapi.WeatherApiWeatherCondition
import com.zywczas.networkplaces.response.LocationResponse
import com.zywczas.storehistory.entity.LocationLocal
import com.zywczas.weather.resources.commonutils.Res
import com.zywczas.weather.resources.commonutils.cloud_cover_title
import com.zywczas.weather.resources.commonutils.cloud_cover_value
import com.zywczas.weather.resources.commonutils.humidity_title
import com.zywczas.weather.resources.commonutils.humidity_value
import com.zywczas.weather.resources.commonutils.precipitation_rain_title
import com.zywczas.weather.resources.commonutils.precipitation_snow_title
import com.zywczas.weather.resources.commonutils.precipitation_value
import com.zywczas.weather.resources.commonutils.pressure_title
import com.zywczas.weather.resources.commonutils.pressure_value
import com.zywczas.weather.resources.commonutils.temperature_value
import com.zywczas.weather.resources.commonutils.visibility_title
import com.zywczas.weather.resources.commonutils.visibility_value
import com.zywczas.weather.resources.commonutils.wind_speed_title
import com.zywczas.weather.resources.commonutils.wind_speed_value
import org.jetbrains.compose.resources.getString

internal suspend fun CurrentResponse.toDomain(
    toolbarTitle: String,
): PlaceForecastViewEntity = PlaceForecastViewEntity(
    toolbarTitle = toolbarTitle,
    weatherCondition = weather.firstOrNull()?.toDomain(cloudsPercentage = cloudsPercentage),
    temperatureColor = getTemperatureColor(temperature).value,
    temperatureText = getString(Res.string.temperature_value, temperature.round(decimalPlaces = 1)),
    keyValueItems = listOfNotNull(
        KeyValueViewEntity(
            key = getString(Res.string.cloud_cover_title),
            value = getString(Res.string.cloud_cover_value, cloudsPercentage),
        ),
        rain?.let {
            KeyValueViewEntity(
                key = getString(Res.string.precipitation_rain_title),
                value = getString(Res.string.precipitation_value, it.mmPerHour)
            )
        },
        snow?.let {
            KeyValueViewEntity(
                key = getString(Res.string.precipitation_snow_title),
                value = getString(Res.string.precipitation_value, it.mmPerHour)
            )
        },
        if (rain == null && snow == null) {
            KeyValueViewEntity(
                key = getString(Res.string.precipitation_rain_title),
                value = getString(Res.string.precipitation_value, NO_PRECIPITATION_VALUE)
            )
        } else {
            null
        },
        KeyValueViewEntity(
            key = getString(Res.string.humidity_title),
            value = getString(Res.string.humidity_value, humidityPercentage)
        ),
        KeyValueViewEntity(
            key = getString(Res.string.pressure_title),
            value = getString(Res.string.pressure_value, pressure)
        ),
        KeyValueViewEntity(
            key = getString(Res.string.visibility_title),
            value = getString(Res.string.visibility_value, visibility)
        ),
        KeyValueViewEntity(
            key = getString(Res.string.wind_speed_title),
            value = getString(Res.string.wind_speed_value, UnitsConverter.mPerSecToKmPerH(windSpeed).round(decimalPlaces = 1))
        ),
    ),
)

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

internal fun HourlyResponse.toDomain(): HourlyForecastViewEntity = HourlyForecastViewEntity(
    hour = buildAnnotatedString {
        val date = unixDateTime.unixDateTimeToDate()
        withStyle(HOURS_SPAN_STYLE) {
            append(date.hour.toString())
        }
        append(DISPLAYED_MINUTES)
    },
    weatherCondition = weather.firstOrNull()?.toDomain(cloudsPercentage) ?: WeatherCondition.Clear,
    temperature = temperature.round(decimalPlaces = 0).toString() + Chars.DEGREE,
    precipitationProbability = precipitationProbability.round(decimalPlaces = 0).toString() + Chars.PERCENT,
    isPrecipitationProbabilityLow = precipitationProbability < PRECIPITATION_PROBABILITY_MIN_VALUE
)

private fun WeatherResponse.toDomain(cloudsPercentage: Int): WeatherCondition? = when (condition) {
    WeatherApiWeatherCondition.Clear -> WeatherCondition.Clear
    WeatherApiWeatherCondition.Clouds -> if (cloudsPercentage < PARTIAL_CLOUDS_MAX_PERCENTAGE) WeatherCondition.PartialClouds else WeatherCondition.Clouds
    WeatherApiWeatherCondition.Rain -> WeatherCondition.Rain
    WeatherApiWeatherCondition.Snow -> WeatherCondition.Snow
    WeatherApiWeatherCondition.Atmosphere -> WeatherCondition.Atmosphere
    WeatherApiWeatherCondition.Drizzle -> WeatherCondition.Drizzle
    WeatherApiWeatherCondition.Thunderstorm -> WeatherCondition.Thunderstorm
    else -> null
}

private fun getTemperatureColor(temp: Double): TemperatureColor = when {
    temp < MIN_NEUTRAL_TEMP -> TemperatureColor.Cold
    temp > MAX_NEUTRAL_TEMP -> TemperatureColor.Hot
    else -> TemperatureColor.Neutral
}

private const val MIN_NEUTRAL_TEMP = 10.0
private const val MAX_NEUTRAL_TEMP = 20.0
private const val PARTIAL_CLOUDS_MAX_PERCENTAGE = 60
private const val NO_PRECIPITATION_VALUE = 0
private const val PRECIPITATION_PROBABILITY_MIN_VALUE = 1.5
private val HOURS_SPAN_STYLE = SpanStyle(fontWeight = FontWeight.Bold)
private const val DISPLAYED_MINUTES = "00"
