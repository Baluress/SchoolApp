package com.example.schoolapp

import android.app.Application
import com.example.schoolapp.model.AppDatabase

class App: Application() {
    lateinit var db: AppDatabase

    override fun onCreate() {
        super.onCreate()
        db = AppDatabase.getDatabase(this)
    }
}