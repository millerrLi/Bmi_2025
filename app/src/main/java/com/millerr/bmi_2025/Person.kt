package com.millerr.bmi_2025

class Person constructor(val name: String, val weight: Float, val height: Float) {
    //constructor是可以省略的，只要帶有()，就表示為建構子
    fun bmi(): Float{
        val bmi = weight / (height * height)
        return bmi
    }
    fun hello(){
        println("Hello")
    }
}