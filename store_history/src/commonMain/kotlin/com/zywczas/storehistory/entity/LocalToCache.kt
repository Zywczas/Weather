package com.zywczas.storehistory.entity

import com.zywczas.storehistory.cache.Location

internal fun LocationLocal.toCache() = Location(
    name = name,
    lat = lat,
    lon = lon
)
