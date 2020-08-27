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
    implementation(npm("playwright", "1.3.0"))
//    implementation(npm("playwright", "1.3.0", generateExternals = true))
}

kotlin {
    sourceSets["main"].kotlin.srcDir("src/main/external")
    js {
        nodejs {
        }
        useCommonJs()
        binaries.executable()
    }
}
