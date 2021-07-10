package com.vinicius.app15_room_database

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity(), TarefaAdapterListener {
    lateinit var tarefaAdapter: TarefaAdapter
    lateinit var edtTarefa: EditText
    lateinit var btnIncluir: ImageButton
    lateinit var preferenciasTarefa: SharedPreferences
    lateinit var rv: RecyclerView

    var db: AppDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // #Preferencias
        // Criando o arquivo de preferências
        preferenciasTarefa = getSharedPreferences("tarefaPreferences", Context.MODE_PRIVATE)

        rv = findViewById<RecyclerView>(R.id.rvTarefas)

        btnIncluir = findViewById(R.id.btnIncluir)
        edtTarefa = findViewById(R.id.edtTarefa)

        btnIncluir.setOnClickListener() {
            if (edtTarefa.text.toString().isNotEmpty()) {
                adicionarTarefa(edtTarefa.text.toString())
                edtTarefa.text.clear()

                // Apagar a preferência gravada anteriormente
                val editor = preferenciasTarefa.edit()
                editor.remove("NOME")
                editor.commit()
            } else {
                edtTarefa.error = "Insira um texto válido!"
            }
        }
    }

    fun adicionarTarefa(nomeTarefa: String) {
        // Coroutine para Entrada/Saída de Dados
        CoroutineScope(Dispatchers.IO).launch {
            // Cria ou recupera o BD da aplicação
            db = DatabaseBuilder.getAppDatabase(this@MainActivity)

            // A partir do DAO executa uma ação escolhida (INSERT)
            db?.tarefaDao()?.addTarefas(Tarefa(nome = nomeTarefa))

            // Recupera ações/métodos de acesso a dados da entidade (tabela)
            val tarefaDAO = db?.tarefaDao()

            // A partir do DAO executa uma ação escolhida (SELECT)
            val resposta = tarefaDAO?.getTarefas()

            // Coroutine para UI
            withContext(Dispatchers.Main) {
                resposta?.let {
                    tarefaAdapter.refreshListTarefa(resposta)
                }
            }
        }
    }

    fun recuperarLista(){
        // Coroutine para Entrada/Saída de Dados
        CoroutineScope(Dispatchers.IO).launch {
            // Cria ou recupera o BD da aplicação
            db = DatabaseBuilder.getAppDatabase(this@MainActivity)

            // Recupera ações/métodos de acesso a dados da entidade (tabela)
            val tarefaDAO = db?.tarefaDao()

            // A partir do DAO executa uma ação escolhida (SELECT)
            val resposta = tarefaDAO?.getTarefas()

            // Coroutine para UI
            withContext(Dispatchers.Main){
                resposta?.let{
                    tarefaAdapter = TarefaAdapter(it, this@MainActivity)

                    // Vincula o Adapter na Recycler View
                    rv.adapter = tarefaAdapter

                    // Exibe os itens em uma coluna única no padrão vertical
                    rv.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }
        }
    }

    // #Preferencias
    override fun onPause() {
        super.onPause()

        if (edtTarefa.text.toString().isNotEmpty()){

            // Cria e edição na preferência
            val editor = preferenciasTarefa.edit()

            // Escreve um uma preferência
            editor.putString("NOME", edtTarefa.text.toString())

            // Salva a preferência
            editor.commit()
        }
    }

    // #Preferencias
    override fun onResume() {
        super.onResume()

        // Recupera (lê) uma preferência e utiliza ela populando um Edit Text
        edtTarefa.setText(preferenciasTarefa.getString("NOME", null))
    }

    override fun onStart() {
        super.onStart()

        recuperarLista()
    }

    override fun excluirTarefa(tarefa: Tarefa) {
        // Coroutine para Entrada/Saída de Dados
        CoroutineScope(Dispatchers.IO).launch {
            // Cria ou recupera o BD da aplicação
            db = DatabaseBuilder.getAppDatabase(this@MainActivity)

            // A partir do DAO executa uma ação escolhida (DELETE)
            db?.tarefaDao()?.deleteTarefa(tarefa)

            // Recupera ações/métodos de acesso a dados da entidade (tabela)
            val tarefaDAO = db?.tarefaDao()

            // A partir do DAO executa uma ação escolhida (SELECT)
            val resposta = tarefaDAO?.getTarefas()

            // Coroutine para UI
            withContext(Dispatchers.Main) {
                resposta?.let {
                    tarefaAdapter.refreshListTarefa(resposta)

                    Toast.makeText(this@MainActivity, "Tarefa excluída", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}