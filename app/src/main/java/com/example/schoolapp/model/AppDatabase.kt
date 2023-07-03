package com.example.schoolapp.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [CalcGrade::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun calcGradeDao() : CalcGradeDao

    companion object {
        private var INSTANCE: AppDatabase?= null

        fun getDatabase(context: Context): AppDatabase {
            return if(INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "student_grades"
                    ).build()
                }
                INSTANCE as AppDatabase
            }
            else {
                INSTANCE as AppDatabase
            }
        }
    }
}