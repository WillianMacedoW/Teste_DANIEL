package com.example.todo_list.data.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.todo_list.data.Todo

class TodoDiffCallback
    : DiffUtil.ItemCallback<Todo>() {

    // Verifica se os IDs dos itens são iguais
    override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
        return oldItem.id == newItem.id
    }

    // Verifica se o conteúdo do item mudou
    override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
        return oldItem == newItem // Usa o equals da data class
    }
}