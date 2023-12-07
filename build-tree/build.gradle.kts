plugins {
    id("application")
}

dependencies {
    implementation(files("../lib/gradle-tooling-api-shaded-8.6-spike-0.jar"))
    runtimeOnly("org.slf4j:slf4j-simple:1.7.10")
}

application {
    mainClass = "Main"
}

(tasks.run) {
    System.getProperty("projectDir")?.let { projectDir ->
        args(projectDir)
    }
}

repositories {
    mavenCentral()
}
