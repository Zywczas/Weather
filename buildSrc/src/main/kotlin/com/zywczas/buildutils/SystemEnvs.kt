package com.zywczas.buildutils

import org.gradle.api.Project

fun getEnvElseLocal(key: String, project: Project): String = System.getenv(key) ?: project.property(key) as String
