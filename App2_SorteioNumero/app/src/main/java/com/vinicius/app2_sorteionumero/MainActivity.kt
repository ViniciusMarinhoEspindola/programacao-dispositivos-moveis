package com.vinicius.app2_sorteionumero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun SortearNumero(view: View) {
        var texto = findViewById(R.id.txtNumero) as TextView

        var numeroSorteado = Random().nextInt(11)

        texto.setText("O número é: $numeroSorteado")
    }
}