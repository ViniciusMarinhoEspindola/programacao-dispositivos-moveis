package com.vinicius.app7_listagemcomfoto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.rvUsuarios)

        val lista = mutableListOf<Usuario>(
            Usuario(nome="Vinícius", email="vinicius.marinho@fatec.sp.gov.com", stack= Stack.BACKEND, senioridade= Senioridade.SENIOR, foto=resources.getDrawable(R.drawable.pinguins)),
            Usuario(nome="Macgyver", email="mac@gmail.com", stack= Stack.BACKEND, senioridade= Senioridade.PLENO)
        )

        rv.adapter = UsuarioAdapter(lista)

        // Exibe os itens em uma coluna única no padrão vertical
        rv.layoutManager = LinearLayoutManager(this)

        // Exibe os itens em uma coluna única no padrão horizontal
        // rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // Exibe os itens em uma tabela com x colunas
        // rv.layoutManager = GridLayoutManager(this, 2)

        // Exibe os itens em uma tabela porém as células são ajustadas automaticamente de acordo com o conteúdo (Google Keep, Pintrest)
        // rv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

    }
}
