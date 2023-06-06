import org.jetbrains.compose.ExperimentalComposeLibrary

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    id("com.android.library")
    id("com.apollographql.apollo3")
}

group = "com.rutubishi"
version = "1.0-SNAPSHOT"

kotlin {
    android {
        jvmToolchain(11)
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
                api(libs.apollo.runtime)
                api(libs.koin.core)
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
                api(libs.bundles.dev)
            }
        }
        val androidAndroidTest by getting {
            dependencies {
                implementation(libs.junit4)
            }
        }
        val desktopMain by getting {
            dependencies {
                api(compose.preview)
            }
        }

        val desktopTest by getting
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

apollo {
    service("service"){
        schemaFile.set(file("src/commonMain/graphql/schema.graphqls"))
        packageName.set("com.rutubishi.common.data.network")
    }
}