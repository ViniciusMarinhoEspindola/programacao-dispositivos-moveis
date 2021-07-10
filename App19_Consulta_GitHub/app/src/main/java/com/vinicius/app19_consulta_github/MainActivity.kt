package com.vinicius.app19_consulta_github

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.vinicius.app19_consulta_github.domain.GitService
import com.vinicius.app19_consulta_github.util.Network
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    lateinit var edtGit: EditText
    lateinit var btnPesquisar: ImageButton
    lateinit var preferenciasUser: SharedPreferences

    lateinit var imgUser: TextView
    lateinit var txtId: TextView
    lateinit var txtLogin: TextView
    lateinit var txtNome: TextView
    lateinit var txtUrl: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        preferenciasUser= getSharedPreferences("userPreferences", Context.MODE_PRIVATE)

        btnPesquisar = findViewById(R.id.btnPesquisar)
        edtGit = findViewById(R.id.edtGit)

        imgUser = findViewById(R.id.imgPerfil)
        txtId = findViewById(R.id.id)
        txtLogin = findViewById(R.id.login)
        txtNome = findViewById(R.id.nome)
        txtUrl = findViewById(R.id.url)

        btnPesquisar.setOnClickListener() {
            if (edtGit.text.toString().isNotEmpty()) {
                pesquisarGit(edtGit.text.toString())
                edtGit.text.clear()


                val editor = preferenciasUser.edit()
                editor.remove("USER")
                editor.commit()
            } else {
                edtGit.error = "Insira um nome de usuário válido!"
            }
        }
    }

    fun pesquisarGit(usuario_busca: String) {
        val retrofitClient = Network.retrofitConfig("https://api.github.com/users/")
        val servico = retrofitClient.create(GitService::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = servico.buscarUser(user=usuario_busca)

                withContext(Main){
                    if (response.isSuccessful){
                        imgUser.text = response.body()?.avatar
                        txtId.text = response.body()?.id
                        txtLogin.text = response.body()?.login
                        txtNome.text = response.body()?.nome
                        txtUrl.text = response.body()?.url

                        Toast.makeText(this@MainActivity, "Usuário encontrado", Toast.LENGTH_LONG).show()
                    }
                }
            } catch (e: Exception){
                Log.e("BUSCA_USUARIO", e.toString(), e)
                withContext(Main){
                    Toast.makeText(this@MainActivity, "Não foi possível processar a sua solicitação!", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}