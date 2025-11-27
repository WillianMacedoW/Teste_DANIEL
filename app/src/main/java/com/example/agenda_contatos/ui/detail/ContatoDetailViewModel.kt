package com.example.agenda_contatos.ui.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.agenda_contatos.AgendaApp

class ContatoDetailViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = (application as AgendaApp).repository

    fun getContato(id: Int) = repository.getContato(id)
}
