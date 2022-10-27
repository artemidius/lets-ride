@file:Suppress("UnstableApiUsage")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

include (":app")
include(":core")
include(":core:common")
include(":core:data")
include(":core:designsystem")
include(":core:navigation")
include(":feature")
include(":feature:civilian")
include(":feature:start")
