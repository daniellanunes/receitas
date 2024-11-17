package com.daniellanunes.receitas

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvReceitas : RecyclerView
    private lateinit var receitasAdapter : ReceitasAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val lista = listOf(
            ReceitasDados ("Escondidinho de Camarão", "25 Min", R.drawable.carne1,
                listOf("1 kg de camarão", "Manteiga", "Alho", "Cebola")
            ),
            ReceitasDados ("Panqueca de Carne moída", "30 Min", R.drawable.carne2,
                listOf("1 kg de carne", "Manteiga", "Alho", "Cebola")),
            ReceitasDados ("Rocambole de Carne moída", "20 Min", R.drawable.carne3,
                listOf("1 kg de carne moída", "Manteiga", "Alho", "Cebola")),
            ReceitasDados ("Escondidinho e carne seca", "32 Min", R.drawable.carne4,
                listOf("1 kg de carne seca", "Manteiga", "Alho", "Cebola"))
        )

        rvReceitas = findViewById(R.id.rv_receitas)
        receitasAdapter = ReceitasAdapter{ receita ->
            val intent = Intent(this, DetalhesActivity:: class.java)
            intent.putExtra("receita", receita)
            startActivity(intent)
        }
        rvReceitas.adapter = receitasAdapter
        receitasAdapter.configurarLista(lista)

        rvReceitas.layoutManager = LinearLayoutManager(this)

    }
}