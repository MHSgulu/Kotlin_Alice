package com.kt.alice.api

import io.reactivex.Observable
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    /**
     * 官方必应每日壁纸API
     * https://cn.bing.com/HPImageArchive.aspx?format=js&idx=0&n=1&mkt=zh-CN
     * <p>
     * 今日壁纸
     * https://cn.bing.com/HPImageArchive.aspx?format=js&n=1
     * <p>
     * 近日壁纸 8张
     * https://cn.bing.com/HPImageArchive.aspx?format=js&n=8
     * <p>
     * 参数名称	值含义
     * format  （非必需）
     * 返回数据格式，不存在返回xml格式
     * js (一般使用这个，返回json格式)
     * xml（返回xml格式）
     * <p>
     * idx  (非必需)
     * 请求图片截止天数
     * 0 今天
     * -1 截止中明天 （预准备的）
     * 1 截止至昨天，类推（目前最多获取到7天前的图片）
     * <p>
     * n （必需）
     * 1-8 返回请求数量，目前最多一次获取8张
     * <p>
     * mkt  （非必需）
     * 地区
     * zh-CN
     */
    @POST("HPImageArchive.aspx")
    fun getBingWallpaper(
        @Query("format") format: String?,
        @Query("n") n: String?
    ): Observable<String?>?

}