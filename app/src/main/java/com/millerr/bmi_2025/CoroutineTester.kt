package com.millerr.bmi_2025

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking{
//    Thread(){
//        doSomething()
//    }.start()
    launch{
        doSomethingElseq()
    }
    println("Hello ${Thread.currentThread().name}")
}

suspend fun doSomethingElseq(){
    delay(1000L)
    println("Do Something Else ${Thread.currentThread().name}")
}

fun doSomething(){
    println("Do Something......${Thread.currentThread().name}")
}