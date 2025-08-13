package com.millerr.bmi_2025.vending

import java.io.File

fun main() {
    val drinks = listOf<Drink>(
        Drink("Black tea", 0, 50),
        Drink("Green tea", 5, 45),
        Drink("Wuloon tea", 0, 60)
    )
    //輸出入資料多時，請一律使用bufferWriter
    val out = File("order.txt").bufferedWriter()
    for (d in drinks){
        out.write("${d.name}, ${d.suger}, ${d.price}\n")
    }
    //printWrite，適合少量資料匯出
/*    val out = File("order.txt").printWriter()
    for (d in drinks) {
        out.println("${d.name}, ${d.suger}, ${d.price}")
    }*/
    out.flush()
}