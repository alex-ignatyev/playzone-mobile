plugins {
    id("module-setup")
    id("android-setup")
    id("com.google.devtools.ksp") version "1.7.20-1.0.8" // Версия зависит от Kotlin https://github.com/google/ksp/releases // Нужен для Compose-Destinations
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":shared:theme"))
                implementation(project(":shared:core-android-navigator"))
                implementation(project(":shared:feature:general:profile:presentation"))

                implementation(Dependencies.AlexGladkov.ViewModel.core)
                implementation(Dependencies.AlexGladkov.ViewModel.compose)

                implementation(Dependencies.Android.Navigation.core)
                configurations["ksp"].dependencies.add(project.dependencies.create(Dependencies.Android.Navigation.ksp))
            }
        }
    }
}

android { namespace = "com.sideki.test.shared.feature.general.profile.compose" }

// Обязательная настройка для многомодульного проекта, иначе будет конфликт сгенерированных NavGraphs // https://composedestinations.rafaelcosta.xyz/codegenconfigs
ksp {
    arg("compose-destinations.codeGenPackageName", "com.sideki.test.shared.feature.general.profile.compose")
    arg("compose-destinations.generateNavGraphs", "false")
}
