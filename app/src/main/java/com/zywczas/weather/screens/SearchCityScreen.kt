package com.zywczas.weather.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.zywczas.weather.uicomponents.Toolbar

@Composable
fun SearchCityScreen() {
    Column {
        Toolbar("SearchCityScreen")
        Text("SearchCityScreen")
    }
}
