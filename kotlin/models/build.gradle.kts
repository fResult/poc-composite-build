plugins {
  kotlin("jvm") version "2.2.0"
  id("java-library")
}

group = "com.fresult"
version = "0.0.1-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  implementation("com.fresult:entities:0.0.1-SNAPSHOT")
  testImplementation(kotlin("test"))
}

tasks.test {
  useJUnitPlatform()
}

kotlin {
  jvmToolchain(21)
}
