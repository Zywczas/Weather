import com.zywczas.buildutils.ModulesUtils
import com.zywczas.buildutils.Versions
import com.zywczas.buildutils.getEnvElseLocal

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.gmazzo)
    alias(libs.plugins.kotlin.compose.compiler)
    alias(libs.plugins.detekt)
}

buildConfig {
    buildConfigField("OPENWEATHERMAP_API_KEY", getEnvElseLocal("openweathermapApiKey", project))
}

kotlin {
    val moduleName = "networkopenweatherapi"

    androidLibrary {
        namespace = ModulesUtils.getAndroidNamespace(moduleName)
        compileSdk = Versions.COMPILE_SDK
        minSdk = Versions.MIN_SDK
    }

    val xcfName = ModulesUtils.getAndroidNamespace(moduleName)

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
            }
        }
    }
}
