pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.modded-mc.com/repository/maven-public/") {
            name = "ModdedMC"
        }
        maven("https://maven.fabricmc.net/") {
            name = "Fabric"
        }
        mavenLocal()
    }
}

rootProject.name = "Standard"

include("std-lib")
include("std-resources")
include("std-multipart")
include("std-power")