
plugins {
    kotlin("jvm")
    id("io.ktor.plugin")
}

application {
    mainClass.set("com.rutubishi.ApplicationKt")
}

dependencies {
    implementation(project(":common"))
    implementation(libs.bundles.server.main)
    testImplementation(libs.bundles.server.test)
}