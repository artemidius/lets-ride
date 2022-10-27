plugins {
    id ("letsride.android.application")
    id ("letsride.android.application.compose")
    id ("letsride.android.hilt")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.s808.letsride"
    defaultConfig {
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.1"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:data"))
    implementation(project(":core:designsystem"))
    implementation(project(":core:navigation"))
    implementation(project(":feature:civilian"))
    implementation(project(":feature:start"))

    implementation (libs.ktx.core)
    implementation (libs.bundles.android.ui)
    implementation (libs.bundles.compose)

    testImplementation (libs.junit.base)
    androidTestImplementation (libs.junit.ext)
}