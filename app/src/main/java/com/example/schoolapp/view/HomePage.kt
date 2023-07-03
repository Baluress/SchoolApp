package com.example.schoolapp.view

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.example.schoolapp.R
import com.example.schoolapp.model.HomeItem
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item


class HomePage(private val homeItem: HomeItem) : Item<HomePage.HomePageViewHolder>() {

    class HomePageViewHolder(view:View) : GroupieViewHolder(view)

    override fun createViewHolder(itemView: View): HomePageViewHolder {
        return HomePageViewHolder(itemView)
    }

    override fun bind(viewHolder: HomePageViewHolder, position: Int) {
        viewHolder.itemView.findViewById<TextView>(R.id.txt_home).text = homeItem.text
        viewHolder.itemView.findViewById<LinearLayout>(R.id.container_home).setBackgroundColor(homeItem.bgColor.toInt())
    }

    override fun getLayout(): Int {
        return R.layout.home_item
    }

}