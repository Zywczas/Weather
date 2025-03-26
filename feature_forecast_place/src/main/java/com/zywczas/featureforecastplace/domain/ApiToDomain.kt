package com.zywczas.featureforecastplace.domain

import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.zywczas.commoncompose.components.KeyValueViewEntity
import com.zywczas.commonutil.Chars
import com.zywczas.commonutil.R
import com.zywczas.commonutil.StringProvider
import com.zywczas.commonutil.UnitsConverter
import com.zywczas.commonutil.extensions.hour
import com.zywczas.commonutil.extensions.roundTo0DecimalPlaces
import com.zywczas.commonutil.extensions.roundTo1DecimalPlace
import com.zywczas.commonutil.extensions.unixDateTimeToDate
import com.zywczas.commonutil.weather.TemperatureColor
import com.zywczas.commonutil.weather.TemperatureColor.Cold
import com.zywczas.commonutil.weather.TemperatureColor.Hot
import com.zywczas.commonutil.weather.TemperatureColor.Neutral
import com.zywczas.commonutil.weather.WeatherCondition
import com.zywczas.featureforecastplace.viewmodel.HourlyForecastViewEntity
import com.zywczas.featureforecastplace.viewmodel.PlaceForecastViewEntity
import com.zywczas.networkforecast.response.CurrentResponse
import com.zywczas.networkforecast.response.HourlyResponse
import com.zywczas.networkforecast.response.WeatherResponse
import com.zywczas.networkplaces.response.LocationResponse
import com.zywczas.storehistory.entity.LocationLocal

internal fun CurrentResponse.toDomain(
    toolbarTitle: String,
    stringProvider: StringProvider
): PlaceForecastViewEntity = PlaceForecastViewEntity(
    toolbarTitle = toolbarTitle,
    weatherCondition = weather.firstOrNull()?.toDomain(cloudsPercentage = cloudsPercentage),
    temperatureColor = getTemperatureColor(temperature).value,
    temperatureText = stringProvider.getString(R.string.temperature_value, temperature.roundTo1DecimalPlace()),
    keyValueItems = listOfNotNull(
        KeyValueViewEntity(
            key = stringProvider.getString(R.string.cloud_cover_title),
            value = stringProvider.getString(R.string.cloud_cover_value, cloudsPercentage),
        ),
        rain?.let {
            KeyValueViewEntity(
                key = stringProvider.getString(R.string.precipitation_rain_title),
                value = stringProvider.getString(R.string.precipitation_value, it.mmPerHour)
            )
        },
        snow?.let {
            KeyValueViewEntity(
                key = stringProvider.getString(R.string.precipitation_snow_title),
                value = stringProvider.getString(R.string.precipitation_value, it.mmPerHour)
            )
        },
        if (rain == null && snow == null) {
            KeyValueViewEntity(
                key = stringProvider.getString(R.string.precipitation_rain_title),
                value = stringProvider.getString(R.string.precipitation_value, NO_PRECIPITATION_VALUE)
            )
        } else {
            null
        },
        KeyValueViewEntity(
            key = stringProvider.getString(R.string.humidity_title),
            value = stringProvider.getString(R.string.humidity_value, humidityPercentage)
        ),
        KeyValueViewEntity(
            key = stringProvider.getString(R.string.pressure_title),
            value = stringProvider.getString(R.string.pressure_value, pressure)
        ),
        KeyValueViewEntity(
            key = stringProvider.getString(R.string.visibility_title),
            value = stringProvider.getString(R.string.visibility_value, visibility)
        ),
        KeyValueViewEntity(
            key = stringProvider.getString(R.string.wind_speed_title),
            value = stringProvider.getString(R.string.wind_speed_value, UnitsConverter.mPerSecToKmPerH(windSpeed).roundTo1DecimalPlace())
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
            append(date.hour)
        }
        append(DISPLAYED_MINUTES)
    },
    weatherCondition = weather.firstOrNull()?.toDomain(cloudsPercentage) ?: WeatherCondition.Clear,
    temperature = temperature.roundTo0DecimalPlaces() + Chars.DEGREE,
    precipitationProbability = precipitationProbability.roundTo0DecimalPlaces() + Chars.PERCENT,
    isPrecipitationProbabilityLow = precipitationProbability < PRECIPITATION_PROBABILITY_MIN_VALUE
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
private const val NO_PRECIPITATION_VALUE = 0
private const val PRECIPITATION_PROBABILITY_MIN_VALUE = 1
private val HOURS_SPAN_STYLE = SpanStyle(fontWeight = FontWeight.Bold)
private const val DISPLAYED_MINUTES = "00"
