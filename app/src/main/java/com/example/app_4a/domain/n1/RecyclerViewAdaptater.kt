package com.example.app_4a.domain.n1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app_4a.R
import kotlinx.android.synthetic.main.text_row_layout.view.*

class RecyclerViewAdaptater(val items: Array<String>) : RecyclerView.Adapter<RecyclerViewAdaptater.ViewHolder>(){
    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        fun bind(item : String) = with(view) {
            view.list_title.text = item.toString()
        }
    }
    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val lineView = LayoutInflater.from(parent.context).inflate(R.layout.text_row_layout, parent, false)
        return ViewHolder(lineView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }
}