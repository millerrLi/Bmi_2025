package com.millerr.bmi_2025

fun main() {
    val deck = mutableListOf<Int>()
    for (i in 0 until 52) {
        if (i % 13 == 0 || i == 0) println()
        var type = if (i / 13 == 0){
            "C"
        }else if (i / 13 == 1){
            "D"
        }else if (i / 13 == 3){
            "H"
        }else "S"
        print("${i % 13 + 1}$type ")
    }
}
