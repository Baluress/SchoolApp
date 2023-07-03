package com.example.schoolapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.schoolapp.model.CalcGrade
import java.util.*

class ListGradesActivity : AppCompatActivity()
//
//    private lateinit var rv: RecyclerView
//    private lateinit var result: MutableList<CalcGrade>
//    private lateinit var adapter: ListCalcAdapter
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_grades_list)
//
//        result = mutableListOf()
//
//        adapter = ListCalcAdapter(result, this)
//        rv = findViewById(R.id.rv_list)
//        rv.adapter = adapter
//        rv.layoutManager = LinearLayoutManager(this)
//
//
//        Thread {
//            val app = application as App
//            val dao = app.db.calcGradeDao()
//            val response = dao.getAllRegister()
//
//            runOnUiThread {
//                result.addAll(response)
//                adapter.notifyDataSetChanged()
//            }
//        }.start()
//    }
//
//    private inner class ListCalcAdapter(
//        private val listGrades: List<CalcGrade>,
//        private val onListClickListener: OnListClickListener
//    ) : RecyclerView.Adapter<ListCalcAdapter.ListViewHolder>() {
//        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
//            val view = layoutInflater.inflate(android.R.layout.simple_list_item_1, parent, false)
//            return ListViewHolder(view)
//        }
//
//        override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
//            val itemCurrent = listGrades[position]
//            holder.bind(itemCurrent)
//        }
//
//        override fun getItemCount(): Int {
//            return listGrades.size
//        }
//
//        private inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//            fun bind(item: CalcGrade) {
//
//                val tv = itemView as TextView
//
//                val sdf = java.text.SimpleDateFormat("dd/MM/yyyy HH: mm", Locale("pt", "Br"))
//                val data = sdf.format(item.createdDate)
//                val name = item.name
//                val average = item.average
//
//                tv.text = getString(R.string.list_response, name, average, data)
//
//                tv.setOnLongClickListener {
//                    onListClickListener.onLongClick(adapterPosition, item)
//                    true
//                }
//
//                tv.setOnClickListener {
//                    onListClickListener.onClick(item.id)
//                }
//            }
//        }
//
//    }
//
//    override fun onClick(id: Int) {
//        val intent = Intent(this, GradesActivity::class.java)
//        intent.putExtra("updatedId", id)
//        startActivity(intent)
//    }
//
//    override fun onLongClick(position: Int, calcGrade: CalcGrade) {
//        AlertDialog.Builder(this)
//            .setMessage(R.string.delete)
//            .setNegativeButton(android.R.string.cancel) { dialo, which ->
//            }
//            .setPositiveButton(android.R.string.ok) { dialog, which ->
//                Thread {
//                    val app = application as App
//                    val dao = app.db.calcGradeDao()
//
//                    val response = dao.delete(calcGrade)
//
//                    if (response > 0) {
//                        runOnUiThread {
//                            result.removeAt(position)
//                            adapter.notifyItemRemoved(position)
//                        }
//                    }
//                }.start()
//            }
//            .create()
//            .show()
//    }
//}