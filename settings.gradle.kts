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
include(":shared:kodein")
include(":shared:core-ios")
include(":shared:core-android")
include(":shared:core-android-navigator")
include(":shared:answer")
include(":shared:theme")

include(":shared:feature:auth:api")
include(":shared:feature:auth:data")
include(":shared:feature:auth:presentation")
include(":shared:feature:auth:compose")

include(":shared:feature:general:home:api")
include(":shared:feature:general:home:data")
include(":shared:feature:general:home:presentation")
include(":shared:feature:general:home:compose")

include(":shared:feature:general:profile:api")
include(":shared:feature:general:profile:data")
include(":shared:feature:general:profile:presentation")
include(":shared:feature:general:profile:compose")
