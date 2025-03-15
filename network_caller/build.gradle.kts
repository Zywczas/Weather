import com.zywczas.buildutils.Versions

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.zywczas.networkcaller"
    compileSdk = Versions.COMPILE_SDK

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        minSdk = Versions.MIN_SDK

        val openweathermapApiKey: String by rootProject.extra
        buildConfigField("String", "OPENWEATHERMAP_API_KEY", "\"$openweathermapApiKey\"")
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
    implementation(libs.retrofit)
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)
    implementation(libs.okHttpInterceptor)
    implementation(libs.okHttp)
    implementation(libs.androidx.annotation.jvm)
}
