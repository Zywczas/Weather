package com.zywczas.weather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.zywczas.commoncompose.theme.AppTheme
import com.zywczas.weather.navigation.AppNavHost
import org.koin.androidx.compose.KoinAndroidContext

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                KoinAndroidContext {
                    AppNavHost()
                }
            }
        }
    }
}
