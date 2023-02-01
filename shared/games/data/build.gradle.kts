plugins {
    id("multiplatform-setup")
    id("android-setup")
    kotlin("plugin.serialization")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(project(":shared:games:api"))
                implementation(project(":shared:core"))
            }
        }
    }
}
