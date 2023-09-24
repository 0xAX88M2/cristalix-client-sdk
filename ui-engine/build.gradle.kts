plugins {
    kotlin("jvm") version "1.4.21"
}

apply("plugin" to "kotlin")

group = "ru.cristalix"

dependencies {
    implementation("org.lwjgl.lwjgl", "lwjgl_util", "2.9.3")
    implementation("io.netty", "netty-buffer", "4.1.58.Final")
    implementation("com.mojang", "authlib", "2.1.28")
    implementation("dev.xdark", "feder", "live-SNAPSHOT")
    implementation("dev.xdark", "clientapi", "2.0.15")
    implementation("com.google.guava", "guava", "21.0")
    implementation("com.google.code.gson", "gson", "2.8.6")
    implementation("it.unimi.dsi", "fastutil", "8.3.1")
    compileOnly(kotlin("stdlib"))
}

tasks.compileJava.get().run {
    sourceCompatibility = "1.8"
    targetCompatibility = "1.8"
}

tasks.compileKotlin.get().kotlinOptions.run {
    jvmTarget = "1.8"
}

publishing {
    publications {
        create<MavenPublication>("uiengine") {
            groupId = "ru.cristalix"
            artifactId = "uiengine"
            version = "6.0.20"
            from(components["java"])
        }
    }
}

