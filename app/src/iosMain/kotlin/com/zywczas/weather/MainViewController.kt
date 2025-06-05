
package com.zywczas.weather

import androidx.compose.ui.window.ComposeUIViewController
import com.zywczas.weather.di.koinModules
import org.koin.compose.KoinApplication

@Suppress("unused", "FunctionName")
fun MainViewController() = ComposeUIViewController {
    KoinApplication(application = { modules(koinModules) }) {
        App()
    }
}
