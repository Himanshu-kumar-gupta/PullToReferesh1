package com.example.pulltoreferesh1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Creating class for recyclerview adapter
class PtrAdapter(

    //below variables are defined to store
    //numbers in arraylist and next is for context
    private val numbers: ArrayList<String>,
    private val context: Context
) : RecyclerView.Adapter<PtrAdapter.NumberViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PtrAdapter.NumberViewHolder{

        //inflating the layout file for the recycler view
        // that we have created before, in below lines
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.himanshu_layout, parent, false)

        //returning view holder class with itemView file
        return NumberViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PtrAdapter.NumberViewHolder, position: Int) {

        // Storing data to our text view
        holder.currentNum.text = numbers.get(position)
    }

    override fun getItemCount(): Int {
        return numbers.size
    }

    class NumberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Initializing our number text view
        val currentNum: TextView = itemView.findViewById(R.id.displayNum)
    }
}