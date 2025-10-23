package com.example.agenda_contatos.data

/**
 * Repositório em memória com uma lista estática de contatos para uso em testes
 * e prototipagem da interface.
 */
class ContatoRepository {
    private val contatos = mutableListOf(
        Contato(
            id = 1,
            nome = "Daniel Souza",
            telefone = "(11) 91234-5678",
            email = "daniel.souza@example.com",
            observacao = "Colega da faculdade"
        ),
        Contato(
            id = 2,
            nome = "Mariana Lima",
            telefone = "(21) 99876-5432",
            email = "mariana.lima@example.com",
            observacao = "Contato profissional"
        ),
        Contato(
            id = 3,
            nome = "Carlos Pereira",
            telefone = "(31) 93456-7890",
            email = "carlos.pereira@example.com",
            observacao = "Prefere ser contatado à tarde"
        ),
        Contato(
            id = 4,
            nome = "Ana Ribeiro",
            telefone = "(41) 98765-1234",
            email = "ana.ribeiro@example.com",
            observacao = "Mora em Curitiba"
        ),
        Contato(
            id = 5,
            nome = "Lucas Mendes",
            telefone = "(51) 97654-3210",
            email = "lucas.mendes@example.com",
            observacao = "Interessado em parcerias"
        )
    )

    fun getContatos(): List<Contato> = contatos.toList()

    fun remove(contato: Contato) {
        contatos.remove(contato)
    }
}
