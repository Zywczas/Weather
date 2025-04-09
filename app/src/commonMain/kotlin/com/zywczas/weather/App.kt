package com.zywczas.weather

import androidx.compose.runtime.Composable
import com.zywczas.commoncompose.theme.Theme
import com.zywczas.weather.di.koinModules
import com.zywczas.weather.navigation.AppNavHost
import org.koin.compose.KoinApplication

@Composable
fun App() {
    KoinApplication(application = { modules(koinModules) }) {
        Theme.App {
            AppNavHost()
        }
    }
}
