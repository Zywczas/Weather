package com.zywczas.weather

import androidx.compose.runtime.Composable
import com.zywczas.commoncompose.theme.Theme
import com.zywczas.weather.navigation.AppNavHost

@Composable
fun App() {
    Theme.App {
        AppNavHost()
    }
}
