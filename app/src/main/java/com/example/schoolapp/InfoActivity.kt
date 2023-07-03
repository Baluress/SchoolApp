package com.example.schoolapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class InfoActivity : AppCompatActivity()
//
//    private lateinit var rvInfo: RecyclerView
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_information)
//
//        val infoItems = mutableListOf<InfoItem>()
//        infoItems.add(
//            InfoItem(
//                id = 1,
//                textInfoId = R.string.important_note_1
//            )
//        )
//
//        infoItems.add(
//            InfoItem(
//                id = 2,
//                textInfoId = R.string.important_note_2
//            )
//        )
//
//        val adapter = InfoAdapter(infoItems)
//        rvInfo = findViewById(R.id.rv_info)
//        rvInfo.layoutManager = LinearLayoutManager(this)
//        rvInfo.adapter = adapter
//    }
//
//    private inner class InfoAdapter(private val infoItems: List<InfoItem>) : RecyclerView.Adapter<InfoAdapter.InfoViewHolder>() {
//        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoViewHolder {
//            val view = layoutInflater.inflate( R.layout.info_item,parent,false)
//            return InfoViewHolder(view)
//        }
//
//        override fun onBindViewHolder(holder: InfoViewHolder, position: Int) {
//            val itemCurrent = infoItems[position]
//            holder.bind(itemCurrent)
//        }
//
//        override fun getItemCount(): Int {
//            return infoItems.size
//        }
//
//        private inner class InfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//            fun bind(item: InfoItem) {
//                val textViewInfo: TextView = itemView.findViewById(R.id.info_textview)
//
//                textViewInfo.setText(item.textInfoId)
//            }
//        }
//
//    }
//}