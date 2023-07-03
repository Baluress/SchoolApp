package com.example.schoolapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.schoolapp.model.CalcGrade

class GradesActivity : AppCompatActivity()
//    private lateinit var numberOfGrades: AutoCompleteTextView
//    private lateinit var txtName: EditText
//    private lateinit var editGrade1: EditText
//    private lateinit var editGrade2: EditText
//    private lateinit var editGrade3: EditText
//    private lateinit var editGrade4: EditText
//
//    private var validateNumber: Int = 2
//    private var elementsNumber: Int = 2
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_grades)
//
//        numberOfGrades = findViewById(R.id.auto_number_grades)
//        val items = resources.getStringArray(R.array.number_of_grades)
//        numberOfGrades.setText(items.first())
//        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
//        numberOfGrades.setAdapter(adapter)
//
//        txtName = findViewById(R.id.txt_name)
//        editGrade1 = findViewById(R.id.grade1)
//        editGrade2 = findViewById(R.id.grade2)
//        editGrade3 = findViewById(R.id.grade3)
//        editGrade4 = findViewById(R.id.grade4)
//
//        val btnGrades: Button = findViewById(R.id.btn_number_grades)
//
//        btnGrades.setOnClickListener {
//            gradesRequest()
//            elementsNumber = validateNumber
//        }
//
//        val btnCalc: Button = findViewById(R.id.btn_calc_grade)
//
//        btnCalc.setOnClickListener {
//            if (!validate()) {
//                Toast.makeText(this, "Preencha os campos com notas válidas", Toast.LENGTH_SHORT)
//                    .show()
//                return@setOnClickListener
//            }
//
//            val result = calculateGrade(elementsNumber)
//            val studentName = txtName.text.toString()
//
//            val gradeResponseID = gradeResponse(result)
//
//            AlertDialog.Builder(this)
//                .setTitle(getString(R.string.calc_result,studentName, result))
//                .setMessage(gradeResponseID)
//                .setPositiveButton(android.R.string.ok) { dialog, which ->
//                }
//                .setNegativeButton(R.string.save) {dialog, which ->
//                    Thread{
//                        val app = application as App
//                        val dao = app.db.calcGradeDao()
//                        val updatedId = intent.extras?.getInt("updatedId")
//                            if(updatedId != null) {
//                                dao.update(CalcGrade(id= updatedId,average = result,name = studentName))
//                            } else {
//                                dao.insert(CalcGrade(name = studentName, average = result))
//                            }
//
//                        runOnUiThread {
//                            val intent = Intent(this@GradesActivity, ListGradesActivity::class.java)
//                            startActivity(intent)
//                        }
//                    }.start()
//                }
//                .create()
//                .show()
//
//            val service = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//            service.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
//        }
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.activity_main_drawer,menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        val intent = Intent(this, ListGradesActivity::class.java)
//        startActivity(intent)
//        return super.onOptionsItemSelected(item)
//    }
//
//    private fun gradesRequest() {
//        val items = resources.getStringArray(R.array.number_of_grades)
//        when {
//            numberOfGrades.text.toString() == items[0] -> {
//                editGrade1.visibility = View.VISIBLE
//                editGrade2.visibility = View.VISIBLE
//                editGrade3.visibility = View.GONE
//                editGrade4.visibility = View.GONE
//                validateNumber = 2
//            }
//            numberOfGrades.text.toString() == items[1] -> {
//                editGrade1.visibility = View.VISIBLE
//                editGrade2.visibility = View.VISIBLE
//                editGrade3.visibility = View.VISIBLE
//                editGrade4.visibility = View.GONE
//                validateNumber = 3
//            }
//            numberOfGrades.text.toString() == items[2] -> {
//                editGrade1.visibility = View.VISIBLE
//                editGrade2.visibility = View.VISIBLE
//                editGrade3.visibility = View.VISIBLE
//                editGrade4.visibility = View.VISIBLE
//                validateNumber = 4
//            }
//        }
//    }
//
//    private fun validate(): Boolean {
//        return when (validateNumber) {
//            2 -> {
//                (txtName.text.toString().isNotEmpty()
//                        &&editGrade1.text.toString().isNotEmpty()
//                        && editGrade2.text.toString().isNotEmpty()
//                        && editGrade1.text.toString().toInt() <= 10
//                        && editGrade2.text.toString().toInt() <= 10)
//            }
//            3 -> {
//                (txtName.text.toString().isNotEmpty()
//                        &&editGrade1.text.toString().isNotEmpty()
//                        && editGrade2.text.toString().isNotEmpty()
//                        && editGrade3.text.toString().isNotEmpty()
//                        && editGrade1.text.toString().toInt() <= 10
//                        && editGrade2.text.toString().toInt() <= 10
//                        && editGrade3.text.toString().toInt() <= 10)
//            }
//            4 -> {
//                (txtName.text.toString().isNotEmpty()
//                        &&editGrade1.text.toString().isNotEmpty()
//                        && editGrade2.text.toString().isNotEmpty()
//                        && editGrade3.text.toString().isNotEmpty()
//                        && editGrade4.text.toString().isNotEmpty()
//                        && editGrade1.text.toString().toInt() <= 10
//                        && editGrade2.text.toString().toInt() <= 10
//                        && editGrade3.text.toString().toInt() <= 10
//                        && editGrade4.text.toString().toInt() <= 10)
//            }
//            else -> return false
//        }
//    }
//
//    private fun calculateGrade(elementsNumber: Int): Double {
//        val grade1 = editGrade1.text.toString().toInt()
//        val grade2 = editGrade2.text.toString().toInt()
//        return when(elementsNumber) {
//            2 ->{
//                (grade1 + grade2) / 2.0
//            }
//            3 ->{
//                val grade3 = editGrade3.text.toString().toInt()
//                (grade1 + grade2 + grade3) / 3.0
//            }
//            4 ->{
//                val grade3 = editGrade3.text.toString().toInt()
//                val grade4 = editGrade4.text.toString().toInt()
//                (grade1 + grade2 + grade3 + grade4) / 4.0
//            }
//            else -> 0.0
//        }
//    }
//
//    private fun gradeResponse(result: Double): Int {
//        return when {
//            result < 6.0 -> R.string.negative_grade
//            result >= 6.0 -> R.string.positive_grade
//            else -> R.string.invalid_grade
//        }
//    }
//}