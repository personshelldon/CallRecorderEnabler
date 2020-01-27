package com.don11995.oneplus.callrecorder.manager

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat

class PermissionManager(private val context: Context) {

    fun checkPermission(permission: String): Boolean =
        ActivityCompat.checkSelfPermission(context, permission) ==
                PackageManager.PERMISSION_GRANTED

    companion object {
        const val PERMISSION_WRITE_SETTINGS: String =
            "android.permission.WRITE_SECURE_SETTINGS"
    }

}
