package com.zywczas.networkcaller

import io.ktor.client.HttpClient
import io.ktor.serialization.kotlinx.json.*
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import kotlinx.serialization.serializer
import org.koin.dsl.module

val networkCallerModule = module {

    single { httpClient }

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

private const val CONNECTION_TIMEOUT_IN_SECONDS = 30L //todo usunac?

internal expect val httpClient: HttpClient

//internal val networkCaller: HttpClient = HttpClient {
//    serializer(
//        KotlinxSerializer(
//            kotlinx.serialization.json.Json {
//                ignoreUnknownKeys = true // if the server sends extra fields, ignore them
//            }
//        )
//    )
//    install(ContentNegotiation) {
//        seria
//        serializer() = KotlinxSerializer(
//            kotlinx.serialization.json.Json {
//                ignoreUnknownKeys = true // if the server sends extra fields, ignore them
//            }
//        )
//    }
//    engine {
//
//    }
//
//    install(JsonFeature) {
//
//    }
//}
