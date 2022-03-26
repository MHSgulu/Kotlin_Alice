package com.kt.alice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    var appName: String = "Kotlin-Alice"
    private var version: Double = 1.1
    val appIntro = "该APP采用Android原生开发，Kotlin语言"

    var appLanguageName: String? = null

    //推迟 View 的属性初始化。
    private lateinit var textView: TextView
    private lateinit var button: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testDemo1()
        testDemo2()

        appName = testDemo3()
        appName = testDemo4(2)
        appName = testDemo5(3)
        appName = testDemo6(4)

        val stringLength: Int = stringLengthFunc("Android")

        //要调用 stringMapper()，可以传递一个 String 和一个满足其他输入参数的函数（即，一个将 String 当作输入并输出 Int 的函数
        stringMapper("Android", { input ->
            input.length
        })

        //如果匿名函数是在某个函数上定义的最后一个参数，则您可以在用于调用该函数的圆括号之外传递它
        stringMapper("Android") { input ->
            input.length
        }


        textView = findViewById(R.id.tv_1)
        button = findViewById(R.id.bt_1)

        //单一抽象方法转换，简称 SAM 转换
        button.setOnClickListener {
            val accountLength: Int = stringLengthFunc("Android")
            if (accountLength == 7){
                Toast.makeText(this,"1",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"2",Toast.LENGTH_SHORT).show()
            }
        }


    }

    private fun testDemo1() {

        appName = if (version == 1.0) {
            "Kotlin-Alice"
        } else {
            "KT-Alice"
        }

        appName = (if (version == 1.0) "Kotlin-Alice" else "KT-Alice")

        (if (version == 1.0) {
            "Kotlin-Alice"
        } else {
            "KT-Alice"
        }).also { appName = it }

    }

    private fun testDemo2() {

        appName = when (version) {
            1.0 -> {
                "Kotlin-Alice"
            }
            1.1 -> {
                "KT-Alice"
            }
            else -> {
                "未知"
            }
        }

        when (version) {
            1.0 -> {
                "Kotlin-Alice"
            }
            1.1 -> {
                "KT-Alice"
            }
            else -> {
                "未知"
            }
        }.also { appName = it }

        appName = when (version) {
            1.0 -> "Kotlin-Alice"
            1.1 -> "KT-Alice"
            else -> "未知"
        }


    }

    private fun testDemo3(): String {
        val appName: String = if (version == 1.0){
            "Kotlin-Alice"
        }else{
            "KT-Alice"
        }
        return appName
    }

    private fun testDemo4(versionNo: Int): String{
        val appName: String = if (versionNo == 1){
            "Kotlin-Alice"
        }else{
            "KT-Alice"
        }
        return appName
    }

    private fun testDemo5(versionNo: Int): String{
        return if (versionNo == 1){
            "Kotlin-Alice"
        }else{
            "KT-Alice"
        }
    }

    private fun testDemo6(versionNo: Int): String = if (versionNo == 1){
        "Kotlin-Alice"
    }else{
        "KT-Alice"
    }

    //匿名函数
    val stringLengthFunc: (String) -> Int = { input ->
        input.length
    }

    //高阶函数
    fun stringMapper(str: String, mapper: (String) -> Int): Int {
        // 调用函数
        return mapper(str)
    }

    companion object {
        private const val TAG = "MainActivity"
    }


}