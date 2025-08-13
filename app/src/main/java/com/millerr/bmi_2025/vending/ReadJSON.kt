package com.millerr.bmi_2025.vending

import android.R.attr.text
import java.net.URL

fun main() {
    //https://jsonplaceholder.typicode.com/posts
    //一行全部讀完
    //val text = URL("https://jsonplaceholder.typicode.com/posts").readText()
    //開啟串流，讀入資料
    val input = URL("https://jsonplaceholder.typicode.com/posts").openStream()
    val reader = input.bufferedReader()
    var line = reader.readLine()
    while (line != null){
        println(line)
        line = reader.readLine()
    }
}