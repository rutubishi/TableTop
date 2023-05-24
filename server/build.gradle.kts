plugins {
    kotlin("multiplatform")
    id("io.ktor.plugin") version "2.3.0"
}

group = "com.rutubishi"
version = "0.0.1"

kotlin{
    jvm("server"){
        jvmToolchain(17)
    }
    sourceSets{
        val serverMain by getting {
            dependencies {
                implementation(libs.bundles.server.main)
            }
        }
        val serverTest by getting {
            dependencies {
                implementation(libs.bundles.server.test)
            }
        }
    }
}

application {
    mainClass.set("com.rutubishi.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}


repositories {
    mavenCentral()
}

tasks.register("prepareKotlinBuildScriptModel"){

}
