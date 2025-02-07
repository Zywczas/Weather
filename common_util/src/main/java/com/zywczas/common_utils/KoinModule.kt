package com.zywczas.common_utils

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val commonUtilModule = module {
    singleOf(::StringProvider)
}
