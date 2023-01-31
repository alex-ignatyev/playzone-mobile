/* plugins {
    // https://kotlinlang.org/docs/releases.html#release-details
    val kotlinVersion = "1.7.20"
    // https://github.com/diffplug/spotless/tags
    val spotlessVersion = "6.11.0"
    // https://github.com/Kotlin/dokka/tags
    val dokkaVersions = "1.5.30"
    // https://kotlinlang.org/docs/multiplatform.html
    val multiplatformVersion = "1.7.10"
    // https://github.com/mpetuska/npm-publish
    val npmPublishVersion = "3.0.3"
    // https://developer.android.com/studio/releases/gradle-plugin#updating-plugin
    val androidVersion = "7.3.1"

    // android
    id("com.android.application").version(androidVersion).apply(false)
    id("com.android.library").version(androidVersion).apply(false)
    kotlin("android").version(kotlinVersion).apply(false)

    // common
    kotlin("multiplatform").version(multiplatformVersion).apply(false)
    kotlin("plugin.serialization").version(kotlinVersion).apply(false)
    id("dev.petuska.npm.publish").version(npmPublishVersion).apply(false)

    // gradle
    id("com.diffplug.spotless").version(spotlessVersion)
    id("org.jetbrains.dokka").version(dokkaVersions)
} */

buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Dependencies.Kotlin.gradlePlugin)
        classpath(Dependencies.Gradle.gradlePlugin)
        classpath("com.codingfeline.buildkonfig:buildkonfig-gradle-plugin:0.13.3") // https://github.com/yshrsmz/BuildKonfig
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}