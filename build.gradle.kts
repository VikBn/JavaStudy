plugins {
    id("java")
}

group = "org.bchupka"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    testImplementation("org.mockito:mockito-core:4.6.1")  // Use the latest version
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.2")  // Use the latest version
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.7.2")  // Use the latest version

}

tasks.test {
    useJUnitPlatform()
}