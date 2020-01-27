@file:Suppress("InvalidPackageDeclaration")

import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.api.artifacts.repositories.ArtifactRepository
import org.gradle.kotlin.dsl.maven

fun RepositoryHandler.fabric(): ArtifactRepository =
    maven("https://maven.fabric.io/public")
