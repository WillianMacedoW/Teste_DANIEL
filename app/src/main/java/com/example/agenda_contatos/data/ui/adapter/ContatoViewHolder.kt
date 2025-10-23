package com.example.agenda_contatos.data.ui.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.agenda_contatos.R
import com.example.agenda_contatos.data.Contato

class ContatoViewHolder(
    itemView: View,
    private val onView: (Contato) -> Unit,
    private val onDelete: (Contato) -> Unit,
) : RecyclerView.ViewHolder(itemView) {

    private val nome: TextView = itemView.findViewById(R.id.contatoNome)
    private val telefone: TextView = itemView.findViewById(R.id.contatoTelefone)
    private val observacao: TextView = itemView.findViewById(R.id.contatoObservacao)
    private val delete: View = itemView.findViewById(R.id.actionDelete)
    private val actionDetails: View = itemView.findViewById(R.id.actionView)

    fun bind(contato: Contato) {
        nome.text = contato.nome
        telefone.text = contato.telefone
        observacao.text = contato.observacao

        delete.setOnClickListener { onDelete(contato) }
        actionDetails.setOnClickListener { onView(contato) }
        itemView.setOnClickListener { onView(contato) }
        itemView.setOnLongClickListener {
            onDelete(contato)
            true
        }
    }
}
