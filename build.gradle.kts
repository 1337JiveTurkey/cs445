plugins {
    id("java")
    id("application")
}

group = "edu.semo"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("edu.semo.cs445.StrategyDemonstration")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}