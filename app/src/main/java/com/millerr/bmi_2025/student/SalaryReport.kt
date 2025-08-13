package com.millerr.bmi_2025.student

class SalaryReport: MyReport() {
    override fun load() {
        println("loading SalaryReport")
        init()
    }
}