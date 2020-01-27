package com.don11995.codestyle

import java.io.File

object KotlinterSetupHelper {

    var isHtmlEnabled: Boolean = false
    var isTxtEnabled: Boolean = true
    var path: String = ""

    fun getLintReportsMap(): Map<String, File> {
        val result = mutableMapOf<String, File>()
        if (isHtmlEnabled) {
            result["html"] = File("$path/$KOTLINTER_REPORT_NAME.html")
        }
        if (isTxtEnabled) {
            result["plain"] = File("$path/$KOTLINTER_REPORT_NAME.txt")
        }
        return result
    }

    fun getLintFormatFile(): File = File("$path/$KOTFORMATTER_REPORT_NAME.txt")

    private const val KOTLINTER_REPORT_NAME: String = "kotlinter"
    private const val KOTFORMATTER_REPORT_NAME: String = "kotformatter"
}
