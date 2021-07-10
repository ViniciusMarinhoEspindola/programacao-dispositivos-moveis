package com.vinicius.app18_consulta_cep

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.vinicius.app18_consulta_cep.domain.EnderecoService
import com.vinicius.app18_consulta_cep.util.Network
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    lateinit var edtCep: EditText
    lateinit var btnPesquisar: ImageButton
    lateinit var preferenciasEndereco: SharedPreferences

    lateinit var txtCep: TextView
    lateinit var txtEndereco: TextView
    lateinit var txtBairro: TextView
    lateinit var txtCidade: TextView
    lateinit var txtUF: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // #Preferencias
        // Criando o arquivo de preferências
        preferenciasEndereco = getSharedPreferences("cepPreferences", Context.MODE_PRIVATE)

        btnPesquisar = findViewById(R.id.btnPesquisar)
        edtCep = findViewById(R.id.edtCep)

        txtCep = findViewById(R.id.txtCep)
        txtEndereco = findViewById(R.id.txtEndereco)
        txtBairro = findViewById(R.id.txtBairro)
        txtCidade = findViewById(R.id.txtCidade)
        txtUF = findViewById(R.id.txtUF)

        btnPesquisar.setOnClickListener() {
            if (edtCep.text.toString().isNotEmpty()) {
                adicionarEndereco(edtCep.text.toString())
                edtCep.text.clear()

                // Apagar a preferência gravada anteriormente
                val editor = preferenciasEndereco.edit()
                editor.remove("CEP")
                editor.commit()
            } else {
                edtCep.error = "Insira um cep válido!"
            }
        }
    }

    fun adicionarEndereco(cep_busca: String) {
        val retrofitClient = Network.retrofitConfig("https://viacep.com.br/ws/")
        val servico = retrofitClient.create(EnderecoService::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = servico.buscarEndereco(cep=cep_busca.replace( "-", ""))

                withContext(Main){
                    if (response.isSuccessful){
                        txtCep.text = response.body()?.cep
                        txtEndereco.text = response.body()?.endereco
                        txtBairro.text = response.body()?.bairro
                        txtCidade.text = response.body()?.cidade
                        txtUF.text = response.body()?.uf

                        Toast.makeText(this@MainActivity, "Cep encontrado", Toast.LENGTH_LONG).show()
                    }
                }
            } catch (e: Exception){
                Log.e("BUSCA_CEP", e.toString(), e)
                withContext(Main){
                    Toast.makeText(this@MainActivity, "Não foi possível processar a sua solicitação!", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

}