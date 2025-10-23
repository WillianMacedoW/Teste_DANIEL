package com.example.agenda_contatos.data.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.agenda_contatos.R
import com.example.agenda_contatos.data.Contato

class ContatoAdapter(
    private val onView: (Contato) -> Unit,
    private val onDelete: (Contato) -> Unit,
) : ListAdapter<Contato, ContatoViewHolder>(ContatoDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatoViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_contato, parent, false)
        return ContatoViewHolder(view, onView, onDelete)
    }

    override fun onBindViewHolder(holder: ContatoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
