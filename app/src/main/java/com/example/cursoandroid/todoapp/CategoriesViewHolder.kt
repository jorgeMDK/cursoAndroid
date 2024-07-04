package com.example.cursoandroid.todoapp

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.cursoandroid.R

class CategoriesViewHolder(view:View) : RecyclerView.ViewHolder(view){
    private val tvCategoryName: TextView = view.findViewById(R.id.tvCategoryName)
    private val divider: View = view.findViewById(R.id.divider)
    fun render(taskCategory: TaskCategory){

        when(taskCategory){
            TaskCategory.Busines -> {
                tvCategoryName.text = "NEGOCIOS"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.todo_business_category)
                )
            }
            TaskCategory.Other -> {
                tvCategoryName.text = "OTRO"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.todo_other_category)
                )

            }
            TaskCategory.Personal -> {
                tvCategoryName.text = "PERSONAL"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.todo_personal_category)
                )

            }
        }

    }
}