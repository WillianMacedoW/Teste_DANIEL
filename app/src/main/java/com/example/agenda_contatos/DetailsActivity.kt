package com.example.agenda_contatos

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.agenda_contatos.data.Contato

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.detailsRoot)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val id = findViewById<TextView>(R.id.contatoId)
        val nome = findViewById<TextView>(R.id.contatoNome)
        val telefone = findViewById<TextView>(R.id.contatoTelefone)
        val email = findViewById<TextView>(R.id.contatoEmail)
        val observacao = findViewById<TextView>(R.id.contatoObservacao)

        val contato = intent.getContatoExtra()
        contato?.let {
            id.text = getString(R.string.contato_id_format, it.id)
            nome.text = it.nome
            telefone.text = getString(R.string.contato_phone, it.telefone)
            email.text = getString(R.string.contato_email, it.email)
            observacao.text = getString(R.string.contato_observacao, it.observacao)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun Intent.getContatoExtra(): Contato? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            getSerializableExtra("contato", Contato::class.java)
        } else {
            @Suppress("DEPRECATION")
            getSerializableExtra("contato") as? Contato
        }
    }
}
