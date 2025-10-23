package com.example.todo_list.data

class TodoRepository {
    val todoList = listOf(
        Todo(
            1,
            "Comprar leite",
            "Comprar 1L de leite no mercado",
            false,
            "10/01/2025",
            "Daniel"
        ),
        Todo(
            2,
            "Estudar Kotlin",
            "Revisar classes, objetos e funções",
            false,
            "02/01/2025",
            "Daniel"
        ),
        Todo(
            3,
            "Fazer exercícios",
            "Treinar na academia por 1 hora",
            false,
            "20/01/2025",
            "Daniel"
        ),
        Todo(
            4,
            "Pagar contas",
            "Pagar fatura do cartão de crédito",
            false,
            "10/02/2025",
            "Daniel"
        ),
        Todo(
            5,
            "Fazer compras",
            "Lista de compras: arroz, feijão, carne",
            false,
            "23/03/2025",
            "Daniel"
        ),
        Todo(
            6,
            "Assistir aula online",
            "Ver aula de programação Android",
            false,
            "10/07/2025",
            "Daniel"
        ),
        Todo(
            7,
            "Ler um livro",
            "Ler 20 páginas do livro atual",
            false,
            "18/01/2025",
            "Daniel"
        ),
        Todo(
            8,
            "Enviar e-mails",
            "Responder e-mails pendentes do trabalho",
            false,
            "29/09/2025",
            "Daniel"
        ),
        Todo(
            9,
            "Organizar a casa",
            "Arrumar a sala e o quarto",
            false,
            "02/07/2025",
            "Daniel"
        ),
        Todo(
            10,
            "Estudar inglês",
            "Praticar 30 minutos de conversação",
            false,
            "10/01/2025",
            "Daniel"
        ),
        Todo(
            11,
            "Caminhar no parque",
            "Fazer caminhada de 5km",
            false,
            "10/01/2025",
            "Daniel"
        ),
        Todo(
            12,
            "Cozinhar jantar",
            "Preparar uma refeição saudável",
            false,
            "10/01/2025",
            "Daniel"
        ),
        Todo(
            13,
            "Ir ao dentista",
            "Consulta agendada para as 14h",
            false,
            "10/01/2025",
            "Daniel"
        ),
        Todo(
            14,
            "Atualizar currículo",
            "Adicionar experiência recente",
            false,
            "10/01/2025",
            "Daniel"
        ),
        Todo(
            15,
            "Fazer meditação",
            "Praticar 10 minutos de mindfulness",
            false,
            "10/01/2025",
            "Daniel"
        ),
        Todo(
            16,
            "Fazer backup",
            "Salvar arquivos importantes no drive",
            false,
            "10/01/2025",
            "Daniel"
        ),
        Todo(
            17,
            "Ligar para família",
            "Conversar com os pais e irmãos",
            false,
            "10/01/2025",
            "Daniel"
        ),
        Todo(
            18,
            "Criar projeto pessoal",
            "Iniciar um novo app Android",
            false,
            "10/01/2025",
            "Daniel"
        ),
        Todo(
            19,
            "Revisar orçamento",
            "Atualizar planilha de gastos do mês",
            false,
            "10/01/2025",
            "Daniel"
        ),
        Todo(
            20,
            "Fazer compras online",
            "Comprar novo fone de ouvido",
            false,
            "10/01/2025",
            "Daniel"
        ),
        Todo(
            21,
            "Pintar a casa",
            "Comprar tinta e materiais necessários",
            false,
            "10/01/2025",
            "Daniel"
        ),
        Todo(
            22,
            "Trocar senha do e-mail",
            "Atualizar senha para maior segurança",
            false,
            "10/01/2025",
            "Daniel"
        ),
        Todo(
            23,
            "Aprender uma nova receita",
            "Testar um prato diferente",
            false,
            "10/01/2025",
            "Daniel"
        ),
        Todo(
            24,
            "Fazer revisão do carro",
            "Verificar óleo e pneus",
            false,
            "10/01/2025",
            "Daniel"
        ),
        Todo(
            25,
            "Limpar a caixa de entrada",
            "Organizar e-mails e deletar os inúteis",
            false,
            "10/01/2025",
            "Daniel"
        ),
        Todo(
            26,
            "Criar um planejamento semanal",
            "Organizar tarefas e compromissos",
            false,
            "10/01/2025",
            "Daniel"
        ),
        Todo(
            27,
            "Tomar vacina",
            "Agendar e tomar a vacina de reforço",
            false,
            "10/01/2025",
            "Daniel"
        ),
        Todo(
            28,
            "Assistir um documentário",
            "Escolher um tema interessante",
            false,
            "10/01/2025",
            "Daniel"
        ),
        Todo(
            29,
            "Montar um quebra-cabeça",
            "Terminar o de 1000 peças",
            false,
            "10/01/2025",
            "Daniel"
        ),
        Todo(
            30,
            "Escrever no diário",
            "Registrar aprendizados do dia",
            false,
            "10/01/2025",
            "Daniel"
        )
    )

    fun getTodos() = todoList
}