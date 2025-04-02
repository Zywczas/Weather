import com.zywczas.buildutils.Versions

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.kotlin.compose.compiler)
}

kotlin {
    androidLibrary {
        namespace = "com.zywczas.commonutil"
        compileSdk = Versions.COMPILE_SDK
        minSdk = Versions.MIN_SDK
    }

    val xcfName = "commonutilKit"

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
                implementation(libs.kotlin.stdlib)
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.ui)
                implementation(compose.components.resources)
                implementation(compose.components.uiToolingPreview)
                implementation(libs.androidx.lifecycle.viewmodel)
                implementation(libs.androidx.lifecycle.runtime.compose)
                implementation(libs.kotlinx.datetime)
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

compose.resources {
    publicResClass = true
    packageOfResClass = Versions.RESOURCES_PACKAGE
    generateResClass = always
}
