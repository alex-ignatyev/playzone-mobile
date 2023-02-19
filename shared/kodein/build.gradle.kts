plugins {
    id("module-setup")
    id("multiplatform-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":shared:core"))
                implementation(project(":shared:feature:auth:data"))

                implementation(Dependencies.Kodein.core)
            }
        }
    }
}

android { namespace = "com.sideki.test.shared.kodein" }
