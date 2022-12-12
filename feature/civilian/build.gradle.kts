plugins {
    id("letsride.android.feature")
}
dependencies {
    implementation(project(":core:network"))
    testImplementation (libs.robolectric)
}