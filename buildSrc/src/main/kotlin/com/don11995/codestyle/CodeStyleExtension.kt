package com.don11995.codestyle

import com.don11995.codestyle.CodeStyle.Companion.setDestination
import com.don11995.codestyle.CodeStyle.Companion.setHtmlEnabled
import com.don11995.codestyle.CodeStyle.Companion.setInput
import com.don11995.codestyle.CodeStyle.Companion.setLintConfig
import com.don11995.codestyle.CodeStyle.Companion.setTxtEnabled
import com.don11995.codestyle.CodeStyle.Companion.setXmlEnabled
import org.gradle.api.Project
import org.gradle.api.file.ConfigurableFileCollection
import java.io.File

@Suppress("unused", "MemberVisibilityCanBePrivate")
open class CodeStyleExtension(private val project: Project) {

    private val rootDir = project.rootDir
    private val projectDir = project.projectDir

    var destination: String = "$rootDir${CodeStyle.PATH_SEPARATOR}reports"
        set(value) {
            field = value
            project.setDestination(value)
        }

    var isHtmlEnabled: Boolean = true
        set(value) {
            field = value
            project.setHtmlEnabled(value)
        }

    var isXmlEnabled: Boolean = false
        set(value) {
            field = value
            project.setXmlEnabled(value)
        }

    var isTxtEnabled: Boolean = false
        set(value) {
            field = value
            project.setTxtEnabled(value)
        }

    var excludeProjects: List<String> = emptyList()
        set(value) {
            field = value
            project.setInput(input)
        }

    var lintConfig: File = File(projectDir, "lint.xml")
        set(value) = project.run {
            field = value
            project.setLintConfig(value)
        }

    internal val input: ConfigurableFileCollection
        get() {
            val result = mutableListOf<String>()
            project.rootProject.subprojects {
                if (excludeProjects.contains(name)) {
                    println("Project \"$name\" excluded from code style check")
                    return@subprojects
                }
                result.add("$projectDir${File.separatorChar}src")
            }
            val file = File("$rootDir${File.separatorChar}$BUILD_SRC_REL_PATH")
            if (file.isDirectory) {
                if (excludeProjects.contains(BUILD_SRC_DIR_NAME)) {
                    println("Project \"$BUILD_SRC_DIR_NAME\" excluded from code style check")
                } else {
                    result.add(file.absolutePath)
                }
            }
            return project.files(result)
        }

    companion object {
        private const val BUILD_SRC_DIR_NAME = "buildSrc"

        private val BUILD_SRC_REL_PATH = "$BUILD_SRC_DIR_NAME${File.separatorChar}src"
    }
}
