package com.vinicius.app17_tarefas_com_retrofit

import com.google.gson.annotations.SerializedName

data class Tarefa(
    @SerializedName("id") var id: Int=0,
    @SerializedName("nome") val nome: String
)
