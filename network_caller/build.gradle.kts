import com.zywczas.buildutils.Versions
import com.zywczas.buildutils.getEnvElseLocal

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    // alias(libs.plugins.detekt)todo update to KMM
}

android {
    namespace = "com.zywczas.networkcaller"
    compileSdk = Versions.COMPILE_SDK

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        minSdk = Versions.MIN_SDK

        buildConfigField("String", "OPENWEATHERMAP_API_KEY", "\"${getEnvElseLocal("openweathermapApiKey", project)}\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = Versions.JAVA_VERSION
        targetCompatibility = Versions.JAVA_VERSION
    }
    kotlinOptions {
        jvmTarget = Versions.JVM_TARGET
    }
}

dependencies {

    api(libs.gsonConverter)
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)
//    implementation(libs.okHttpInterceptor)todo update to KMM
//    implementation(libs.okHttp)
    implementation(libs.androidx.annotation.jvm)
}
