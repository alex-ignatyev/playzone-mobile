plugins {
    id("com.android.application")
    id("org.jetbrains.compose")
    kotlin("android")
}

// Данные для findProperty находятся в gradle.properties, лучше заменить на object
android {
    compileSdk = findProperty("compileSdk").toString().toInt()

    defaultConfig {
        applicationId = "com.sideki.test.android"
        minSdk = findProperty("minSdk").toString().toInt()
        targetSdk = findProperty("targetSdk").toString().toInt()
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = findProperty("kotlinCompilerExtensionVersion").toString()
    }

    kotlinOptions {
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":shared:core"))
    implementation(project(":shared:core-android"))
    implementation(project(":shared:games:api"))

    implementation("androidx.core:core-splashscreen:1.0.0")

    implementation(Dependencies.Android.Compose.activity)

    /*implementation(Dependencies.Android.Compose.foundation)
    implementation(Dependencies.Android.Compose.ui)

    implementation(Dependencies.Android.Compose.material)
    implementation(Dependencies.Android.Compose.icons)
    implementation(Dependencies.Android.Compose.tooling)*/
}
