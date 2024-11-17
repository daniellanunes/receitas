package com.daniellanunes.receitas

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

/*data class ReceitasDados(
    val titulo : String,
    val tempo : String,
    val resIdImagem : Int

) : Serializable*/

@Parcelize
data class ReceitasDados(
    val titulo : String,
    val tempo : String,
    val resIdImagem : Int,
    val ingredientes : List<String>

) : Parcelable