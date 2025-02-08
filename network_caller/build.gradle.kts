plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.zywczas.networkcaller"
    compileSdk = 35

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        val openweathermapApiKey: String by rootProject.extra
        buildConfigField("String", "OPENWEATHERMAP_API_KEY", "\"$openweathermapApiKey\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    api(libs.retrofit)
    api(libs.gsonConverter)
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)
    implementation(libs.okHttpInterceptor)
    implementation(libs.okHttp)
    implementation(libs.androidx.annotation.jvm)
}
