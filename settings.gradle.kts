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

include(":shared:games:api")
include(":shared:games:data")
include(":shared:games:presentation")
include(":shared:games:compose")
