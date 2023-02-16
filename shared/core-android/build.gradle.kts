plugins {
    id("module-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        androidMain {
            dependencies {
                implementation(project(":shared:screens"))
                implementation(project(":shared:theme"))

                // Модули собирается в NavGraph дерево - generateGraph()
                implementation(project(":shared:feature:auth:compose"))
                implementation(project(":shared:feature:general:main:compose"))

                // Для экстеншена ComponentActivity.setupThemedNavigation()
                implementation(Dependencies.Android.Compose.activity)

                // В модуле описывается граф навигации в приложении c испольованием библиотеки Odyssey
                implementation(Dependencies.AlexGladkov.Navigation.compose)
                implementation(Dependencies.AlexGladkov.Navigation.core)

                // Экстеншн setupWithViewModels() для интеграции Odyssey + KViewModel
                implementation(Dependencies.AlexGladkov.ViewModel.odyssey)
            }
        }
    }
}
