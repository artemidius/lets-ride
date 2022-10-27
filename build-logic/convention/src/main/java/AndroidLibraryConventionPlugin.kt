@file:Suppress("unused")

import com.android.build.gradle.LibraryExtension
import com.s808.letsride.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("kotlin-parcelize")
            }

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = 33

                val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
                dependencies {
                    add("testImplementation", libs.findLibrary("junit.base").get())
                    add("testImplementation", libs.findLibrary("junit.ext").get())
                    add("testImplementation", libs.findLibrary("kotlinx.coroutines.test").get())
                    add("testImplementation", libs.findLibrary("mockito.kotlin").get())
                }
            }

            configurations.configureEach {
                resolutionStrategy {
                    force("org.objenesis:objenesis:2.6")
                }
            }
        }
    }
}