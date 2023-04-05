plugins {
    id("java")
}

java.sourceCompatibility = JavaVersion.VERSION_1_8
java.targetCompatibility = JavaVersion.VERSION_1_8

base.archivesName.set(project.properties["archives_base_name"] as String)
version = project.properties["plugin_version"] as String
group = project.properties["maven_group"] as String

repositories {
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")

    mavenLocal()
    mavenCentral()
}

dependencies {
    compileOnly("org.spigotmc:spigot:${project.properties["minecraft_version"]}-${project.properties["spigot_version"]}")
}

tasks {
    processResources {
        inputs.property("version", project.version)

        filesMatching("plugin.yml") {
            expand("version" to project.version)
        }
    }
}