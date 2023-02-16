plugins {
    id("module-setup")
    id("multiplatform-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":shared:core"))
                implementation(project(":shared:feature:auth:api"))
                implementation(Dependencies.AlexGladkov.ViewModel.core)
            }
        }
    }
}
