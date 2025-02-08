package com.zywczas.weather.navigation

import com.zywczas.featureforecastplace.screens.PlaceForecastArgs

object DestinationSearchCity : Destination()
object DestinationPlaceForecast : DestinationWithArgs<PlaceForecastArgs>(PlaceForecastArgs::class)
