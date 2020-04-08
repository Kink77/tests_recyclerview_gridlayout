package com.example.testrecyclerview

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_item.view.*


class MyRecyclerViewAdapter(context: Context?, data: Array<Int>) : RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>() {
    private var mData: Array<Int> = data
    private var mInflater: LayoutInflater = context!!.getSystemService(Activity.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    private val mContext : Context? = context

    // inflates the cell layout from xml when needed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = mInflater.inflate(R.layout.recyclerview_item, parent, false)
        return ViewHolder(view)
    }

    // binds the data to the TextView in each cell
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.item_image.setImageResource(mData[position])
    }

    // total number of cells
    override fun getItemCount(): Int {
        return mData.size
    }


    // stores and recycles views as they are scrolled off screen
    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}