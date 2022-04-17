import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
    application
}

group = "me.gaston"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    //implementation("org.jetbrains.kotlin:kotlin-script-runtime:1.5.21")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}