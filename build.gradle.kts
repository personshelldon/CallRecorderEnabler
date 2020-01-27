import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {

    repositories {
        jcenter()
        google()
    }

    dependencies {
        classpath(Deps.gradleClasspath)
        classpath(Deps.kotlinClasspath)
        classpath(Deps.gradleUpdatesClasspath)
        classpath(Deps.navigationArgsClasspath)
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        jcenter()
        google()
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.allWarningsAsErrors = true
}
