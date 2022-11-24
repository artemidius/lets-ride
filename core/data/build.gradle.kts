plugins {
    id("letsride.android.library")
    id("letsride.android.hilt")
    id("kotlinx-serialization")
    alias(libs.plugins.ksp)
}

dependencies {
    implementation(project(":core:common"))

    ksp(libs.room.compiler)
    implementation(libs.androidx.datastore.prefs)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
}

