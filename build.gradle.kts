plugins {
    kotlin("jvm") version "2.0.20"
    kotlin("plugin.serialization") version "2.0.20"
    kotlin("kapt") version "2.0.20" // Kotlin Annotation Processing Tool (KAPT)
    application
}

group = "com.performix.transformer"
version = "1.0"

repositories {
    mavenCentral()
}

val ktorVersion = "3.0.0"
val kotlinxVersion = "1.9.0"
val apacheLogging = "2.20.0"
val jacksonVersion = "2.18.0"
val daggerVersion = "2.52"

dependencies {

    // Kotlin Core Dependencies
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinxVersion")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
    implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")
    implementation("com.jayway.jsonpath:json-path:2.9.0")

    // Logging
    implementation("org.apache.logging.log4j:log4j-api-kotlin:1.0.0")  // Kotlin-Logging
    implementation("org.apache.logging.log4j:log4j-api:$apacheLogging")
    implementation("org.apache.logging.log4j:log4j-core:$apacheLogging")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

kapt {
    correctErrorTypes = true
    arguments {
        arg("dagger.formatGeneratedSource", "disabled")
    }
}

application {
    mainClass.set("com.performix.transformer.MainApplicationKt")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}