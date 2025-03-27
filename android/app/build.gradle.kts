plugins {
    id("com.android.application")
    id("kotlin-android")
    // Apply the Google Services plugin for Firebase
    id("com.google.gms.google-services")
    // The Flutter Gradle Plugin must be applied after the Android and Kotlin Gradle plugins.
    id("dev.flutter.flutter-gradle-plugin")
}

android {
    namespace = "com.example.edulife_ai"
    compileSdk = 34 // Latest stable compileSdk as of March 2025

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    defaultConfig {
        applicationId = "com.example.edulife_ai"
        minSdk = 21 // Minimum SDK supported by Flutter for broader compatibility
        targetSdk = 34 // Match compileSdk
        versionCode = flutter.versionCode
        versionName = flutter.versionName
        multiDexEnabled = true // Enable multidex for Firebase compatibility
    }

    buildTypes {
        release {
            // Signing with debug keys for now; update for production
            signingConfig = signingConfigs.getByName("debug")
            minifyEnabled = false
            proguardFiles getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
        }
        debug {
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}

flutter {
    source = "../.."
}

dependencies {
    // Add Firebase dependencies explicitly (optional, as google-services plugin handles most)
    implementation platform('com.google.firebase:firebase-bom:32.7.0') // Latest Firebase BOM as of March 2025
    implementation 'com.google.firebase:firebase-auth'
    implementation 'com.google.firebase:firebase-firestore'
    implementation 'com.google.firebase:firebase-analytics'
    // Add multidex support
    implementation 'androidx.multidex:multidex:2.0.1'
}