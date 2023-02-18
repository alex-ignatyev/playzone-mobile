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
            export(project(":shared:feature:auth:api"))
            export(project(":shared:feature:auth:presentation"))
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":shared:core"))
                implementation(project(":shared:kodein"))
                implementation(project(":shared:feature:auth:api"))
                implementation(project(":shared:feature:auth:presentation"))
            }
        }

        iosMain {
            dependencies {
                api(project(":shared:core"))
                api(project(":shared:kodein"))
                api(project(":shared:feature:auth:api"))
                api(project(":shared:feature:auth:presentation"))
            }
        }
    }
}
