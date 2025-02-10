package com.zywczas.networkplaces.domain

import com.zywczas.networkplaces.response.LocationResponse

internal fun LocationResponse.toDomain() = Location(
    name = "$name, $state, $country",
    lat = lat,
    lon = lon
)
