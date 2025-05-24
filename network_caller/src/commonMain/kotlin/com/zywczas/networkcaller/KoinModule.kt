package com.zywczas.networkcaller

import org.koin.dsl.module

val networkCallerModule = module {
    single { networkCaller }
}
