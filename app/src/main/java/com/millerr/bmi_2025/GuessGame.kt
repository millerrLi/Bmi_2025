package com.millerr.bmi_2025

import kotlin.random.Random

class GuessGame {
    enum class Status {
        INIT, BIGGER, SMALLER, BINGO
    }

    var secret = Random.nextInt(1, 11)
    var counter = 0
    fun guess(n: Int): Status{
        counter++
        return  if (n > secret) Status.SMALLER
        else if (n < secret) Status.BIGGER
        else Status.BINGO
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