plugins {
    id("module-setup")
    id("multiplatform-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":shared:core"))
                implementation(project(":shared:feature:general:home:api"))

                implementation(Dependencies.AlexGladkov.ViewModel.core)
            }
        }
    }
}

android { namespace = "com.sideki.test.shared.feature.general.home.presentation" }
