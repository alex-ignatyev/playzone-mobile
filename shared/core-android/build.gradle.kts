plugins {
    id("multiplatform-compose-setup") //FIXME Разобраться
    id("android-setup") //FIXME Разобраться
}

kotlin {
    sourceSets {
        androidMain {
            dependencies {
                //FIXME Дописать описание имрортов
                implementation(project(":shared:core"))
                implementation(project(":shared:screens"))
                implementation(project(":shared:theme"))

                // Модули собираются в DI дерево - AndroidPlatformSDK
                implementation(project(":shared:games:data"))

                // Модули собирается в NavGraph дерево - generateGraph()
                implementation(project(":shared:games:compose"))

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
