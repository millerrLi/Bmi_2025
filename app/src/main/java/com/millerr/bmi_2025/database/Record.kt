package com.millerr.bmi_2025.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Record(
    @ColumnInfo(name = "nick")
    @NonNull
    var nickname: String,
    var counter: Int,
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
) {
}