package com.kt.alice.net.converter

/**
 * @ClassName: GsonConverter
 * @Date: 2022/7/14
 * @Time: 9:20
 * @Author: MHS
 * @Description: 此处是对当前代码作用的描述
 */
import com.drake.net.convert.JSONConvert
import com.google.gson.GsonBuilder
import org.json.JSONObject
import java.lang.reflect.Type

class GsonConverter : JSONConvert(code = "errorCode", message = "errorMsg") {
    companion object {
        private val gson = GsonBuilder().serializeNulls().create()
    }

    override fun <R> String.parseBody(succeed: Type): R? {
        return try {
            gson.fromJson(JSONObject(this).getString("data"), succeed)
        } catch (e: Exception) {
            gson.fromJson(this, succeed)
        }
    }
}