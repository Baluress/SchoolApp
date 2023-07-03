package com.example.schoolapp.model

import androidx.room.*

@Dao
interface CalcGradeDao {
    @Insert
        fun insert(calcGrade: CalcGrade)

        @Query("SELECT *FROM CalcGrade")
        fun getAllRegister() : List<CalcGrade>

        @Delete
        fun delete(calcGrade: CalcGrade) : Int

        @Update
        fun update(calcGrade: CalcGrade)
}