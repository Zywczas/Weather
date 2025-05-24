package com.zywczas.networkcaller

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

import org.koin.dsl.module

val networkCallerModule = module {
    single { networkClient }
}

internal expect val networkClient: HttpClient

internal fun <T : HttpClientEngineConfig> configureNetworkClient(engineConfig: HttpClientConfig<T>) {
    engineConfig.install(Logging) {
        logger = Logger.DEFAULT
        level = LogLevel.HEADERS
    }
    engineConfig.install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            ignoreUnknownKeys = true
        })
    }
}
