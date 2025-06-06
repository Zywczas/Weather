plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.compose.compiler) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.android.kotlin.multiplatform.library) apply false
    alias(libs.plugins.gmazzo) apply false
    alias(libs.plugins.compose.multiplatform) apply false
    alias(libs.plugins.sqldelight) apply false
    alias(libs.plugins.detekt)
}

tasks.register("detektAllModules") {
    subprojects.forEach { subproject ->

        require(subproject.pluginManager.hasPlugin(libs.plugins.detekt.get().pluginId)) {
            "Module '${subproject.name}' doesn't use Detekt plugin. You need to add 'alias(libs.plugins.detekt)' to the module."
        }

        subproject.detekt {
            parallel = true
            config.setFrom(files("$rootDir/code_quality/detekt/detekt.yml"))
        }
        finalizedBy(":${subproject.name}:detekt")
    }
}
