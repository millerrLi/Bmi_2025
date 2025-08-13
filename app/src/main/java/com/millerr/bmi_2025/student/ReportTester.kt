package com.millerr.bmi_2025.student

fun main() {
    val reports = listOf<Report>(
        FinanceReport(),
        HealthReport()
    )

    for (report in reports) {
        report.load()
        report.print("Test")
    }
}