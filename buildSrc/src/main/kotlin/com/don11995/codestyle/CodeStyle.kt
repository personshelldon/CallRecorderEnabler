package com.don11995.codestyle

import Plugins
import com.android.build.gradle.AppExtension
import com.android.build.gradle.BaseExtension
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.create
import org.jmailen.gradle.kotlinter.KotlinterExtension
import org.jmailen.gradle.kotlinter.tasks.FormatTask
import org.jmailen.gradle.kotlinter.tasks.LintTask
import java.io.File

@Suppress("unused")
class CodeStyle : Plugin<Project> {

    override fun apply(target: Project): Unit = target.run {
        val baseExtension = extensions.findByType(AppExtension::class.java)
            ?: throw IllegalArgumentException(
                "Project \"$name\" does not contain com.android.application " +
                        "plugin needed for CodeStyle plugin"
            )

        apply(plugin = Plugins.detektPlugin)
        apply(plugin = Plugins.kotlinterPlugin)

        createKtLintTask()
        createKtFormatTask()
        createCodeStyleTask()

        val ext = extensions.create(
            EXTENSION_NAME,
            CodeStyleExtension::class.java,
            this
        )
        // Default config
        val detektConfigFile = files(
            "$rootDir$RELATIVE_CONFIG_FOLDER$PATH_SEPARATOR$DEFAULT_DETEKT_CONFIG_NAME"
        )
        setDestination(ext.destination)
        setHtmlEnabled(ext.isHtmlEnabled)
        setXmlEnabled(ext.isXmlEnabled)
        setTxtEnabled(ext.isTxtEnabled)
        setInput(ext.input)
        setLintConfig(ext.lintConfig)
        configure<DetektExtension> {
            config = detektConfigFile
            parallel = true
        }
        configure<KotlinterExtension> {
            ignoreFailures = false
        }
        baseExtension.lintOptions {
            isWarningsAsErrors = true
            isAbortOnError = true
        }
    }

    private fun Project.createKtLintTask(): Task {
        val task = tasks.findByName(TASK_KTLINT)
        if (task != null) return task
        return tasks.create(TASK_KTLINT, LintTask::class) {
            group = "verification"
            setDisabledRules(DISABLED_KTLINT_RULES)
        }
    }

    private fun Project.createKtFormatTask(): Task {
        val task = tasks.findByName(TASK_KTFORMAT)
        if (task != null) return task
        return tasks.create(TASK_KTFORMAT, FormatTask::class) {
            group = "formatting"
            setDisabledRules(DISABLED_KTLINT_RULES)
        }
    }

    private fun Project.createCodeStyleTask(): Task {
        val task = tasks.findByName(TASK_CODESTYLE)
        if (task != null) return task
        val createdTask = tasks.create(TASK_CODESTYLE)
        createdTask.dependsOn(TASK_DETEKT, TASK_KTLINT)
        return createdTask
    }

    companion object {
        private const val TASK_KTLINT: String = "ktlint"
        private const val TASK_KTFORMAT: String = "ktformat"
        private const val TASK_CODESTYLE = "codestyle"
        private const val TASK_DETEKT: String = "detekt"
        private const val DETEKT_REPORT_NAME: String = "detekt"
        private const val LINT_REPORT_NAME: String = "lint-report"
        private const val EXTENSION_NAME = "codestyle"
        private const val DEFAULT_DETEKT_CONFIG_NAME = "detekt.yml"

        internal val PATH_SEPARATOR = File.separatorChar

        private val DISABLED_KTLINT_RULES = arrayOf("import-ordering", "no-wildcard-imports")
        private val RELATIVE_CONFIG_FOLDER = "${PATH_SEPARATOR}buildSrc" +
                "${PATH_SEPARATOR}src" +
                "${PATH_SEPARATOR}main" +
                "${PATH_SEPARATOR}resources" +
                "${PATH_SEPARATOR}config"

        private inline fun Project.configureKtLintTask(block: LintTask.() -> Unit) {
            val task = tasks.findByName(TASK_KTLINT) as? LintTask
            requireNotNull(task) { "Task $TASK_KTLINT not found!" }
            task.block()
        }

        private inline fun Project.configureKtFormatTask(block: FormatTask.() -> Unit) {
            val task = tasks.findByName(TASK_KTFORMAT) as? FormatTask
            requireNotNull(task) { "Task $TASK_KTFORMAT not found!" }
            task.block()
        }

        internal fun Project.setDestination(path: String) {
            configure<DetektExtension> {
                reports.html.destination = file(
                    "$path$PATH_SEPARATOR$DETEKT_REPORT_NAME.html"
                )
                reports.xml.destination = file(
                    "$path$PATH_SEPARATOR$DETEKT_REPORT_NAME.xml"
                )
                reports.txt.destination = file(
                    "$path$PATH_SEPARATOR$DETEKT_REPORT_NAME.txt"
                )
            }
            configure<BaseExtension> {
                lintOptions {
                    htmlOutput = file(
                        "$path$PATH_SEPARATOR$LINT_REPORT_NAME.html"
                    )
                    xmlOutput = file(
                        "$path$PATH_SEPARATOR$LINT_REPORT_NAME.xml"
                    )
                }
            }
            configureKtLintTask {
                KotlinterSetupHelper.path = path
                reports = KotlinterSetupHelper.getLintReportsMap()
            }
            configureKtFormatTask {
                report = KotlinterSetupHelper.getLintFormatFile()
            }
        }

        internal fun Project.setHtmlEnabled(enabled: Boolean) {
            configure<DetektExtension> {
                reports.html.enabled = enabled
            }
            configure<BaseExtension> {
                lintOptions.htmlReport = enabled
            }
            configureKtLintTask {
                KotlinterSetupHelper.isHtmlEnabled = enabled
                reports = KotlinterSetupHelper.getLintReportsMap()
            }
        }

        internal fun Project.setXmlEnabled(enabled: Boolean) {
            configure<DetektExtension> {
                reports.xml.enabled = enabled
            }
            configure<BaseExtension> {
                lintOptions.xmlReport = enabled
            }
        }

        internal fun Project.setTxtEnabled(enabled: Boolean) {
            configure<DetektExtension> {
                reports.txt.enabled = enabled
            }
            configureKtLintTask {
                KotlinterSetupHelper.isTxtEnabled = enabled
                reports = KotlinterSetupHelper.getLintReportsMap()
            }
        }

        internal fun Project.setInput(files: ConfigurableFileCollection) {
            configure<DetektExtension> {
                input = files
            }
            configureKtLintTask {
                setSource(files)
            }
            configureKtFormatTask {
                setSource(files)
            }
        }

        internal fun Project.setLintConfig(file: File) {
            configure<BaseExtension> {
                lintOptions.lintConfig = file
            }
        }
    }
}
