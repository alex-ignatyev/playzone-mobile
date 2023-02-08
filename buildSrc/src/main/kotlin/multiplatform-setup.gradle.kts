plugins {
    id("com.android.library")
    kotlin("multiplatform")
    kotlin("kapt")
}

kotlin {
    android()
    ios()
    iosSimulatorArm64()

    val iosMain by sourceSets.getting
    val iosSimulatorArm64Main by sourceSets.getting
    iosSimulatorArm64Main.dependsOn(iosMain)

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "11"
    }
}
