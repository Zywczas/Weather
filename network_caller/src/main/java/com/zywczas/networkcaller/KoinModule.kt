package com.zywczas.networkcaller

import com.zywczas.networkcaller.openweatherapi.WeatherApiConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.context.GlobalContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

inline fun <reified T> createRetrofitService(): T = GlobalContext.get().get<Retrofit>().create(T::class.java)

val networkCallerModule = module {

    single {
        OkHttpClient.Builder()
            .connectTimeout(CONNECTION_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
            .build()
    }
    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl(WeatherApiConstants.WEATHER_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

private const val CONNECTION_TIMEOUT_IN_SECONDS = 30L
