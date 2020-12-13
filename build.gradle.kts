plugins {
    id("org.jetbrains.kotlin.js") version "1.4.21"
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

    implementation(npm("axios", "0.21.0", generateExternals = true))
    implementation(npm("puppeteer", "5.5.0"))
    implementation(npm("form-data", "3.0.0"))
    implementation(npm("@google-cloud/secret-manager", "3.2.2"))
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
        val directory = "functions"
        from("build/js/packages/${project.name}/kotlin/${project.name}.js", "build/js/", "build/js/packages/${project.name}/package.json")
        exclude("**/packages/", "node_modules/", "node_modules.state", "yarn.lock")
        into("$directory/")
        rename { it.replace("${project.name}.js", "index.js") }

        doLast {
            val jsonFile = file("$directory/package.json")
            val texts = jsonFile.readLines()
                .map { it.replace("kotlin/${project.name}.js", "index.js") }
                .map { it.replace("file:${project.projectDir.absolutePath}/build/js/", "") }
            jsonFile.writeText(texts.joinToString("\n"))
        }
    }
}
