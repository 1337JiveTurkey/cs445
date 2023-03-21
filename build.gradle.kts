plugins {
    id("java")
    id("application")
}

group = "edu.semo"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("edu.semo.cs445.strategy.StrategyDemonstration")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("commons-cli:commons-cli:1.5.0")
    implementation("org.junit.jupiter:junit-jupiter:5.9.2")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}