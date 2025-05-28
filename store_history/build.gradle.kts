import com.zywczas.buildutils.ModulesUtils
import com.zywczas.buildutils.Versions

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.kotlin.compose.compiler)
    alias(libs.plugins.sqldelight)
    alias(libs.plugins.detekt)
}

kotlin {
    val moduleName = "storehistory"

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
                implementation(project(":common_utils"))
                implementation(compose.runtime)

                implementation(project.dependencies.platform(libs.koin.bom))
                implementation(libs.koin.core)

                implementation(libs.sqldelight.runtime)
            }
        }

        androidMain {
            dependencies {
                implementation(libs.sqldelight.android.driver)
            }
        }


        iosMain {
            dependencies {
                implementation(libs.sqldelight.native.driver)
            }
        }
    }
}

sqldelight {
    databases {
        create("HistoryDatabase") {
            packageName = "com.zywczas.storehistory.cache"
        }
    }
}
