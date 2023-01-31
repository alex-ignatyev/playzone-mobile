plugins {
    id("com.android.application")
    id("org.jetbrains.compose")
    kotlin("android")
}

android {
    compileSdk = 33
    defaultConfig {
        applicationId = "com.example.playzone_mobile.android"
        minSdk = 23
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(Dependencies.Android.Compose.foundation)
    implementation(Dependencies.Android.Compose.ui)
    implementation(Dependencies.Android.Compose.activity)
    implementation(Dependencies.Android.Compose.material)
    implementation(Dependencies.Android.Compose.icons)
    implementation(Dependencies.Android.Compose.tooling)

    implementation("com.google.android.material:material:1.6.1")
    implementation("androidx.appcompat:appcompat:1.5.0")
}