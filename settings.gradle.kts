pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }

    plugins {
        kotlin("multiplatform").version(extra["kotlin.version"] as String)
        kotlin("android").version(extra["kotlin.version"] as String)
        id("com.android.application").version(extra["agp.version"] as String)
        id("com.android.library").version(extra["agp.version"] as String)
        id("org.jetbrains.compose").version(extra["compose.version"] as String)
        id("org.jetbrains.kotlin.jvm") version "1.8.0"
        id("io.ktor.plugin") version "2.3.0"
        id("org.jetbrains.kotlin.plugin.serialization") version "1.8.21"
    }
}

rootProject.name = "TableTop"

include(":android", ":desktop", ":common")
include(":androidMain")
include(":client-data")
include(":server")
