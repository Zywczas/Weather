package com.zywczas.weather

import android.app.Application
import com.zywczas.weather.di.koinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApp)
            modules(koinModules)
        }
    }
}
//TODO:
