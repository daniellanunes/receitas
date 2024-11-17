package com.daniellanunes.receitas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PrincipalActivity : AppCompatActivity() {

    private lateinit var btnAcesso : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_principal)

        btnAcesso = findViewById(R.id.btn_acess)

        btnAcesso.setOnClickListener {

            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}