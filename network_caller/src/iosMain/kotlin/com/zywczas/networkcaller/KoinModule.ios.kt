package com.zywczas.networkcaller

import io.ktor.client.HttpClient
import io.ktor.client.engine.ios.Ios
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import kotlinx.serialization.json.Json

actual val httpClient: HttpClient = HttpClient(Ios) {
    install(JsonFeature) {
        serializer = KotlinxSerializer( //todo ujednolicic do funkcji expect
            Json {
                ignoreUnknownKeys = true
            }
        )
    }
}
