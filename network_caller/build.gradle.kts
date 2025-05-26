import com.zywczas.buildutils.Versions
import com.zywczas.buildutils.getEnvElseLocal

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.gmazzo)
    alias(libs.plugins.kotlin.compose.compiler)
    // alias(libs.plugins.detekt)todo update to KMM
}

buildConfig {
    buildConfigField("OPENWEATHERMAP_API_KEY", getEnvElseLocal("openweathermapApiKey", project))
}

kotlin {
    androidLibrary {
        namespace = "com.zywczas.networkcaller"
        compileSdk = Versions.COMPILE_SDK
        minSdk = Versions.MIN_SDK
    }

    val xcfName = "networkcallerKit" //todo check all names if matches android and move out to val everywhere

    iosX64 {
        binaries.framework {
            baseName = xcfName
        }
    }

    iosArm64 {
        binaries.framework {
            baseName = xcfName
        }
    }

    iosSimulatorArm64 {
        binaries.framework {
            baseName = xcfName
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.runtime)

                implementation(project.dependencies.platform(libs.koin.bom))
                implementation(libs.koin.core)

                implementation(libs.ktor.client.core)
                implementation(libs.ktor.serialization.kotlinx.json)
                implementation(libs.ktor.client.content.negotiation)
                implementation(libs.ktor.client.logging)
            }
        }

        androidMain {
            dependencies {
                implementation(libs.ktor.client.okhttp)
            }
        }


        iosMain {
            dependencies {
                implementation(libs.ktor.client.darwin)
            }
        }
    }
}
