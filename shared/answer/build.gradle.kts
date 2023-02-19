plugins {
    id("module-setup")
    id("multiplatform-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(Dependencies.Ktor.core)
            }
        }
    }
}

android { namespace = "com.sideki.test.shared.answer" }
