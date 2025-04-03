package com.zywczas.featureforecastplace.domain

internal sealed class SearchListItem {

    data class Header(val text: String) : SearchListItem()

    data class Location(
        val name: String = "",
        val lat: Double = 0.0,
        val lon: Double = 0.0
    ) : SearchListItem()
}
