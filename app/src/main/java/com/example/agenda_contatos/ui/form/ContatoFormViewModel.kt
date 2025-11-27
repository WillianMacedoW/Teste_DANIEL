package com.example.agenda_contatos.ui.form

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import com.example.agenda_contatos.AgendaApp
import com.example.agenda_contatos.data.Contato
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch

class ContatoFormViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = (application as AgendaApp).repository

    private var currentId: Int = 0

    val nome = MutableLiveData("")
    val telefone = MutableLiveData("")
    val email = MutableLiveData("")
    val observacao = MutableLiveData("")

    private val _saved = MutableLiveData(false)
    val saved: LiveData<Boolean> = _saved

    fun loadContato(contatoId: Int) {
        if (contatoId < 0) return

        viewModelScope.launch {
            repository.getContato(contatoId)
                .asFlow()
                .firstOrNull { it != null }
                ?.let { contato ->
                    currentId = contato.id
                    nome.postValue(contato.nome)
                    telefone.postValue(contato.telefone)
                    email.postValue(contato.email)
                    observacao.postValue(contato.observacao)
                }
        }
    }

    fun salvarContato() {
        val contato = Contato(
            id = currentId,
            nome = nome.value.orEmpty(),
            telefone = telefone.value.orEmpty(),
            email = email.value.orEmpty(),
            observacao = observacao.value.orEmpty(),
        )

        viewModelScope.launch {
            repository.save(contato)
            _saved.postValue(true)
        }
    }
}
