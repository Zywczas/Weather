package com.zywczas.networkcaller

import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin
import io.ktor.client.plugins.HttpTimeout

actual val networkClient: HttpClient = HttpClient(Darwin) {

    install(HttpTimeout) {
        connectTimeoutMillis = NetworkParameters.TIMEOUT_MILLISECONDS
    }

    configureNetworkClient(this)
}
