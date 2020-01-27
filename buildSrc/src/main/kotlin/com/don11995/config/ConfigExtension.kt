package com.don11995.config

@Suppress("unused", "MemberVisibilityCanBePrivate")
open class ConfigExtension {
    var compileSdkVersion: Int = 0
        set(value) {
            field = value
            Config.compileSdkVersion = field
        }
    var buildToolsVersion: String = ""
        set(value) {
            field = value
            Config.buildToolsVersion = field
        }
    var applicationId: String = ""
        set(value) {
            field = value
            Config.applicationId = field
        }
    var minSdkVersion: Int = 0
        set(value) {
            field = value
            Config.minSdkVersion = field
        }
    var targetSdkVersion: Int = 0
        set(value) {
            field = value
            Config.targetSdkVersion = field
        }
    var majorVersion: Int = 0
        set(value) {
            field = value
            Config.majorVersion = field
        }
    var minorVersion: Int = 0
        set(value) {
            field = value
            Config.minorVersion = field
        }
    var buildVersion: Int = 0
        set(value) {
            field = value
            Config.buildVersion = field
        }
}
