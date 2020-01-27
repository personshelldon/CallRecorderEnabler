package com.don11995.oneplus.callrecorder.presentation.fragments.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

abstract class BaseFragment : Fragment() {

    abstract val viewModel: BaseFragmentViewModel

    abstract val fragmentLayout: Int

    protected val navController: NavController? by lazy {
        NavHostFragment.findNavController(this)
    }

    @CallSuper
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(fragmentLayout, container, false)

    @CallSuper
    override fun onResume() {
        super.onResume()
        viewModel.onResume()
    }

    @CallSuper
    override fun onPause() {
        viewModel.onPause()
        super.onPause()
    }
}
