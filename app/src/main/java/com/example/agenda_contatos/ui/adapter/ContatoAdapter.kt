package com.example.agenda_contatos.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.agenda_contatos.data.Contato
import com.example.agenda_contatos.databinding.ItemContatoBinding

class ContatoAdapter(
    private val onView: (Contato) -> Unit,
    private val onLongClick: (Contato) -> Unit,
) : ListAdapter<Contato, ContatoAdapter.ViewHolder>(ContatoDiffCallback()) {

    inner class ViewHolder(
        private val binding: ItemContatoBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(contato: Contato) {
            binding.contatoNome.text = contato.nome
            binding.contatoTelefone.text = contato.telefone
            binding.contatoObservacao.text = contato.observacao

            binding.root.setOnClickListener { onView(contato) }
            binding.root.setOnLongClickListener {
                onLongClick(contato)
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemContatoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
