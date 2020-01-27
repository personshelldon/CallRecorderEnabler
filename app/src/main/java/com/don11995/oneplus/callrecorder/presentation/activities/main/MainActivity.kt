package com.don11995.oneplus.callrecorder.presentation.activities.main

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.don11995.oneplus.callrecorder.R
import com.don11995.oneplus.callrecorder.presentation.activities.base.BaseActivity
import com.don11995.oneplus.callrecorder.presentation.common.DialogActivity

@SuppressLint("GoogleAppIndexingApiWarning")
class MainActivity : BaseActivity(), DialogActivity {

    private var dialog: Dialog? = null

    override val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Fix for strange android bug
        // https://stackoverflow.com/questions/19545889/app-restarts-rather-than-resumes
        if (!isTaskRoot &&
            intent.hasCategory(Intent.CATEGORY_LAUNCHER) &&
            Intent.ACTION_MAIN == intent.action
        ) {
            finish()
            return
        }

        setContentView(R.layout.activity_main)
    }

    override fun onDestroy() {
        dialog?.dismiss()
        dialog = null
        super.onDestroy()
    }

    override fun getNavController(): Fragment? =
        supportFragmentManager.findFragmentById(R.id.mainHostFragment)

    override fun showPermissionDialog(block: DialogInterface.() -> Unit) {
        if (dialog?.isShowing == true) return
        dialog = AlertDialog.Builder(this)
            .setCancelable(false)
            .setMessage(R.string.permission_request)
            .setPositiveButton(android.R.string.ok) { dialogInterface, _ ->
                dialogInterface.block()
            }
            .create()
        dialog?.show()
    }

    override fun showToast(@StringRes text: Int, length: Int) {
        Toast.makeText(this, text, length).show()
    }
}
