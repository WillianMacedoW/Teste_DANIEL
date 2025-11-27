package com.example.agenda_contatos.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.agenda_contatos.data.Contato

class ContatoDiffCallback : DiffUtil.ItemCallback<Contato>() {
    override fun areItemsTheSame(oldItem: Contato, newItem: Contato): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Contato, newItem: Contato): Boolean = oldItem == newItem
}
