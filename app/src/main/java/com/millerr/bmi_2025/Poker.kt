package com.millerr.bmi_2025

fun main() {
    //Set
    val set = setOf<Int>(5,3,9,3,2,1,9)
    println(set)
    set.forEach { println(it) }
    set.forEach { num ->
        println(num)
    }
    //listOf
    val deck = mutableListOf<Int>()
    for (i in 0 until 52) {
        deck.add(i)
        if (i % 13 == 0 || i == 0) println()
        var a = i / 13
        var type = when(a){
            0 -> "♣"
            1 -> "♢"
            2 -> "♡"
            else -> "♠"
        }
//        var type = if (i / 13 == 0){
//            "C"
//        }else if (i / 13 == 1){
//            "D"
//        }else if (i / 13 == 3){
//            "H"
//        }else "S"
        print("${i % 13 + 1}$type ")
    }
    println()
    println(deck)
    //shuffled是產生1個新的mutablelistOf，不會影響到原來的
    val deck2 = deck.shuffled()
    println(deck2)
    val a = deck.shuffled().first()
    val b = deck.shuffled().first()
}
