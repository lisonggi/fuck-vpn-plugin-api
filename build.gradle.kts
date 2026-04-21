plugins {
    kotlin("jvm") version "2.3.0"
    id("com.github.jk1.dependency-license-report") version "3.1.1"  // x-release-please-version
    id ("maven-publish")
}
licenseReport {
    outputDir = "$projectDir/licenses"

    renderers = arrayOf(
        com.github.jk1.license.render.InventoryMarkdownReportRenderer(),
    )
}
group = "com.song"
version = "1.1"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
}
publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            groupId = "com.song"
            artifactId = "fuck-vpn-plugin-api"
            version = "library"

            from(components["java"])
        }
    }
}