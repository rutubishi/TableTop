
plugins {
    kotlin("jvm")
    id("io.ktor.plugin")
    id("org.jetbrains.kotlin.plugin.serialization")
}

application {
    mainClass.set("com.rutubishi.ApplicationKt")
}

dependencies {
    implementation(project(":common"))
    implementation(libs.bundles.server.main)
    implementation("io.ktor:ktor-server-auth-jvm:2.3.0")
    implementation("io.ktor:ktor-server-core-jvm:2.3.0")
    implementation("io.ktor:ktor-server-auth-jwt-jvm:2.3.0")
    testImplementation(libs.bundles.server.test)
}