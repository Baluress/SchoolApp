package com.example.schoolapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class CalcGrade(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "student") val name: String,
    @ColumnInfo(name= "average") val average: Double,
    @ColumnInfo(name= "created_date") val createdDate: Date = Date()
)
