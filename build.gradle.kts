import org.gradle.internal.impldep.org.bouncycastle.cms.RecipientId.password

plugins {
    `maven-publish`
    `java-library`
}

allprojects {
    group = "ru.cristalix"
    version = "6.0.0"
}

subprojects {

    apply("plugin" to "maven-publish")

    repositories {
        maven{
            url = uri("http://51.83.213.14/repo/private")
            isAllowInsecureProtocol = true
            credentials {
                username = System.getenv("DL_REPO_LOGIN") as String
                password = System.getenv("DL_REPO_PASSWORD") as String
            }
        }
        maven {
            name = "Mojang"
            url = uri("https://libraries.minecraft.net/")
        }
        maven {
            url = uri("https://repository.anfanik.me/public")
        }
        mavenCentral()
    }


    afterEvaluate {
        tasks.jar {
            from(sourceSets.main.get().allSource)
        }
        publishing {
            repositories {
                maven{
                    url = uri("http://51.83.213.14/repo/private")
                    isAllowInsecureProtocol = true
                    credentials {
                        username = System.getenv("DL_REPO_LOGIN") as String
                        password = System.getenv("DL_REPO_PASSWORD") as String
                    }
                }
            }
        }
    }
}


