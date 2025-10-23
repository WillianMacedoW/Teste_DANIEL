package com.example.todo_list

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_list.data.Todo
import com.example.todo_list.data.TodoRepository
import com.example.todo_list.data.ui.adapter.TodoAdapter
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private val repository = TodoRepository()
    private lateinit var adapter: TodoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val rc = findViewById<RecyclerView>(R.id.recycler)
        adapter = TodoAdapter(
            actionDelete = { todo ->
                deleteTodo(rc, todo)
            },
            actionview = { todo ->
                goToDetails(todo = todo)
            }
        )
        rc.adapter = adapter

        adapter.submitList(repository.todoList)
    }

    private fun deleteTodo(recyclerView: RecyclerView, todo: Todo) {
        val newList = repository.todoList.toMutableList()
        newList.remove(todo)
        adapter.submitList(newList)

        Snackbar.make(this, recyclerView, "Deletado com Sucesso", Snackbar.LENGTH_LONG).show()
    }

    private fun goToDetails(todo: Todo) {
        val intent = Intent(this, DetailsActivity::class.java).apply {
            this.putExtras(bundleOf("todo" to todo))
        }
        startActivity(intent)
    }
}
