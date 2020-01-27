import com.don11995.config.Config
import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id(Plugins.applicationPlugin)
    id(Plugins.kotlinAndroidPlugin)
    id(Plugins.kotlinAndroidExtPlugin)
    id(Plugins.kotlinKaptPlugin)
    id(Plugins.navigationArgsPlugin)
    id(Plugins.versionsPlugin)
    id(Plugins.codestylePlugin)
    id(Plugins.configPlugin)
}

android {

    // Used for LayoutContainer
    androidExtensions.isExperimental = true
    bundle.language.enableSplit = false
    // Enable databinding
    dataBinding.isEnabled = true

    appConfig {
        compileSdkVersion = 29
        buildToolsVersion = "29.0.2"
        applicationId = "com.don11995.oneplus.callrecorder"
        minSdkVersion = 21
        targetSdkVersion = 29
        majorVersion = 1
        minorVersion = 0
        buildVersion = 0
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType(KotlinCompile::class.java).all {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }

    compileSdkVersion(Config.compileSdkVersion)
    buildToolsVersion(Config.buildToolsVersion)

    defaultConfig {
        applicationId = Config.applicationId
        versionCode = Config.majorVersion * 1_00_00 +
                Config.minorVersion * 1_00 +
                Config.buildVersion
        versionName = "${Config.majorVersion}.${Config.minorVersion}.${Config.buildVersion}"

        minSdkVersion(Config.minSdkVersion)
        targetSdkVersion(Config.targetSdkVersion)
        resConfigs("en")
        setProperty("archivesBaseName", "${rootProject.name}-v$versionName")
    }

    buildTypes {
        getByName("debug") {
            isDebuggable = true
            isJniDebuggable = true
            isRenderscriptDebuggable = true
            isZipAlignEnabled = true
            versionNameSuffix = "-debug"
            splits.abi.isEnable = false
            splits.density.isEnable = false
            aaptOptions.cruncherEnabled = false
        }

        getByName("release") {
            isDebuggable = false
            isJniDebuggable = false
            isRenderscriptDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
            isZipAlignEnabled = true

            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"))
            proguardFiles(*fileTree("proguard").toList().toTypedArray())
            for (tmp in proguardFiles) {
                println("Proguard rules added: ${tmp.path}")
            }
        }
    }
}

dependencies {
    // Kotlin
    implementation(Deps.kotlinStdLib)
// Koltin Ext
    implementation(Deps.coreKtxLib)
    fragmentLibs()
    coroutinesLibs()
// AppCompat
    implementation(Deps.annotationLib)
    implementation(Deps.appCompatLib)
    constraintLayoutLibs()
    navigationLibs()
    lifecycleLibs()
// Other libs
    simpleLogLib()
    koinLibs()
    leakCanaryLibs()
    workManagerLibs()
}

// Libraries version plugin configuration
fun isNonStable(version: String): Boolean =
    listOf("alpha", "beta", "rc", "cr", "m", "preview", "b", "ea").any {
        version.contains(it, true)
    }

tasks.withType<DependencyUpdatesTask> {
    resolutionStrategy {
        componentSelection {
            all {
                if (isNonStable(candidate.version)) {
                    reject("Release candidate")
                }
            }
        }
    }
}
