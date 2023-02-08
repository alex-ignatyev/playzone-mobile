plugins {
    id("module-setup")
    id("multiplatform-setup")
    kotlin("native.cocoapods")
}

version = "0.0.1"

kotlin {
    cocoapods {
        summary = "Test KMM App iOS SDK"
        homepage = "https://github.com/alex-ignatyev/playzone-mobile"
        ios.deploymentTarget = "14.0"

        framework {
            isStatic = true //если проект видит только синглтоны типо Object поиграть с этим
            transitiveExport = false
            baseName = "SharedSDK"
            export(project(":shared:core"))
            export(project(":shared:kodein"))
            export(project(":shared:screens"))
            export(project(":shared:auth:api"))
            export(project(":shared:auth:presentation"))
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":shared:core"))
                implementation(project(":shared:kodein"))
                implementation(project(":shared:screens"))
                implementation(project(":shared:auth:api"))
                implementation(project(":shared:auth:presentation"))
            }
        }

        iosMain {
            dependencies {
                api(project(":shared:core"))
                api(project(":shared:kodein"))
                api(project(":shared:screens"))
                api(project(":shared:auth:api"))
                api(project(":shared:auth:presentation"))
            }
        }
    }
}
