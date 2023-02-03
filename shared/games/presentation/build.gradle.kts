plugins {
    id("multiplatform-setup")
    id("android-setup")
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