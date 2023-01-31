plugins {
    id("multiplatform-compose-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                //implementation(Dependencies.Other.ViewModel.core)
                //implementation(Dependencies.Other.ViewModel.compose)
                //implementation(Dependencies.Other.ViewModel.odyssey)

                //implementation(Dependencies.Other.Navigation.compose)
                //implementation(Dependencies.Other.Navigation.core)
            }
        }

        androidMain {
            dependencies {
                implementation(Dependencies.Android.Compose.activity)
            }
        }
    }
}