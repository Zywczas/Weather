package com.zywczas.buildutils

object ModulesUtils {

    fun getResourcesPackageName(moduleName: String): String = "com.zywczas.weather.resources.$moduleName"

    fun getAndroidNamespace(moduleName: String): String = "com.zywczas.$moduleName"

    fun getXcfName(moduleName: String): String = "${moduleName}Kit"
}
