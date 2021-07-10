package com.vinicius.app18_consulta_cep.data.model

import com.google.gson.annotations.SerializedName

data class Endereco(
    @SerializedName("cep") var cep: String,
    @SerializedName("logradouro") val endereco: String,
    @SerializedName("bairro") val bairro: String,
    @SerializedName("localidade") val cidade: String,
    @SerializedName("uf") val uf: String,
)
