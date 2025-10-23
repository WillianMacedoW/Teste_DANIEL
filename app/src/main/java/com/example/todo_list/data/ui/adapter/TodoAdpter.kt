package com.example.todo_list.data.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.todo_list.R
import com.example.todo_list.data.Todo

class TodoAdapter(val actionview: (Todo) -> Unit,val actionDelete: (Todo) -> Unit): ListAdapter<Todo, TodoViewHolder>(TodoDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_item_list, parent, false)
        return TodoViewHolder(view,actionview,actionDelete)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(getItem(position)) // `getItem()` vem do `ListAdapter`
    }
}
