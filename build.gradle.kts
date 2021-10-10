plugins {
    kotlin("jvm") version "1.5.31"
    id("fabric-loom") version "0.10-SNAPSHOT"
    `java-library`
}

group = "com.moddedmc.std"
version = "0.1.0"

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

allprojects {
    apply {
        plugin("kotlin")
        plugin("fabric-loom")
        plugin("java")
        plugin("maven-publish")
    }

    repositories {
        maven("https://maven.modded-mc.com/repository/maven-public/") {
            name = "ModdedMC"
        }
        maven("https://maven.fabricmc.net/") {
            name = "Fabric"
        }
        mavenCentral()
    }

    dependencies {
        minecraft("com.mojang:minecraft:1.17.1")
        mappings(loom.officialMojangMappings())
        modApi("net.fabricmc:fabric-loader:0.11.6")
        implementation(kotlin("stdlib"))
        if (project.name != "std-lib")
            api(project(":std-lib"))

        testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    }
}