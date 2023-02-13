plugins {
    id("module-setup")
    id("multiplatform-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(project(":shared:feature:general:main:api"))
                implementation(project(":shared:core"))
            }
        }
    }
}
