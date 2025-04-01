package com.zywczas.networkcaller

import org.koin.dsl.module

//todo update to KMM
//inline fun <reified T> createRetrofitService(): T = GlobalContext.get().get<Retrofit>().create(T::class.java)

val networkCallerModule = module {

//    single {
//        OkHttpClient.Builder()
//            .connectTimeout(CONNECTION_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
//            .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
//            .build()
//    }
//    single {
//        Retrofit.Builder()
//            .client(get())
//            .baseUrl(WeatherApiConstants.WEATHER_API_BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
}

private const val CONNECTION_TIMEOUT_IN_SECONDS = 30L
