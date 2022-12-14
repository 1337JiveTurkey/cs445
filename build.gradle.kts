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
    implementation("org.junit.jupiter:junit-jupiter:5.9.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}