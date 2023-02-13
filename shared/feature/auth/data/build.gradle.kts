plugins {
    id("module-setup")
    id("multiplatform-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(project(":shared:feature:auth:api"))
                implementation(project(":shared:core"))

                implementation(Dependencies.Settings.core)
                implementation(Dependencies.Settings.noargs)
            }
        }
    }
}
