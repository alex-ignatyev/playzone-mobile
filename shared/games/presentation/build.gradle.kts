plugins {
    id("module-setup")
    id("multiplatform-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(project(":shared:core"))
                api(project(":shared:games:api"))
                implementation(Dependencies.AlexGladkov.ViewModel.core)
            }
        }
    }
}
