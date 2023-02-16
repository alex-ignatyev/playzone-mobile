plugins {
    id("module-setup")
    id("multiplatform-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":shared:feature:general:main:api"))
                implementation(project(":shared:core"))
            }
        }
    }
}
