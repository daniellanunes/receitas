package com.daniellanunes.receitas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder


class ReceitasAdapter(val clique : (ReceitasDados) -> Unit) : Adapter<ReceitasAdapter.ReceitasViewHolder>() {

    var listaReceitas = listOf<ReceitasDados>()

    fun configurarLista (lista: List<ReceitasDados>){
        listaReceitas = lista
        notifyDataSetChanged()
    }

    inner class ReceitasViewHolder (val itemView : View) : ViewHolder(itemView) {


        //private lateinit var view : View
        private lateinit var textTitulo: TextView
        private lateinit var textTempo: TextView
        private lateinit var imgReceita: ImageView
        private lateinit var clItem: ConstraintLayout
        init {
            //view = itemView
            textTitulo = itemView.findViewById(R.id.text_receita)
            textTempo = itemView.findViewById(R.id.text_tempo)
            imgReceita = itemView.findViewById(R.id.img_receita)
            clItem = itemView.findViewById(R.id.cl_item)
        }

        fun bind (receita: ReceitasDados){
            textTitulo.text = receita.titulo
            textTempo.text = receita.tempo
            imgReceita.setImageDrawable(
                ContextCompat.getDrawable(itemView.context, receita.resIdImagem)
            )

            //evento de clique

            clItem.setOnClickListener {
                Toast.makeText(clItem.context, "Acessando Receita", Toast.LENGTH_SHORT)
            }

            clItem.setOnClickListener {
                clique(receita)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReceitasViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.item_receitas, parent, false)
        return ReceitasViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: ReceitasViewHolder, position: Int) {
        val receita = listaReceitas[position]
        holder.bind(receita)
    }


    override fun getItemCount(): Int {
        return listaReceitas.size
    }

}