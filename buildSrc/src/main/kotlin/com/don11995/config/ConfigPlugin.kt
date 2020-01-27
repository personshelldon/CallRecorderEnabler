package com.don11995.config

import com.android.build.gradle.AppExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

@Suppress("unused")
class ConfigPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = target.run {
        extensions.findByType(AppExtension::class.java)
            ?: throw IllegalArgumentException(
                "Project \"$name\" does not contain com.android.application " +
                        "plugin needed for CodeStyle plugin"
            )
        extensions.create(
            EXTENSION_NAME,
            ConfigExtension::class.java
        )
    }

    companion object {
        private const val EXTENSION_NAME = "appConfig"
    }
}
