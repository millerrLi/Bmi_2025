package com.millerr.bmi_2025

class Hello {
}

fun main() {
    val p = Person()
    p.hello()

    println("Hello Kotlin!")
    //Byte, Short, Int, Long
    val age: Int = 20
    val population: Long = 9999
    val population2 = 9999L
    println(age.inc())
    println(age)
    var name = "millerr"
    println(name.get(1))
    name = "Jack"
    println(name)

    //Float(32), Double(64)
    //有小數點的數字，系統預設會給Double，有三種設定Float的方法
    val weight: Float = 65.5f
    val weight1 = 65.5f
    val weight2: Float = 65.5.toFloat()

    //true, false
    val isAudit = false
    //Char
    val c = 'A'
    println(c)
}
