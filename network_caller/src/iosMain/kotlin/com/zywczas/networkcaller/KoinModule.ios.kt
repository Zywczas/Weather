package com.zywczas.networkcaller

import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
//import io.ktor.client.engine.ios.Ios
//import io.ktor.client.features.json.JsonFeature
//import io.ktor.client.features.json.serializer.KotlinxSerializer
import kotlinx.serialization.json.Json

actual val httpClient: HttpClient = HttpClient(Darwin) {

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
//        config {
//            //           connectTimeout(30L, TimeU) //todo dodac
//        }
    }
}
