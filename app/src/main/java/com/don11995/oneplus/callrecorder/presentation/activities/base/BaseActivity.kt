package com.don11995.oneplus.callrecorder.presentation.activities.base

import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment.findNavController

abstract class BaseActivity : AppCompatActivity() {

    abstract val viewModel: BaseActivityViewModel

    protected val navController: NavController? by lazy {
        val fragment = getNavController()
        if (fragment != null) findNavController(fragment) else null
    }

    abstract fun getNavController(): Fragment?

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

    override fun onSupportNavigateUp(): Boolean = navController?.navigateUp() ?: false
}
