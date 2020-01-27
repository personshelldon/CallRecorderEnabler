package com.don11995.oneplus.callrecorder.presentation.common

import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import com.don11995.log.SimpleLog
import kotlinx.coroutines.CompletableJob
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.core.KoinComponent
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel(), CoroutineScope, KoinComponent {
    private val coroutineJob: CompletableJob = SupervisorJob()

    private val defaultErrorHandler = CoroutineExceptionHandler { _, e ->
        SimpleLog.e(e)
    }

    override val coroutineContext: CoroutineContext = Dispatchers.Main +
            coroutineJob +
            defaultErrorHandler

    @CallSuper
    open fun onResume() {
        SimpleLog.fi()
    }

    @CallSuper
    open fun onPause() {
        SimpleLog.fi()
    }

    @CallSuper
    override fun onCleared() {
        SimpleLog.fi()
        coroutineJob.cancel()
        super.onCleared()
    }
}
