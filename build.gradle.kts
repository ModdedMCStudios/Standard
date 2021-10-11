plugins {
    kotlin("jvm") version "1.5.31"
    id("fabric-loom") version "0.10-SNAPSHOT"
    `java-library`
}

group = "com.moddedmc.std"
version = "0.1.0"

data class Modules(val modules: Map<String, ModuleModel>)
data class ModuleModel(val dependencies: List<String>, val devOnly: Boolean?)

val json = com.google.gson.Gson().fromJson(File("modules.json").readText(), Modules::class.java)

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

    version = rootProject.version


    val dev by configurations.creating

    afterEvaluate {
        tasks.processResources {
            inputs.property("version", project.version)

            filesMatching("fabric.mod.json") {
                expand("version" to project.version)
            }
        }
        tasks.remapJar {
            input.set(file("${project.buildDir}/libs/${project.name}-${project.version}-dev.jar"))
            archiveFileName.set("${project.name}-${project.version}.jar")
        }
        artifacts {
            add("dev", file("${project.buildDir}/libs/${project.name}-${project.version}-dev.jar")) {
                builtBy(tasks.jar)
            }
        }
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

    tasks.jar {
        archiveClassifier.set("dev")
    }

    dependencies {
        minecraft("com.mojang:minecraft:1.17.1")
        mappings(loom.officialMojangMappings())
        modApi("net.fabricmc:fabric-loader:0.11.6")
        implementation(kotlin("stdlib"))

        val module = json.modules[project.name]
        module?.dependencies?.forEach {
            api(project(":$it", configuration = "dev"))
        }

        testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    }
}

json.modules.forEach { (key, value) ->
    tasks.remapJar {
        dependsOn(":${key}:remapJar")
    }
}

repositories {
    maven("https://maven.terraformersmc.com/releases/")
}

dependencies {
    afterEvaluate {
        json.modules.forEach { (t, u) ->
            api(project(":$t", configuration = "dev"))
            include(project(":$t"))
        }
    }
    modRuntimeOnly("com.terraformersmc:modmenu:2.0.14")
}