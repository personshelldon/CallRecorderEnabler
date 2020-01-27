package com.don11995.oneplus.callrecorder.manager

import androidx.work.BackoffPolicy
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.Operation
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.don11995.oneplus.callrecorder.manager.job.CallRecorderJob
import java.util.concurrent.TimeUnit

class WorkManager(private val workManager: WorkManager) {

    fun startCallRecorderJob(): Operation {
        val workRequest = PeriodicWorkRequest.Builder(
            CallRecorderJob::class.java,
            CallRecorderJob.WORK_PERIOD_HOURS,
            TimeUnit.HOURS
        ).setBackoffCriteria(
            BackoffPolicy.LINEAR,
            CallRecorderJob.BACKOFF_MINUTES,
            TimeUnit.MINUTES
        ).build()

        return workManager.enqueueUniquePeriodicWork(
            CallRecorderJob.NAME,
            ExistingPeriodicWorkPolicy.REPLACE,
            workRequest
        )
    }
}
