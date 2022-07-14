package com.kt.alice

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.util.Log
import com.drake.logcat.LogCat
import com.drake.net.NetConfig
import com.drake.net.okhttp.setConverter
import com.drake.net.okhttp.setDebug
import com.elvishew.xlog.LogConfiguration
import com.elvishew.xlog.LogLevel
import com.elvishew.xlog.XLog
import com.kt.alice.net.converter.SerializationConverter
import com.kt.alice.utils.Constant
import java.util.concurrent.TimeUnit

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
        //initNet()
        //TODO 后续第三方库的初始化
    }

    private fun initNet() {
        //这是接口全局域名, 可以使用NetConfig.host进行单独的修改
        NetConfig.initialize(Constant.BING_API_URL, this) {
            // 超时配置, 默认是10秒, 设置太长时间会导致用户等待过久
            connectTimeout(30, TimeUnit.SECONDS)
            readTimeout(30, TimeUnit.SECONDS)
            writeTimeout(30, TimeUnit.SECONDS)
            setDebug(BuildConfig.DEBUG)
            setConverter(SerializationConverter())
        }
    }

    private fun initializeLog() {
        //XLog.init(LogLevel.ALL);
        val config: LogConfiguration = LogConfiguration.Builder()
            .logLevel(LogLevel.ALL) // 指定日志级别，低于该级别的日志将不会被打印，默认为 LogLevel.ALL
            .tag("Alice-Log") // 指定 TAG，默认为 "X-LOG"
            .build()
        XLog.init(config)

        LogCat.setDebug(true, "KT_Alice")


    }


    companion object {
        private val TAG = MyApplication::class.java.simpleName

        @SuppressLint("StaticFieldLeak")
        var context: Context? = null
            private set
    }
}