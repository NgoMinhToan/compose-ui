pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven {
            url = uri("https://androidx.dev/snapshots/builds/13634847/artifacts/repository") // material3AdaptiveNav3 = "1.0.0-SNAPSHOT"
//            content {
//                includeModule("androidx.compose.material3.adaptive", "adaptive-navigation3")
//            }
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://androidx.dev/snapshots/builds/13634847/artifacts/repository") // material3AdaptiveNav3 = "1.0.0-SNAPSHOT"
//            content {
//                includeModule("androidx.compose.material3.adaptive", "adaptive-navigation3")
//            }
        }
    }
}

rootProject.name = "Project1"
include(":app")
