plugins {
    id("module-setup")
    id("multiplatform-setup")
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
