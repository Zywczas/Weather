package com.zywczas.storehistory.entity

import com.zywczas.storehistory.cache.Location

internal fun Location.toLocal() = LocationLocal(
    name = name,
    lat = lat,
    lon = lon
)
