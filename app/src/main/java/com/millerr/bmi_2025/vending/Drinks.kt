package com.millerr.bmi_2025.vending

fun Drink.off20(): Drink{
    return this.copy (price = (this.price * 0.8).toInt())
}

fun main() {
    val s = "abcef"
    println(s.validate())

    val tea = Drink("Black tea", 0, 50)
    println(tea)
    val tea2 = tea.copy(suger = 5)
    println(tea2)
    val discountTea = tea.off20()
    println(discountTea)

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

fun String.validate(): Boolean{
    return this.length >= 6
}