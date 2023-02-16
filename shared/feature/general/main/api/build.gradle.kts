plugins {
    id("module-setup")
    id("multiplatform-setup")
    kotlin("plugin.serialization")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(project(":shared:answer"))

                implementation(Dependencies.Kotlin.Serialization.serialization)
            }
        }
    }
}
