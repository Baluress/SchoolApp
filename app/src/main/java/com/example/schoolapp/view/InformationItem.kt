package com.example.schoolapp.view

import android.view.View
import android.widget.TextView
import com.example.schoolapp.InfoItem
import com.example.schoolapp.R
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

class InformationItem(private val infoItem: InfoItem) : Item<InformationItem.InfoViewHolder>() {

    class InfoViewHolder(view:View) : GroupieViewHolder(view)

    override fun createViewHolder(itemView: View): InfoViewHolder {
        return InfoViewHolder(itemView)
    }

    override fun bind(viewHolder: InfoViewHolder, position: Int) {
        viewHolder.itemView.findViewById<TextView>(R.id.info_textview).setText(infoItem.text)
    }

    override fun getLayout(): Int {
        return R.layout.info_item
    }
}