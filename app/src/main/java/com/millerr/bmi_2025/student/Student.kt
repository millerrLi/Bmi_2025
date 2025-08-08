package com.millerr.bmi_2025.student

//學生有學號、姓名、英文、數學成績
//印出學生資料
//印出學生平均成績
//印出學生等級(A, B, C, D, F)
class Student(
    val id: String, val name: String,
    var english: Int = 0, var math: Int = 0
) {
    companion object {
        var pass = 60
    }
//    constructor(id: String, name: String) : this(id, name, 0, 0)

    fun print(){
        val mark = if (average() < pass) "*" else " "
        println("$id\t$name\t$english\t$math\t${average()}$mark\t${grading()}")
    }
    fun average() = (english + math) /2

    fun grading() = when(average()/10){
            9,10 -> "A"
            8 -> "B"
            7 -> "C"
            6 -> "D"
            else -> "F"
    }
}

fun main() {
    Student.pass = 50
    val students = listOf<Student>(
        Student("001", "Jack", 40, 60),
        Student("002", "Hank", 66, 87),
        Student("003", "Mia")
    )
    for (stu in students){
        stu.print()
    }
   /* for (i in 0..2){
        students.get(i).print()
    }
    val stud1 = Student("001", "Jack", 100, 100)
    val stud2 = Student("002", "Hank", 66, 87)
    val stud3 = Student("003", "Mia")
    stud1.print()
    stud2.print()
    stud3.print()*/

}