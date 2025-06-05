package com.zywczas.commonutils.weather

import com.zywczas.weather.resources.commonutils.Res
import com.zywczas.weather.resources.commonutils.content_description_condition_atmosphere
import com.zywczas.weather.resources.commonutils.content_description_condition_clear
import com.zywczas.weather.resources.commonutils.content_description_condition_clouds
import com.zywczas.weather.resources.commonutils.content_description_condition_drizzle
import com.zywczas.weather.resources.commonutils.content_description_condition_partial_clouds
import com.zywczas.weather.resources.commonutils.content_description_condition_rain
import com.zywczas.weather.resources.commonutils.content_description_condition_snow
import com.zywczas.weather.resources.commonutils.content_description_condition_thunderstorm
import com.zywczas.weather.resources.commonutils.ic_condition_cloudy
import com.zywczas.weather.resources.commonutils.ic_condition_drizzle
import com.zywczas.weather.resources.commonutils.ic_condition_fog
import com.zywczas.weather.resources.commonutils.ic_condition_partial_cloud
import com.zywczas.weather.resources.commonutils.ic_condition_rain
import com.zywczas.weather.resources.commonutils.ic_condition_snowy
import com.zywczas.weather.resources.commonutils.ic_condition_sunny
import com.zywczas.weather.resources.commonutils.ic_condition_thunder
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

enum class WeatherCondition(val icon: DrawableResource, val contentDescription: StringResource) {
    Clear(Res.drawable.ic_condition_sunny, Res.string.content_description_condition_clear),
    Thunderstorm(Res.drawable.ic_condition_thunder, Res.string.content_description_condition_thunderstorm),
    Drizzle(Res.drawable.ic_condition_drizzle, Res.string.content_description_condition_drizzle),
    Rain(Res.drawable.ic_condition_rain, Res.string.content_description_condition_rain),
    Snow(Res.drawable.ic_condition_snowy, Res.string.content_description_condition_snow),
    Atmosphere(Res.drawable.ic_condition_fog, Res.string.content_description_condition_atmosphere),
    Clouds(Res.drawable.ic_condition_cloudy, Res.string.content_description_condition_clouds),
    PartialClouds(Res.drawable.ic_condition_partial_cloud, Res.string.content_description_condition_partial_clouds),
}
