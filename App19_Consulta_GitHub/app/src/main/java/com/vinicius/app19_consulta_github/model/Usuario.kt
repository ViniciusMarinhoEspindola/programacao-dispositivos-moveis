package com.vinicius.app19_consulta_github.data.model

import android.graphics.drawable.Drawable
import com.google.gson.annotations.SerializedName

data class Usuario(
    @SerializedName("id") var id: String,
    @SerializedName("login") val login: String,
    @SerializedName("name") val nome: String,
    @SerializedName("url") val url: String,
    @SerializedName("avatar_url") var avatar: String
)
