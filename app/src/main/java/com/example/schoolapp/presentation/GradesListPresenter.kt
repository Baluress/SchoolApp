package com.example.schoolapp.presentation

import android.util.Log
import com.example.schoolapp.App
import com.example.schoolapp.OnListClickListener
import com.example.schoolapp.model.CalcGrade
import com.example.schoolapp.view.GradesListFragment
import com.example.schoolapp.view.GradesListItem

class GradesListPresenter(
    private val view: GradesListFragment
)  {
    val result = mutableListOf<GradesListItem>()


    fun findAllGrades() {
        getAllRegister()
    }

    private fun getAllRegister() {
        Thread {
            val app = view.activity?.application as App
            val dao = app.db.calcGradeDao()
            val response = dao.getAllRegister()

            response.forEach {
                result.add(GradesListItem(it))
            }

            view.activity?.runOnUiThread {
                view.showGrades()
            }
        }.start()
    }

}