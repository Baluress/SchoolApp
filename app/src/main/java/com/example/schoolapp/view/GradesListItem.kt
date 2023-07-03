package com.example.schoolapp.view

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.provider.Settings.Global.getString
import android.text.style.UpdateLayout
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.example.schoolapp.App
import com.example.schoolapp.OnListClickListener
import com.example.schoolapp.R
import com.example.schoolapp.model.CalcGrade
import com.example.schoolapp.presentation.GradesListPresenter
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import java.util.*

class GradesListItem(private val calcGrade: CalcGrade) :
    Item<GradesListItem.GradesListViewHolder>(){

    private var context: Context? = null
    private lateinit var adapter: GroupieAdapter

    class GradesListViewHolder(view: View) : GroupieViewHolder(view)

    override fun createViewHolder(itemView: View): GradesListViewHolder {
        context = itemView.context
        adapter = GroupieAdapter()
        return GradesListViewHolder(itemView)
    }

    override fun bind(viewHolder: GradesListViewHolder, position: Int) {

        val name =
            calcGrade.name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        val sdf = java.text.SimpleDateFormat("dd/MM/yyyy HH: mm", Locale("pt", "Br"))
        val data = sdf.format(calcGrade.createdDate)
        val average = calcGrade.average

        viewHolder.itemView.findViewById<TextView>(R.id.txt_list).text =
            context?.getString(R.string.list_response, name, average, data) ?: ""

        viewHolder.itemView.setOnLongClickListener {
           onLongClick(position, calcGrade)
            true
        }

        viewHolder.itemView.setOnClickListener {
            onClick(calcGrade.id)
        }

    }

    override fun getLayout(): Int {
        return R.layout.list_item
    }

    fun onClick(id: Int) {

    }

     fun onLongClick(position: Int, calcGrade: CalcGrade) {
        AlertDialog.Builder(context)
            .setMessage(R.string.delete)
            .setNegativeButton(android.R.string.cancel) { dialog, which ->
            }
            .setPositiveButton(android.R.string.ok) { dialog, which ->
                Thread {
                    val app = context?.applicationContext as App
                    val dao = app.db.calcGradeDao()

                    val response = dao.delete(calcGrade)

                    if(response > 0) {

                    }

                }.start()

            }.create()
          .show()
     }
}
