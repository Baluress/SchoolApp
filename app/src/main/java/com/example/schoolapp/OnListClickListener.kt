package com.example.schoolapp

import android.content.Context
import com.example.schoolapp.model.CalcGrade

interface OnListClickListener {
    fun onClick(id: Int)
    fun onLongClick(position: Int, calcGrade: CalcGrade)
}