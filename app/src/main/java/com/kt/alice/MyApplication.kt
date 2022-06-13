package com.kt.alice

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.util.Log
import com.drake.logcat.LogCat
import com.elvishew.xlog.LogConfiguration
import com.elvishew.xlog.LogLevel
import com.elvishew.xlog.XLog

/**
 * 用于维护全局应用程序状态的基类。
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.i("Alice", "$TAG:onCreate")
        context = this
        init()
    }

    private fun init() {
        initializeLog() //先初始化日志
        //TODO 后续第三方库的初始化
    }

    private fun initializeLog() {
        //XLog.init(LogLevel.ALL);
        val config: LogConfiguration = LogConfiguration.Builder()
            .logLevel(LogLevel.ALL) // 指定日志级别，低于该级别的日志将不会被打印，默认为 LogLevel.ALL
            .tag("Alice-Log") // 指定 TAG，默认为 "X-LOG"
            .build()
        XLog.init(config)

        LogCat.setDebug(true,"KT_Alice")


    }


    companion object {
        private val TAG = MyApplication::class.java.simpleName

        @SuppressLint("StaticFieldLeak")
        var context: Context? = null
            private set
    }
}