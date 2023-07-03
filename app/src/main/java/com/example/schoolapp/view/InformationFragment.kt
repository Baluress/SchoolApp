package com.example.schoolapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.schoolapp.InfoItem
import com.example.schoolapp.R
import com.example.schoolapp.databinding.FragmentInformationBinding
import com.example.schoolapp.presentation.InformationPresenter
import com.xwray.groupie.GroupieAdapter

class InformationFragment : Fragment(){

    private var _binding: FragmentInformationBinding? = null
    private val binding get() = _binding!!

    private lateinit var presenter: InformationPresenter
    private val adapter = GroupieAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = InformationPresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInformationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvInfo.layoutManager = LinearLayoutManager(requireContext())

        presenter.findAllInfo()
        binding.rvInfo.adapter = adapter

    }

    fun showInfo(response: List<InfoItem>) {
        val info = response.map { InformationItem(it) }
        adapter.addAll(info)
        adapter.notifyDataSetChanged()
    }

    fun showFailure(message: String) {
        Toast.makeText(requireContext(),message, Toast.LENGTH_SHORT).show()
    }

}