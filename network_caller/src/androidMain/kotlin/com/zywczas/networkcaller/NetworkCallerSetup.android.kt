package com.zywczas.networkcaller

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import java.util.concurrent.TimeUnit

actual val networkCaller: HttpClient = HttpClient(OkHttp) {

    engine {
        config {
            connectTimeout(TIMEOUT_MILLISECONDS, TimeUnit.MILLISECONDS)
        }
    }

    configureNetworkCaller(this)
}
