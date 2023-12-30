import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
    kotlin("plugin.lombok") version "1.9.0"
    id("io.freefair.lombok") version "8.1.0"
}

group = "indi.midreamsheep.schatapp.desktop"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    implementation(compose.desktop.currentOs)
    implementation(compose.material3)
    implementation(compose.ui)
    implementation("org.xerial:sqlite-jdbc:3.41.2.2")
    /*导入本地jar包*/
    implementation(files("libs/SChatCommunicationFramework.jar"))
    implementation(files("libs/SIOC.jar"))
    implementation(files("libs/DenpendenceInjector.jar"))
    implementation(files("libs/PackageScanner.jar"))
    implementation("io.reactivex.rxjava2:rxjava:2.2.10")

}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "desktop-k"
            packageVersion = "1.0.0"
        }
    }
}
