plugins {
    id("module-setup")
    id("multiplatform-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(project(":shared:core"))
                api(project(":shared:auth:api"))
                implementation(Dependencies.AlexGladkov.ViewModel.core)
            }
        }
    }
}
