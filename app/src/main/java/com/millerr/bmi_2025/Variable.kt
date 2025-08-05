package com.millerr.bmi_2025

fun main(){
    val nums = mutableListOf<Int>(1,2,3,4,5,6,7,8,9,10)
    nums.shuffle()
    println(nums)
    val secret = nums.removeAt(0)
    println("秘密數字：$secret")
    val bomb = nums.removeAt(0)
    println("炸彈：$bomb")
    //list
    //mutableListOf才會有add, remove, replace
    val list1 = mutableListOf<Int>(1,4,7)
    println("mutableList : $list1")
    list1.add(9)
    println("mutableList : $list1")
    list1.removeAt(1)
    println("mutableList : $list1")

    //listOf它跟ArrayOf差不多，一樣沒有add, remove, replace
    val list = listOf<Int>(2,5,8)
    println(list)
    //陣列
    val array = intArrayOf(2,5,8)
    println(array)
    println("陣列大小： ${array.size}")
    println("取得陣列中的值 ${array.get(1)}")
    val ss = arrayOf("SUN", "MON", "TUE")
    println(ss.size)
    println(ss[1])
    for (day in ss){
        println(day)
    }
    //for 迴圈
    for (i in 1..30){
        if (i % 2 == 1){
            print("*")
        }else{
            print(" ")
        }
    }
    println()
    for (i in 1..10 step 2) print(i)
    println()
    //null的探討
    var name: String = "millerr"
    //下列的表示是不行的，會告訴String不可以為null
    //name = null
    println(name.length)
    println(name.get(1))
    //null => ? 代表可能為null
    var name2: String? = null
    println(name2?.length)  //.的前面一定要加? 告訴系統可能name2為null，當name2不是null的時候，才會真正執行，得到結果
    // ?: 貓王符號的使用 Elvis operator
    val name3: String? = null
    println(name3 ?: 0)      //表示如果name3如不有值的話，直接印出name裡面的東西，如果是null的話，則印出0


    var counter = 0
    counter++
//    println(counter)
    counter--
//    println(counter)
//    println(10 / 3)
//    println(10 % 3)
//    println(10 / 3.0)
    //Boolean
    var a = true
    var b = false
//    println(!a)
//    println(a && b)
//    println(a || b)
    //
    val num = -8
//    println(num <= 5 && num >= -3)
//    println(num > 5 || num < -3)
}