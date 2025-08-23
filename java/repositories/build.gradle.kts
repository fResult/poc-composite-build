plugins {
  id("java-library")
  id("org.springframework.boot") version "3.5.5" apply false
  id("io.spring.dependency-management") version "1.1.7"
}

group = "com.fResult"
version = "0.0.1-SNAPSHOT"
description = "repositories"

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(21)
  }
}

repositories {
  mavenCentral()
}

dependencyManagement {
  imports {
    mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
  }
}

dependencies {
  implementation("com.fResult:entities:0.0.1-SNAPSHOT")

  api("org.springframework.boot:spring-boot-starter-data-r2dbc")

  runtimeOnly("com.h2database:h2")
  runtimeOnly("io.r2dbc:r2dbc-h2")

  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("io.projectreactor:reactor-test")

  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}
