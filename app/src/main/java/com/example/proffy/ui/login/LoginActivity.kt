package com.eder.proffy.ui.login

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.eder.proffy.R
import com.eder.proffy.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)
        ) { view, insets ->
            val barras = insets.getInsets(
                WindowInsetsCompat.Type.systemBars()
            )

            view.setPadding(
                barras.left + 24,
                barras.top + 24,
                barras.right + 24,
                barras.bottom + 24
            )

            insets
        }

        binding.btnEntrar.setOnClickListener {
            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()

            // Exibe o e-mail e mantém a senha protegida.
            val senhaOculta = "*".repeat(senha.length)
            val mensagem = "E-mail: $email\nSenha: $senhaOculta"

            Toast.makeText(
                this,
                mensagem,
                Toast.LENGTH_LONG
            ).show()
        }
    }
}