plugins {
    id("module-setup")
    id("android-setup")
    id("com.google.devtools.ksp") version "1.7.20-1.0.8" // Версия зависит от Kotlin https://github.com/google/ksp/releases // Нужен для Compose-Destinations
}

kotlin {
    sourceSets {
        androidMain {
            dependencies {
                implementation(project(":shared:theme"))
                implementation(project(":shared:core-android-navigator"))

                implementation(project(":shared:feature:auth:compose"))
                implementation(project(":shared:feature:general:main:compose"))

                implementation(Dependencies.Android.Navigation.core)
                configurations["ksp"].dependencies.add(project.dependencies.create(Dependencies.Android.Navigation.ksp))

                // Для экстеншена ComponentActivity.setupThemedNavigation()
                implementation(Dependencies.Android.Compose.activity)
            }
        }
    }
}
