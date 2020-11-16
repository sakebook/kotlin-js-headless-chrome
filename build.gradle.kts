plugins {
    id("org.jetbrains.kotlin.js") version "1.4.10"
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
    implementation(npm("puppeteer", "5.4.1"))
    implementation(npm("form-data", "3.0.0"))
    implementation(npm("dotenv", "8.2.0"))
}

kotlin {
    sourceSets["main"].kotlin.srcDir("src/main/external")
    js {
        nodejs {
            runTask {
                nodeJs.versions.dukat.version = "0.5.8-rc.2"
            }
        }
        useCommonJs()
        binaries.executable()
    }
}


tasks {
    val packaging by creating(Copy::class) {
        from("build/js/packages/${project.name}/kotlin/${project.name}.js", "build/js/", "build/js/packages/${project.name}/package.json")
        exclude("**/packages/", "node_modules.state", "yarn.lock")
        into("build/functions/")
        rename { it.replace("${project.name}.js", "index.js") }
        println(project.projectDir.absolutePath)

        doLast {
            val jsonFile = file("build/functions/package.json")
            val texts = jsonFile.readLines()
                .map { it.replace("kotlin/${project.name}.js", "index.js") }
                .map { it.replace("file:${project.projectDir.absolutePath}/build/js/", "") }
                .dropLast(1).plus(",\"config\":{\"unsafe-perm\":true}}")
            jsonFile.writeText(texts.joinToString("\n"))

            val rc = file("build/functions/.npmrc")
            rc.createNewFile()
            rc.writeText("unsafe-perm=true")
        }
    }
}
