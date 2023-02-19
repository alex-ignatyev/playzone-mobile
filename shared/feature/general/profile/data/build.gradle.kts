plugins {
    id("module-setup")
    id("multiplatform-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":shared:feature:general:profile:api"))
                implementation(project(":shared:core"))
            }
        }
    }
}

android { namespace = "com.sideki.test.shared.feature.general.profile.data" }
