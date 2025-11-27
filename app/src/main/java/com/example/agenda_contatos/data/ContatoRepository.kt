package com.example.agenda_contatos.data

import androidx.lifecycle.LiveData
import com.example.agenda_contatos.data.local.ContatoDao

class ContatoRepository(private val dao: ContatoDao) {

    val contatos: LiveData<List<Contato>> = dao.getContatos()

    fun getContato(id: Int): LiveData<Contato?> = dao.getContato(id)

    suspend fun save(contato: Contato) {
        if (contato.id == 0) {
            dao.insert(contato)
        } else {
            dao.update(contato)
        }
    }

    suspend fun delete(contato: Contato) {
        dao.delete(contato)
    }

    suspend fun ensureSeedData() {
        if (dao.count() == 0) {
            dao.insertAll(
                listOf(
                    Contato(
                        nome = "Daniel Souza",
                        telefone = "(11) 91234-5678",
                        email = "daniel.souza@example.com",
                        observacao = "Colega da faculdade",
                    ),
                    Contato(
                        nome = "Mariana Lima",
                        telefone = "(21) 99876-5432",
                        email = "mariana.lima@example.com",
                        observacao = "Contato profissional",
                    ),
                    Contato(
                        nome = "Carlos Pereira",
                        telefone = "(31) 93456-7890",
                        email = "carlos.pereira@example.com",
                        observacao = "Prefere ser contatado à tarde",
                    ),
                    Contato(
                        nome = "Ana Ribeiro",
                        telefone = "(41) 98765-1234",
                        email = "ana.ribeiro@example.com",
                        observacao = "Mora em Curitiba",
                    ),
                    Contato(
                        nome = "Lucas Mendes",
                        telefone = "(51) 97654-3210",
                        email = "lucas.mendes@example.com",
                        observacao = "Interessado em parcerias",
                    ),
                )
            )
        }
    }
}
