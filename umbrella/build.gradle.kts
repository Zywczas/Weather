import com.zywczas.buildutils.Versions

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
}

kotlin {

    androidLibrary {
        namespace = "com.zywczas.umbrella"
        compileSdk = Versions.COMPILE_SDK
        minSdk = Versions.MIN_SDK
    }

    val xcfName = "umbrellaKit"

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
                api(project(":common_compose"))
                api(project(":common_utils"))
                api(project(":feature_forecast_place"))
                api(project(":network_caller"))
                api(project(":network_forecast"))
                api(project(":network_places"))
                api(project(":store_history"))
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
