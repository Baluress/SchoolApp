package com.example.schoolapp.presentation

import com.example.schoolapp.App
import com.example.schoolapp.R
import com.example.schoolapp.model.CalcGrade
import com.example.schoolapp.view.GradesFragment
import com.xwray.groupie.GroupieAdapter

class GradesPresenter(
    private val view: GradesFragment
) {

    private var validateNumber: Int = 2

    fun gradesRequest() {
        val items = view.activity?.resources?.getStringArray(R.array.number_of_grades)
        when (view.numberOfGrades.text.toString()) {
            items?.get(0) -> {
                view.showGrades(2)
                validateNumber = 2
            }
            items?.get(1) -> {
                view.showGrades(3)
                validateNumber = 3
            }
            items?.get(2) -> {
                view.showGrades(4)
                validateNumber = 4
            }
        }
    }

    fun validate(): Boolean {
        return when (validateNumber) {
            2 -> {
                (view.txtName.text.toString().isNotEmpty()
                        && view.editGrade1.text.toString().isNotEmpty()
                        && view.editGrade2.text.toString().isNotEmpty()
                        && view.editGrade1.text.toString().toInt() <= 10
                        && view.editGrade2.text.toString().toInt() <= 10)
            }
            3 -> {
                (view.txtName.text.toString().isNotEmpty()
                        && view.editGrade1.text.toString().isNotEmpty()
                        && view.editGrade2.text.toString().isNotEmpty()
                        && view.editGrade3.text.toString().isNotEmpty()
                        && view.editGrade1.text.toString().toInt() <= 10
                        && view.editGrade2.text.toString().toInt() <= 10
                        && view.editGrade3.text.toString().toInt() <= 10)
            }
            4 -> {
                (view.txtName.text.toString().isNotEmpty()
                        && view.editGrade1.text.toString().isNotEmpty()
                        && view.editGrade2.text.toString().isNotEmpty()
                        && view.editGrade3.text.toString().isNotEmpty()
                        && view.editGrade4.text.toString().isNotEmpty()
                        && view.editGrade1.text.toString().toInt() <= 10
                        && view.editGrade2.text.toString().toInt() <= 10
                        && view.editGrade3.text.toString().toInt() <= 10
                        && view.editGrade4.text.toString().toInt() <= 10)
            }
            else -> return false
        }
    }

    fun calculateGrade(): Double {
        val grade1 = view.editGrade1.text.toString().toInt()
        val grade2 = view.editGrade2.text.toString().toInt()
        return when (validateNumber) {
            2 -> {
                (grade1 + grade2) / 2.0
            }
            3 -> {
                val grade3 = view.editGrade3.text.toString().toInt()
                (grade1 + grade2 + grade3) / 3.0
            }
            4 -> {
                val grade3 = view.editGrade3.text.toString().toInt()
                val grade4 = view.editGrade4.text.toString().toInt()
                (grade1 + grade2 + grade3 + grade4) / 4.0
            }
            else -> 0.0
        }
    }

    fun gradeResponse(result: Double): Int {
        return when {
            result < 6.0 -> R.string.negative_grade
            result >= 6.0 -> R.string.positive_grade
            else -> R.string.invalid_grade
        }
    }

    fun findDBMethods(studentName: String, result: Double) {
        Thread {
            val app = view.activity?.application as App
            val dao = app.db.calcGradeDao()
            val updatedId = view.activity?.intent?.extras?.getInt("updatedId")
            if (updatedId != null) {
                dao.update(CalcGrade(id = updatedId, average = result, name = studentName))
            } else {
                dao.insert(CalcGrade(name = studentName, average = result))
            }

            view.activity?.runOnUiThread {
                view.updateElements()
            }
        }.start()
    }
}

