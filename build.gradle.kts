plugins {
    id("java")
    kotlin("jvm") version "1.9.20-RC"
}



allprojects {
    apply {
        plugin("java")
    }

    dependencies {
        testImplementation(platform("org.junit:junit-bom:5.9.1"))
        testImplementation("org.junit.jupiter:junit-jupiter")
    }

    group = "org.example"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(project(":models"))
    implementation("com.fasterxml.jackson.core:jackson-databind:2.13.4") // зависимость Jackson для сериализации
    implementation(project(":generator")) // зависимость от модуля "generator"
    implementation(project(":deserialization"))
    implementation(project(":serialization"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}