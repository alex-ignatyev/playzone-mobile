pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "test"

include(":androidApp")

include(":shared:core")
include(":shared:core-ios")
include(":shared:core-android")
