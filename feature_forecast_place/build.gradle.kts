import com.zywczas.buildutils.ModulesUtils
import com.zywczas.buildutils.Versions

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.kotlin.compose.compiler)
    // alias(libs.plugins.detekt)todo update to KMM
}

kotlin {
    val moduleName = "featureforecastplace"

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
                implementation(project(":common_compose"))
                implementation(project(":common_utils"))
                implementation(project(":network_forecast"))
                implementation(project(":network_places"))
                implementation(project(":store_history"))

                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.ui)
                implementation(compose.components.resources)
                implementation(compose.components.uiToolingPreview)
                implementation(libs.androidx.lifecycle.viewmodel)
                implementation(libs.androidx.lifecycle.runtime.compose)
                implementation(libs.kotlinx.datetime)//todo nie wiem czy potrzebne

                implementation(project.dependencies.platform(libs.koin.bom))
                implementation(libs.koin.core)
                implementation(libs.koin.compose.viewmodel)
                implementation(libs.koin.androidx.compose)
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
