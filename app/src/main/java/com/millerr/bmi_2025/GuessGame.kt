package com.millerr.bmi_2025

import kotlin.random.Random

class GuessGame {
    var secret = Random.nextInt(1, 11)
    var counter = 0
    fun guess(n: Int): Int{
        counter++
        return  secret - n
    }
    fun reset(){
        secret = Random.nextInt(1,11)
        counter = 0
    }
}

fun main(){
    val game = GuessGame()
    var num = 3
    var resutl = game.guess(num)
}