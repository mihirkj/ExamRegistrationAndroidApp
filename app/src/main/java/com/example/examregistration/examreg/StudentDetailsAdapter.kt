package com.example.examregistration.examreg

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examregistration.R
import com.example.examregistration.TextItemViewHolder
import com.example.examregistration.database.StudentDetails

class StudentDetailsAdapter: RecyclerView.Adapter<TextItemViewHolder>() {

    var data =  listOf<StudentDetails>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        val item = data[position]
        holder.textView.text = item.rollNo.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.text_item_view, parent, false) as TextView

        return TextItemViewHolder(view)
    }
}