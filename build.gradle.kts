import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

group = "com.eduard-gorshkov"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    maven("https://jitpack.io")
}

kotlin {
    jvm {
        jvmToolchain(11)
        withJava()
    }
    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation("org.jetbrains.compose.material3:material3-desktop:1.4.0")
                implementation(compose.desktop.currentOs)
                implementation("io.github.alexgladkov:odyssey-core:1.3.1") // For core classes
                implementation("io.github.alexgladkov:odyssey-compose:1.3.1") // For compose extensions
                implementation("com.github.Dansoftowner:jSystemThemeDetector:3.6")
                implementation("io.github.oshai:kotlin-logging-jvm:4.0.0-beta-22")

                implementation("com.arkivanov.decompose:decompose-jvm:0.2.5")
                implementation("com.arkivanov.decompose:extensions-compose-jetbrains-jvm:0.2.5")
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "proektnyp"
            packageVersion = "1.0.0"
        }
    }
}
