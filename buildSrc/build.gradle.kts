plugins {
    `kotlin-dsl`
}

allprojects {
    repositories {
        jcenter()
        google()
        maven("https://plugins.gradle.org/m2/")
    }
}

gradlePlugin {
    plugins {
        register("com.don11995.codestyle") {
            id = "com.don11995.codestyle"
            implementationClass = "com.don11995.codestyle.CodeStyle"
            version = "1.1.0"
        }
        register("com.don11995.config") {
            id = "com.don11995.config"
            implementationClass = "com.don11995.config.ConfigPlugin"
            version = "1.0.0"
        }
    }
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}

dependencies {
    val gradleVersion = "3.5.3"
    val detektVersion = "1.4.0"
    val kotlinterVersion = "2.3.0"

    implementation("com.android.tools.build:gradle:$gradleVersion")
    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:$detektVersion")
    implementation("org.jmailen.gradle:kotlinter-gradle:$kotlinterVersion")
}
