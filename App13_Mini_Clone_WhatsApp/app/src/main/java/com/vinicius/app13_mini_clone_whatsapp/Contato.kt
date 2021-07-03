package com.vinicius.app13_mini_clone_whatsapp

import android.graphics.drawable.Drawable

data class Contato(
    var img: Drawable?=null,
    var nome: String,
    var mensagem: String?=null,
    var data: String
)
