package com.example.todo_list.data.ui.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_list.R
import com.example.todo_list.data.Todo
import com.google.android.material.checkbox.MaterialCheckBox

class TodoViewHolder(itemView: View,val actionview: (Todo) -> Unit,val actionDelete: (Todo) -> Unit): RecyclerView.ViewHolder(itemView){
    private val title: TextView = itemView.findViewById(R.id.titleTodo)
    private val description: TextView = itemView.findViewById(R.id.todoTaskDescription)
    private val isCheck: MaterialCheckBox = itemView.findViewById(R.id.todoCheck)
    private val delete: TextView = itemView.findViewById(R.id.actionDelete)
    private val actionDetails: TextView = itemView.findViewById(R.id.actionView)

    fun bind(todo: Todo) {
        title.text = todo.title
        description.text = todo.description
        isCheck.isChecked = todo.isCheck
        this.delete.setOnClickListener {actionDelete(todo)}
        this.actionDetails.setOnClickListener {actionview(todo)}
    }
}
