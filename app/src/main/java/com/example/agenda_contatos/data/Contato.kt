package com.example.agenda_contatos.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Representa um contato cadastrado no aplicativo.
 */
@Entity(tableName = "contatos")
data class Contato(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nome: String,
    val telefone: String,
    val email: String,
    val observacao: String,
)
