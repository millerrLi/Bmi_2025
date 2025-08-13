package com.millerr.bmi_2025.student

class HealthReport : Report {
    override fun load() {
        println("Loading Health")
    }

    override fun print(title: String) {
        println("printing Health")
    }
}