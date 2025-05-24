package com.zywczas.networkcaller

import io.ktor.client.HttpClient

import org.koin.dsl.module

val networkCallerModule = module {
    single { httpClient }
}

internal expect val httpClient: HttpClient
