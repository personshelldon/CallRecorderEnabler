package com.don11995.oneplus.callrecorder.di

import androidx.work.WorkManager
import com.don11995.oneplus.callrecorder.manager.PermissionManager
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

private val managerModule = module {
    single { WorkManager.getInstance(androidContext()) }
    single { com.don11995.oneplus.callrecorder.manager.WorkManager(get()) }
    single { PermissionManager(androidContext()) }
}

val allModules: List<Module> = listOf(managerModule)
