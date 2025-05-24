package com.zywczas.networkcaller

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import java.util.concurrent.TimeUnit

actual val networkClient: HttpClient = HttpClient(OkHttp) {

    engine {
        config {
            connectTimeout(NetworkParameters.TIMEOUT_MILLISECONDS, TimeUnit.MILLISECONDS)
        }
    }

    configureNetworkClient(this)
}
