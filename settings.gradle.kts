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
include(":shared:theme")
include(":shared:screens")

include(":shared:auth:api")
include(":shared:auth:data")
include(":shared:auth:presentation")
include(":shared:auth:compose")
