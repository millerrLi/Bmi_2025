package com.millerr.bmi_2025.student

fun main() {
    val reports = listOf<Report>(
        FinanceReport(),
        HealthReport(),
        object : Report {
            override fun load() {
                println("EX Report")
            }

            override fun print(title: String) {
                println("Printing...")
            }
        }
    )

    for (report in reports) {
        report.load()
        report.print("Test")
    }
}