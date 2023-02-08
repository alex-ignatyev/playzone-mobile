plugins {
    id("module-setup")
    id("multiplatform-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":shared:core"))
                implementation(project(":shared:screens"))

                implementation(project(":shared:auth:data"))

                implementation(Dependencies.Kodein.core)
            }
        }
    }
}
