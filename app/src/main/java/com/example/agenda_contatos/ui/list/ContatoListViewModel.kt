package com.example.agenda_contatos.ui.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.agenda_contatos.AgendaApp
import com.example.agenda_contatos.data.Contato
import kotlinx.coroutines.launch

class ContatoListViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = (application as AgendaApp).repository

    val contatos = repository.contatos

    fun delete(contato: Contato) {
        viewModelScope.launch {
            repository.delete(contato)
        }
    }
}
