package com.don11995.oneplus.callrecorder.manager.job

import android.content.Context
import android.provider.Settings
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.don11995.log.SimpleLog

class CallRecorderJob(
    private val context: Context,
    workerParams: WorkerParameters
) : Worker(context, workerParams) {

    override fun doWork(): Result {
        return try {
            Settings.Global.putInt(
                context.contentResolver,
                SETTING_CALL_RECORDER,
                ENABLE_CALL_RECORDER
            )
            SimpleLog.d("Call recorder was enabled!")
            Result.success()
        } catch (e: SecurityException) {
            SimpleLog.e(e)
            Result.failure()
        }
    }

    companion object {
        const val NAME: String = "CallRecorderJob"
        const val WORK_PERIOD_HOURS: Long = 1
        const val BACKOFF_MINUTES: Long = 1

        private const val SETTING_CALL_RECORDER = "op_voice_recording_supported_by_mcc"
        private const val ENABLE_CALL_RECORDER = 1
    }
}
