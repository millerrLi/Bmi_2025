package com.millerr.bmi_2025

fun main() {
    val drinks = mutableMapOf<Int, String>(
        Pair(1, "Coke"),
        2 to "7-up",
        3 to "Wuloong",
        4 to "Orange"
    )
    println(drinks)
    println(drinks.get(3))
    drinks.put(5, "Water")
    println(drinks)
}