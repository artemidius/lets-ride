plugins {
    id("letsride.android.library")
    id("letsride.android.hilt")
    id("kotlinx-serialization")
}
val LETSRIDE_BACKEND_TOKEN by extra("@Z#MtvryYFa#ALed9#zh2UfdZEoJPzjH8unndNCR8pGNjmc6@89kPmTf%*vD4YP3")

android {
    defaultConfig {
        val token = System.getenv("LETSRIDE_BACKEND_TOKEN")?:""
        buildConfigField("String", "BACKEND_TOKEN", "\"$token\"")
    }
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:data"))

    implementation ("io.ktor:ktor-client-android:1.5.0")
    implementation ("io.ktor:ktor-client-serialization:1.5.0")
    implementation (libs.kotlinx.serialization.json)
    implementation ("io.ktor:ktor-client-logging-jvm:1.5.0")
}