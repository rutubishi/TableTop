import org.jetbrains.compose.ExperimentalComposeLibrary

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    id("com.android.library")
    id("io.ktor.plugin") version "2.3.0"
}

group = "com.rutubishi"
version = "1.0-SNAPSHOT"

kotlin {
    android()
    jvm("server"){
        jvmToolchain(17)
    }
    jvm("desktop") {
        jvmToolchain(11)
    }

    @OptIn(ExperimentalComposeLibrary::class)
    sourceSets {

        val commonMain by getting {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material3)
                implementation(libs.constraintlayout.compose)
                implementation(libs.kamel.image)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(compose.uiTestJUnit4)
            }
        }
        val androidMain by getting {
            dependencies {
                api(libs.appcompat)
                api(libs.core.ktx)
            }
        }
        val androidAndroidTest by getting {
            dependencies {
                implementation(libs.junit4)
                implementation(compose.uiTestJUnit4)
            }
        }
        val desktopMain by getting {
            dependencies {
                api(compose.preview)
            }
        }

        val desktopTest by getting {
            dependencies {
                implementation(compose.uiTestJUnit4)
            }
        }

        val serverMain by getting

        val serverTest by getting

    }
}

android {
    compileSdk = 33
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

