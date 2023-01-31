plugins {
    id("multiplatform-setup")
    id("android-setup")
    //kotlin("plugin.serialization") //FIXME Проверить нужен ли
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(Dependencies.Kotlin.Serialization.serialization)
                api(Dependencies.Kotlin.Coroutines.core)

                api(Dependencies.Kodein.core)

                api(Dependencies.Ktor.core)
                implementation(Dependencies.Ktor.logging)
                implementation(Dependencies.Ktor.negotiation)
                implementation(Dependencies.Ktor.serialization)

                api(Dependencies.SqlDelight.core)
            }
        }

        androidMain {
            dependencies {
                implementation(Dependencies.Ktor.android)
                implementation(Dependencies.SqlDelight.android)
            }
        }

        iosMain {
            dependencies {
                implementation(Dependencies.Ktor.ios)
                implementation(Dependencies.SqlDelight.ios)
            }
        }
    }
}
