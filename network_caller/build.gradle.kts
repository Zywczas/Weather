import com.zywczas.buildutils.Versions
import com.zywczas.buildutils.getEnvElseLocal

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.kotlin.compose.compiler)
    // alias(libs.plugins.detekt)todo update to KMM
}

//android {
//    buildFeatures {
//        buildConfig = true //todo update to KMM
//    }
//    defaultConfig {
////        buildConfigField("String", "OPENWEATHERMAP_API_KEY", "\"${getEnvElseLocal("openweathermapApiKey", project)}\"") //todo update to KMM
//    }
//}

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
                implementation(compose.foundation) //todo this compose implementations not needed
                implementation(compose.material3)
                implementation(compose.ui)
                implementation(compose.components.resources)
                implementation(compose.components.uiToolingPreview)

                implementation(project.dependencies.platform(libs.koin.bom))
                implementation(libs.koin.core)

                //todo update to KMM
                // api(libs.gsonConverter)
                // implementation(libs.androidx.annotation.jvm)
                //    implementation(libs.okHttpInterceptor)
                //    implementation(libs.okHttp)
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
