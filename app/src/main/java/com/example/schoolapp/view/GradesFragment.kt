package com.example.schoolapp.view

import androidx.appcompat.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.schoolapp.R
import com.example.schoolapp.databinding.FragmentGradesBinding
import com.example.schoolapp.model.CalcGrade
import com.example.schoolapp.presentation.GradesPresenter
import com.xwray.groupie.GroupieAdapter

class GradesFragment : Fragment() {
    private var _binding: FragmentGradesBinding? = null
    private val binding get() = _binding!!

    private lateinit var presenter: GradesPresenter
    private val adapter = GroupieAdapter()

    lateinit var numberOfGrades: AutoCompleteTextView
    lateinit var txtName: EditText
    lateinit var editGrade1: EditText
    lateinit var editGrade2: EditText
    lateinit var editGrade3: EditText
    lateinit var editGrade4: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = GradesPresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGradesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        numberOfGrades = binding.autoNumberGrades
        val items = resources.getStringArray(R.array.number_of_grades)
        numberOfGrades.setText(items.first())
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, items)
        numberOfGrades.setAdapter(adapter)

        txtName = binding.txtName
        editGrade1 = binding.grade1
        editGrade2 = binding.grade2
        editGrade3 = binding.grade3
        editGrade4 = binding.grade4

        val btnGrades: Button = binding.btnNumberGrades

        btnGrades.setOnClickListener {
            presenter.gradesRequest()
        }

        val btnCalc: Button = binding.btnCalcGrade

        btnCalc.setOnClickListener {
            if(!presenter.validate()) {
                Toast.makeText(requireContext(), "Preencha os campos com notas válidas", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            val result = presenter.calculateGrade()
            val studentName = txtName.text.toString()
            val gradeResponseID = presenter.gradeResponse(result)

            AlertDialog.Builder(requireContext())
                .setTitle(getString(R.string.calc_result,studentName, result))
                .setMessage(gradeResponseID)
                .setPositiveButton(android.R.string.ok) { dialog, which ->
                }
                .setNegativeButton(R.string.save) { dialog, which ->
                    presenter.findDBMethods(studentName, result)
                }
                .create()
                .show()

            Log.i("TESTE", "$result")
        }
    }

    fun showGrades(numberElements: Int) {
        when(numberElements) {
            2 -> {
                editGrade1.visibility = View.VISIBLE
                editGrade2.visibility = View.VISIBLE
                editGrade3.visibility = View.GONE
                editGrade4.visibility = View.GONE
//                validateNumber = 2
            }
            3 -> {
                editGrade1.visibility = View.VISIBLE
                editGrade2.visibility = View.VISIBLE
                editGrade3.visibility = View.VISIBLE
                editGrade4.visibility = View.GONE
//                validateNumber = 3
            }
            4 -> {
                editGrade1.visibility = View.VISIBLE
                editGrade2.visibility = View.VISIBLE
                editGrade3.visibility = View.VISIBLE
                editGrade4.visibility = View.VISIBLE
//                validateNumber = 4
            }
        }
    }

    fun updateElements() {
        adapter.notifyDataSetChanged()
    }
}