package com.zywczas.commonutils

import org.jetbrains.compose.resources.StringResource

sealed class Resource<T> {

    class Success<T>(val data: T) : Resource<T>()

    class Error<T>(val message: StringResource) : Resource<T>()
}
