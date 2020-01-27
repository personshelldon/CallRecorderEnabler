package com.don11995.oneplus.callrecorder.presentation.fragments.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.work.Operation
import com.don11995.oneplus.callrecorder.manager.PermissionManager
import com.don11995.oneplus.callrecorder.manager.WorkManager
import com.don11995.oneplus.callrecorder.presentation.fragments.base.BaseFragmentViewModel
import org.koin.core.inject

class MainFragmentViewModel : BaseFragmentViewModel() {

    val permissionRequestLd: MutableLiveData<Boolean> = MutableLiveData()

    private val workManager by inject<WorkManager>()
    private val permissionManager by inject<PermissionManager>()

    var callRecorderEnablerLd: LiveData<Operation.State>? = null

    init {
        if (!permissionManager.checkPermission(
                PermissionManager.PERMISSION_WRITE_SETTINGS
            )
        ) {
            permissionRequestLd.value = true
        } else {
            callRecorderEnablerLd = workManager.startCallRecorderJob().state
        }
    }
}
