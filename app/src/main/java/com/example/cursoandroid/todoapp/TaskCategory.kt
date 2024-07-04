package com.example.cursoandroid.todoapp

sealed class TaskCategory {
    object Personal: TaskCategory()
    object Busines: TaskCategory()
    object Other: TaskCategory()
}