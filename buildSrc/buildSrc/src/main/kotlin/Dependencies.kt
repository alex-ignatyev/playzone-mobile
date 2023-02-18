object Dependencies {

    object Gradle {
        const val gradlePlugin = "com.android.tools.build:gradle:7.2.1"
    }

    object Kotlin {
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20"

        object Serialization {
            const val gradlePlugin = "org.jetbrains.kotlin:kotlin-serialization:1.6.21"
            const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-core:1.3.0"
        }

        object Coroutines {
            private const val version = "1.6.4"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        }
    }

    object Kodein {
        const val core = "org.kodein.di:kodein-di:7.18.0"
    }

    object Koin {

    }

    object Settings {
        const val core = "com.russhwolf:multiplatform-settings:1.0.0-RC"
        const val noargs = "com.russhwolf:multiplatform-settings-no-arg:1.0.0-RC"
    }

    object Ktor {
        private const val version = "2.1.0"

        const val core = "io.ktor:ktor-client-core:$version"
        const val json = "io.ktor:ktor-client-json:$version"
        const val ios = "io.ktor:ktor-client-ios:$version"
        const val negotiation = "io.ktor:ktor-client-content-negotiation:$version"
        const val kotlin_json = "io.ktor:ktor-serialization-kotlinx-json:$version"
        const val serialization = "io.ktor:ktor-serialization-kotlinx-json:$version"
        const val logging = "io.ktor:ktor-client-logging:$version"
        const val android = "io.ktor:ktor-client-android:$version"
        const val okhttp = "io.ktor:ktor-client-okhttp:$version"
    }

    object SqlDelight {
        private const val version = "1.5.3"

        const val gradlePlugin = "com.squareup.sqldelight:gradle-plugin:$version"
        const val core = "com.squareup.sqldelight:runtime:$version"
        const val android = "com.squareup.sqldelight:android-driver:$version"
        const val desktop = "com.squareup.sqldelight:sqlite-driver:$version"
        const val ios = "com.squareup.sqldelight:native-driver:$version"
    }

    object Image {
        object Coil {
            const val version = "2.2.2"
            const val core = "io.coil-kt:coil:$version"
            const val compose = "io.coil-kt:coil-compose:$version"
        }
    }

    object Android {
        const val gradlePlugin = "com.android.tools.build:gradle:7.3.0"

        const val splash = "androidx.core:core-splashscreen:1.0.0"

        object Compose {
            private const val version = "1.3.0"
            const val gradlePlugin = "org.jetbrains.compose:compose-gradle-plugin:$version"
            const val ui = "androidx.compose.ui:ui:$version"
            const val foundation = "androidx.compose.foundation:foundation:$version"
            const val tooling = "androidx.compose.ui:ui-tooling:$version"
            const val material = "androidx.compose.material:material:$version"
            const val icons = "androidx.compose.material:material-icons-extended:$version"
            const val activity = "androidx.activity:activity-compose:1.5.1"
        }

        object Navigation {
            private const val version = "1.7.33-beta"
            const val core = "io.github.raamcosta.compose-destinations:animations-core:$version"
            const val ksp = "io.github.raamcosta.compose-destinations:ksp:$version"
        }
    }

    object AlexGladkov {
        object ViewModel {
            private const val version = "0.7.1"
            const val core = "com.adeo:kviewmodel:$version"
            const val compose = "com.adeo:kviewmodel-compose:$version"
        }
    }
}
