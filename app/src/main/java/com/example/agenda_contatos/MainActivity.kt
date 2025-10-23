package com.example.agenda_contatos

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.agenda_contatos.data.Contato
import com.example.agenda_contatos.data.ContatoRepository
import com.example.agenda_contatos.data.ui.adapter.ContatoAdapter
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private val repository = ContatoRepository()
    private lateinit var adapter: ContatoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val recyclerView = findViewById<RecyclerView>(R.id.recycler)
        adapter = ContatoAdapter(
            onView = ::goToDetails,
            onDelete = { contato -> deleteContato(recyclerView, contato) },
        )
        recyclerView.adapter = adapter

        refreshContatos()
    }

    private fun deleteContato(recyclerView: RecyclerView, contato: Contato) {
        repository.remove(contato)
        refreshContatos()

        Snackbar.make(recyclerView, R.string.contato_deleted_success, Snackbar.LENGTH_LONG).show()
    }

    private fun goToDetails(contato: Contato) {
        val intent = Intent(this, DetailsActivity::class.java).apply {
            this.putExtras(bundleOf("contato" to contato))
        }
        startActivity(intent)
    }

    private fun refreshContatos() {
        adapter.submitList(repository.getContatos())
    }
}
