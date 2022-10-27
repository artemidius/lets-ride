plugins {
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    id ("org.jetbrains.kotlin.android") version "1.7.10" apply false
}