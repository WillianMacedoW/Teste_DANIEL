package com.example.agenda_contatos.data

import java.io.Serializable

/**
 * Representa um contato cadastrado no aplicativo.
 */
data class Contato(
    val id: Int,
    val nome: String,
    val telefone: String,
    val email: String,
    val observacao: String
) : Serializable
