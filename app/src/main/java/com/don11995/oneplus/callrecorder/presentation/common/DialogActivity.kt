package com.don11995.oneplus.callrecorder.presentation.common

import android.content.DialogInterface
import androidx.annotation.StringRes

interface DialogActivity {
    fun showPermissionDialog(block: DialogInterface.() -> Unit)
    fun finish()
    fun showToast(@StringRes text: Int, length: Int)
}
