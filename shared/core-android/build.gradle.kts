plugins {
    id("multiplatform-compose-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":shared:core"))
                implementation(project(":shared:screens"))

                implementation(project(":shared:games:data"))
                implementation(project(":shared:games:compose"))

                implementation(Dependencies.AlexGladkov.ViewModel.core)
                implementation(Dependencies.AlexGladkov.ViewModel.compose)
                implementation(Dependencies.AlexGladkov.ViewModel.odyssey)

                implementation(Dependencies.AlexGladkov.Navigation.compose)
                implementation(Dependencies.AlexGladkov.Navigation.core)
            }
        }

        androidMain {
            dependencies {
                implementation(project(":shared:theme"))
                implementation(Dependencies.Android.Compose.activity)
            }
        }
    }
}