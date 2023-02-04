plugins {
    id("module-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":shared:theme"))
                implementation(project(":shared:screens"))
                implementation(project(":shared:auth:presentation"))

                implementation(Dependencies.AlexGladkov.ViewModel.core)
                implementation(Dependencies.AlexGladkov.ViewModel.compose)
                implementation(Dependencies.AlexGladkov.ViewModel.odyssey)

                implementation(Dependencies.AlexGladkov.Navigation.core)
                implementation(Dependencies.AlexGladkov.Navigation.compose)
            }
        }
    }
}
