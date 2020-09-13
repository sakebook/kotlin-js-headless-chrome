plugins {
    id("org.jetbrains.kotlin.js") version "1.4.0"
}

group = "com.github.sakebook"
version = "0.0.1"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-js"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.0.0-RC")
    implementation("org.jetbrains.kotlinx:kotlinx-nodejs:0.0.7")
    implementation(npm("playwright", "1.3.0"))
//    implementation(npm("playwright", "1.3.0", generateExternals = true))
    implementation(npm("axios", "0.19.2", generateExternals = true))
    implementation(npm("form-data", "3.0.0"))
    implementation(npm("dotenv", "8.2.0"))
}

kotlin {
    sourceSets["main"].kotlin.srcDir("src/main/external")
    js {
        nodejs()
        useCommonJs()
        binaries.executable()
    }
}

tasks {
    val packaging by creating(Copy::class) {
        from("build/js/packages/${project.name}/kotlin/")
        into("build/js/packages/${project.name}/kotlin/")
        rename { it.replace("${project.name}.js", "index.js") }

        doLast {
            val jsonFile = file("build/js/packages/${project.name}/package.json")
            val texts = jsonFile.readLines()
                .map { it.replace("kotlin/${project.name}.js", "index.js") }
            jsonFile.writeText(texts.joinToString("\n"))
        }
    }
}
