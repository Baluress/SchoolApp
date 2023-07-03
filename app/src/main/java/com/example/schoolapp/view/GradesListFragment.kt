package com.example.schoolapp.view

import android.content.Context
import androidx.appcompat.app.AlertDialog
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.schoolapp.App
import com.example.schoolapp.OnListClickListener
import com.example.schoolapp.R
import com.example.schoolapp.databinding.FragmentGradesListBinding
import com.example.schoolapp.model.CalcGrade
import com.example.schoolapp.presentation.GradesListPresenter
import com.xwray.groupie.GroupieAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GradesListFragment : Fragment(){

    private var _binding: FragmentGradesListBinding? = null
    private val binding get() = _binding!!

    private lateinit var presenter: GradesListPresenter
    private val adapter = GroupieAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = GradesListPresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGradesListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvList.layoutManager = LinearLayoutManager(requireContext())
        presenter.findAllGrades()

        binding.rvList.adapter = adapter
    }

    fun showGrades() {
        adapter.addAll(presenter.result)
        adapter.notifyDataSetChanged()
    }


    fun updateElements(position: Int) {
        adapter.notifyItemRemoved(position)
    }
}