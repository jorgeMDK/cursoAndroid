package com.example.cursoandroid.todoapp

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cursoandroid.R

class TaskViewHolder (view: View) : RecyclerView.ViewHolder(view){
    private val tvTask:TextView = view.findViewById(R.id.tvTask)
    private val chkTask:CheckBox = view.findViewById(R.id.chkTask)
    fun render(task: Task){
        tvTask.text = task.name
    }
}