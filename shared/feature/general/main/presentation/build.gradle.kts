plugins {
    id("module-setup")
    id("multiplatform-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":shared:core"))
                implementation(project(":shared:feature:general:main:api"))

                implementation(Dependencies.AlexGladkov.ViewModel.core)
            }
        }
    }
}
