plugins {
    id("module-setup")
    id("multiplatform-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":shared:feature:auth:api"))
                implementation(project(":shared:core"))
            }
        }
    }
}

android { namespace = "com.sideki.test.shared.feature.auth.data" }
