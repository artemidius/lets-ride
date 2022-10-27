plugins {
    id("letsride.android.library")
    id("letsride.android.hilt")
    alias(libs.plugins.ksp)
}

dependencies {
    implementation(project(":core:common"))

    ksp(libs.room.compiler)
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
}

