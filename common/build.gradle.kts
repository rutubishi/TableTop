import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.compose.compose

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    id("com.android.library")
}

group = "com.rutubishi"
version = "1.0-SNAPSHOT"

kotlin {
    android()
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
                api("androidx.appcompat:appcompat:1.5.1")
                api("androidx.core:core-ktx:1.9.0")
            }
        }
        val androidAndroidTest by getting {
            dependencies {
                implementation("junit:junit:4.13.2")
                implementation(project(":android"))
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
    }
}

android {
    compileSdk = 33
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 24
        targetSdk = 33
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}