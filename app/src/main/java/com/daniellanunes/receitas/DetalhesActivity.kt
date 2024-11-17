package com.daniellanunes.receitas

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class DetalhesActivity : AppCompatActivity() {

    private lateinit var imgDetalhe : ImageView
    private lateinit var textTituloDetalhe : TextView
    private lateinit var textTempoDetalhe : TextView
    private lateinit var textReceitaDetalhe : TextView
    private lateinit var btnDetalhe : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalhes)
        imgDetalhe = findViewById(R.id.img_detalhe)
        textTituloDetalhe = findViewById(R.id.text_titulo_detalhe)
        textTempoDetalhe = findViewById(R.id.text_tempo_detalhe)
        textReceitaDetalhe = findViewById(R.id.text_receita_detalhe)
        btnDetalhe = findViewById(R.id.btn_voltar_detalhe)


        val bundle = intent.extras
        if (bundle != null){

            val receita = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                bundle.getParcelable("receita", ReceitasDados::class.java)
            } else {
                bundle.getParcelable("receita")
            }
            if (receita != null){

                imgDetalhe.setImageDrawable(ContextCompat.getDrawable(this, receita.resIdImagem))

                textTempoDetalhe.text = receita.tempo
                textTituloDetalhe.text = receita.titulo

                val listaIngredientes = receita.ingredientes

                var textIngredientes = ""
                for (ingrediente in listaIngredientes){
                    textIngredientes += "- $ingrediente\n"

                }
                textReceitaDetalhe.text = textIngredientes

            }



        }


        btnDetalhe.setOnClickListener {
            finish()
        }

    }
}