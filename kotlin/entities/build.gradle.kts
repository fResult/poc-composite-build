plugins {
  kotlin("jvm") version "2.2.0"
  id("java-library")
}

group = "com.fResult"
version = "0.0.1-SNAPSHOT"
description = "entities"

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(21)
  }
}

repositories {
  mavenCentral()
}

dependencies {
  api("org.springframework.boot:spring-boot-starter-data-r2dbc:3.5.5")

  implementation("org.jetbrains.kotlin:kotlin-reflect")

  testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
  implementation(kotlin("stdlib-jdk8"))
}
