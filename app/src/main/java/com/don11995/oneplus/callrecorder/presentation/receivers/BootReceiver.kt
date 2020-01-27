package com.don11995.oneplus.callrecorder.presentation.receivers

import android.content.Context
import android.content.Intent
import com.don11995.log.SimpleLog
import com.don11995.oneplus.callrecorder.manager.PermissionManager
import com.don11995.oneplus.callrecorder.manager.WorkManager
import com.don11995.oneplus.callrecorder.presentation.common.BaseReceiver
import org.koin.core.inject

class BootReceiver : BaseReceiver() {

    private val workManager by inject<WorkManager>()
    private val permissionManager by inject<PermissionManager>()

    override fun onReceive(context: Context?, intent: Intent?) {
        if (Intent.ACTION_BOOT_COMPLETED != intent?.action) {
            SimpleLog.w("Wrong intent received! $intent")
            return
        }
        if (permissionManager.checkPermission(
                PermissionManager.PERMISSION_WRITE_SETTINGS
            )
        ) {
            SimpleLog.d("Call recording job started")
            workManager.startCallRecorderJob()
        } else {
            SimpleLog.w("Can not start call recording job. No permission.")
        }
    }
}
