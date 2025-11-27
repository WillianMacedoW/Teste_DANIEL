package com.example.agenda_contatos

import android.app.Application
import com.example.agenda_contatos.data.ContatoRepository
import com.example.agenda_contatos.data.local.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AgendaApp : Application() {

    val database: AppDatabase by lazy { AppDatabase.getInstance(this) }
    val repository: ContatoRepository by lazy { ContatoRepository(database.contatoDao()) }

    override fun onCreate() {
        super.onCreate()
        CoroutineScope(Dispatchers.IO).launch {
            repository.ensureSeedData()
        }
    }
}
