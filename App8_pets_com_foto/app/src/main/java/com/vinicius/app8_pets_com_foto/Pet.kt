package com.vinicius.app8_pets_com_foto

import android.graphics.drawable.Drawable

data class Pet(
    var img: Drawable?=null,
    var nome: String,
    var tipo: Tipo,
    var raca: String,
    var idade: String
)
