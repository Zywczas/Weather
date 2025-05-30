pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Weather"
include(":app")
include(":network_caller")
include(":network_forecast")
include(":feature_forecast_place")
include(":common_compose")
include(":network_places")
include(":store_history")
include(":umbrella")
include(":common_utils")
include(":network_open_weather_api")
