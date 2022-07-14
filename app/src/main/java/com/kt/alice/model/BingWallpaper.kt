package com.kt.alice.model

data class BingWallpaper(
    var images: List<Image>,
    var tooltips: Tooltips
) {
    data class Image(
        var bot: Int, // 1
        var copyright: String, // 爱丽丝镇附近水域中的柠檬鲨宝宝，巴哈马比米尼岛 (© Ken Kiefer 2/Getty Images)
        var copyrightlink: String, // https://www.bing.com/search?q=%E6%9F%A0%E6%AA%AC%E9%B2%A8&amp;form=hpcapt&amp;mkt=zh-cn
        var drk: Int, // 1
        var enddate: String, // 20220714
        var fullstartdate: String, // 202207131600
        var hs: List<Any>,
        var hsh: String, // 994a26d3d82554f5a78e63a8581a2854
        var quiz: String, // /search?q=Bing+homepage+quiz&amp;filters=WQOskey:%22HPQuiz_20220713_BabyLemons%22&amp;FORM=HPQUIZ
        var startdate: String, // 20220713
        var title: String, // 自由自在的柠檬鲨
        var top: Int, // 1
        var url: String, // /th?id=OHR.BabyLemons_ZH-CN4212701834_1920x1080.jpg&amp;rf=LaDigue_1920x1080.jpg&amp;pid=hp
        var urlbase: String, // /th?id=OHR.BabyLemons_ZH-CN4212701834
        var wp: Boolean // true
    )

    data class Tooltips(
        var loading: String, // 正在加载...
        var next: String, // 下一个图像
        var previous: String, // 上一个图像
        var walle: String, // 此图片不能下载用作壁纸。
        var walls: String // 下载今日美图。仅限用作桌面壁纸。
    )
}