package com.don11995.oneplus.callrecorder.presentation.fragments.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.work.Operation
import com.don11995.log.SimpleLog
import com.don11995.oneplus.callrecorder.R
import com.don11995.oneplus.callrecorder.databinding.FragmentMainBinding
import com.don11995.oneplus.callrecorder.presentation.common.DialogActivity
import com.don11995.oneplus.callrecorder.presentation.fragments.base.BaseFragment
import com.don11995.oneplus.callrecorder.utils.listen

class MainFragment : BaseFragment() {

    private val dialogActivity by lazy {
        activity as? DialogActivity
    }

    override val viewModel: MainFragmentViewModel by viewModels()
    override val fragmentLayout: Int = R.layout.fragment_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = DataBindingUtil.bind<FragmentMainBinding>(view)
        binding?.viewModel = viewModel

        initLiveData()
    }

    private fun initLiveData() {
        viewModel.permissionRequestLd.listen(viewLifecycleOwner) {
            handlePermissionRequest()
        }
        viewModel.callRecorderEnablerLd?.listen(viewLifecycleOwner) {
            when (it) {
                is Operation.State.SUCCESS -> handleCallRecorderEnabled(true)
                is Operation.State.FAILURE -> handleCallRecorderEnabled(false)
                else -> SimpleLog.d("Job in progress...")
            }
        }
    }

    private fun handlePermissionRequest() {
        dialogActivity?.showPermissionDialog {
            dialogActivity?.finish()
        }
    }

    private fun handleCallRecorderEnabled(result: Boolean) {
        if (result) {
            dialogActivity?.showToast(R.string.call_recorder_enabled, Toast.LENGTH_LONG)
        } else {
            dialogActivity?.showToast(R.string.call_recorder_error, Toast.LENGTH_LONG)
        }
    }
}
