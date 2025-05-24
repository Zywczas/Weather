package com.zywczas.networkcaller

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import java.util.concurrent.TimeUnit

actual val httpClient: HttpClient = HttpClient(OkHttp) {

    install(Logging) {
        logger = Logger.DEFAULT
        level = LogLevel.HEADERS
    }

    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            ignoreUnknownKeys = true
        })
    }

    engine {
        config {
            connectTimeout(NetworkParameters.TIMEOUT_MILLISECONDS, TimeUnit.MILLISECONDS)
        }
    }
}
