plugins {
    id("org.jetbrains.kotlin.jvm") version "1.4.30"
}

group = "ru.cristalix"

dependencies {
    compileOnly(kotlin("stdlib"))
    implementation("org.lwjgl.lwjgl", "lwjgl_util", "2.9.3")
    implementation("io.netty", "netty-buffer", "4.1.58.Final")
    implementation("com.mojang", "authlib", "2.1.28")
    implementation("dev.xdark", "feder", "live-SNAPSHOT")
    implementation("dev.xdark", "clientapi", "2.0.15")
    implementation("com.google.guava", "guava", "21.0")
    implementation("com.google.code.gson", "gson", "2.8.6")
    implementation("it.unimi.dsi", "fastutil", "8.3.1")
}

tasks.compileKotlin.get().kotlinOptions.jvmTarget = "1.8"

publishing {
    publications {
        create<MavenPublication>("clientSdk") {
            groupId = "ru.cristalix"
            artifactId = "client-sdk"
            version = "6.0.0"
            from(components["java"])
        }
    }
}
