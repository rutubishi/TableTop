import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

group = "com.rutubishi"
version = "1.0-SNAPSHOT"


kotlin {
    jvm("desktop") {
        jvmToolchain(11)
        withJava()
    }
    sourceSets {
        val desktopMain by getting {
            dependencies {
                implementation(project(libs.versions.shared.get()))
                implementation(compose.desktop.currentOs)
            }
        }
        val desktopTest by getting {
            dependencies {
                implementation(libs.test.compose)
            }

        }
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "TableTop"
            packageVersion = "1.0.0"
        }
    }
}
