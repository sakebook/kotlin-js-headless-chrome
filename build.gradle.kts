plugins {
    id("org.jetbrains.kotlin.js") version "1.4.0"
}

group = "com.github.sakebook"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-js"))
}

kotlin {
    js {
        nodejs {
        }
        binaries.executable()
    }
}