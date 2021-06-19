package com.vinicius.app4_alcoolgasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var textResultado: TextView
    lateinit var buttonCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textResultado = findViewById(R.id.resultado)
        buttonCalcular = findViewById(R.id.btnCalcular)

        buttonCalcular.setOnClickListener {
            calculaMelhorOpcao()
        }
    }

    fun calculaMelhorOpcao() {
        var precoAlcool = findViewById<EditText>(R.id.inputAlcool).text.toString().toDouble()
        var precoGasolina = findViewById<EditText>(R.id.inputGasolina).text.toString().toDouble()
        var resultado:Double = (precoAlcool / precoGasolina)

        if(resultado < 0.7) {
            textResultado.text = "Melhor utilizar o Álcool!"
        } else if(resultado > 0.7) {
            textResultado.text = "Melhor utilizar a Gasolina!"
        } else {
            textResultado.text = "Os dois são iguais!"
        }
    }
}