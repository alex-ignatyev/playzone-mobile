plugins {
    id("com.android.library")
}

android {
    compileSdk = findProperty("compileSdk").toString().toInt()

    defaultConfig {
        minSdk = findProperty("minSdk").toString().toInt()
        targetSdk = findProperty("targetSdk").toString().toInt()
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = findProperty("kotlinCompilerExtensionVersion").toString()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    sourceSets {
        named("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
            res.srcDirs("src/androidMain/res", "src/commonMain/resources")
        }
    }

    //FIXME необходимо для ksp и библиотеки ComposeDestinations, если версия ksp 1.8.0-1.0.9 и выше то можно удалить или нужно переделать под разные билд тайпы
    libraryVariants.all {
        addJavaSourceFoldersToModel(
            File(buildDir, "generated/ksp/android/androidDebug/kotlin")
        )
    }
}
