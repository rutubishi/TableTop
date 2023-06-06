
plugins {
    kotlin("jvm")
    id("io.ktor.plugin")
    id("org.jetbrains.kotlin.plugin.serialization")
}

application {
    mainClass.set("io.ktor.server.netty.EngineMain")
}

dependencies {
    implementation(project(":common"))
    implementation(libs.bundles.server.main)
    implementation(project(mapOf("path" to ":common")))
    testImplementation(libs.bundles.server.test)
}