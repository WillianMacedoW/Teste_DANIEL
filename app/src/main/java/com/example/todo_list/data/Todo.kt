package com.example.todo_list.data

import java.io.Serializable

data class Todo (
    val id: Int,
    val title: String,
    val description: String,
    val isCheck: Boolean,
    val date: String,
    val user: String
) : Serializable
