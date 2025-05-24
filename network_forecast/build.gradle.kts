import com.zywczas.buildutils.ModulesUtils
import com.zywczas.buildutils.Versions

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.kotlin.compose.compiler)
    alias(libs.plugins.kotlin.serialization)
    // alias(libs.plugins.detekt)todo update to KMM
}

kotlin {
    val moduleName = "networkforecast"

    androidLibrary {
        namespace = ModulesUtils.getAndroidNamespace(moduleName)
        compileSdk = Versions.COMPILE_SDK
        minSdk = Versions.MIN_SDK
    }

    val xcfName = ModulesUtils.getXcfName(moduleName)

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
                implementation(project(":network_caller"))
                implementation(project(":common_utils"))

                implementation(compose.runtime)
                implementation(compose.components.resources)

                implementation(project.dependencies.platform(libs.koin.bom))
                implementation(libs.koin.core)

                implementation(libs.kotlin.serialization.json)// todo jedno z tych dwoch chyba niepotrzebne
                implementation(libs.ktor.client.core)
//                implementation(libs.ktor.client.serialization)// todo jedno z tych dwoch chyba niepotrzebne
            }
        }

        androidMain {
            dependencies {
            }
        }


        iosMain {
            dependencies {
            }
        }
    }
}
