package com.don11995.oneplus.callrecorder.app

import android.app.Application
import android.content.Context
import android.os.StrictMode
import com.don11995.log.SimpleLog
import com.don11995.oneplus.callrecorder.BuildConfig
import com.don11995.oneplus.callrecorder.di.allModules
import io.reactivex.plugins.RxJavaPlugins
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.logger.EmptyLogger
import java.io.PrintWriter
import java.io.StringWriter

class App : Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        startKoin()
    }

    override fun onCreate() {
        super.onCreate()
//        setUpCrashlytics()
        initializeDebug()
        initializeRx()
    }

    @Suppress("ConstantConditionIf")
    private fun initializeDebug() {
        if (BuildConfig.DEBUG) {
            enableStrictMode()
//            BlockCanary.install(this, AppBlockCanaryContext()).start()
        } else {
            SimpleLog.disableAllLogs()
        }
    }

    private fun initializeRx() {
        RxJavaPlugins.setErrorHandler { e ->
            SimpleLog.e(e)
            if (!BuildConfig.DEBUG) {
                val errors = StringWriter()
                e.printStackTrace(PrintWriter(errors))
                // Crashlytics.log(errors.toString())
            }
        }
    }

    private fun startKoin() {
        if (BuildConfig.DEBUG) {
            startKoin {
                androidContext(this@App)
                printLogger()
                modules(allModules)
            }
        } else {
            startKoin {
                androidContext(this@App)
                logger(EmptyLogger())
                modules(allModules)
            }
        }
    }

//    private fun setUpCrashlytics() {
//        if (BuildConfig.DEBUG) {
//            val crashlyticsCore = CrashlyticsCore.Builder()
//                .disabled(true)
//                .build()
//            Fabric.with(this, Crashlytics.Builder().core(crashlyticsCore).build())
//        } else {
//            Fabric.with(this, Crashlytics(), CrashlyticsNdk(), Answers())
//        }
//    }

    private fun enableStrictMode() {
        StrictMode.setThreadPolicy(
            StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyFlashScreen()
                .penaltyLog()
                .build()
        )

        StrictMode.setVmPolicy(
            StrictMode.VmPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build()
        )
    }
}
