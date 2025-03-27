// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    ext {
        // Define Kotlin version
        kotlin_version = '1.9.22' // Latest stable version as of March 2025
    }
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        // Add the Google Services plugin for Firebase
        classpath 'com.google.gms:google-services:4.4.1' // Latest version as of March 2025
        // Add Kotlin plugin
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
        // Add Flutter Gradle plugin (already included via id, but ensure compatibility)
        classpath 'dev.flutter:flutter-gradle-plugin:1.0.0' // Ensure this matches your Flutter version
    }
}

// Configure build directories
val newBuildDir: Directory = rootProject.layout.buildDirectory.dir("../../build").get()
rootProject.layout.buildDirectory.value(newBuildDir)

subprojects {
    val newSubprojectBuildDir: Directory = newBuildDir.dir(project.name)
    project.layout.buildDirectory.value(newSubprojectBuildDir)
}

subprojects {
    project.evaluationDependsOn(":app")
}

tasks.register<Delete>("clean") {
    delete(rootProject.layout.buildDirectory)
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}