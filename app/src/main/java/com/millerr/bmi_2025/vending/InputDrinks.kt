package com.millerr.bmi_2025.vending

import android.R.id.input
import java.io.File

fun main() {
    var drinks = mutableListOf<Drink>()
    val input = File("order.txt").bufferedReader()
    var line = input.readLine()
    while (line != null){
        println(line)
        val token = line.split(", ")
        try {
            var drink = Drink(token[0], token[1].toInt(), token[2].toInt())
            drinks.add(drink)
        }catch (ex: IndexOutOfBoundsException){
            println("Invalid line Data format")
        }
//        finally {
//
//        }

        line = input.readLine()
    }
    println(drinks)
}