package com.vinicius.app9_tarefas_de_texto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvAnotacoes = findViewById<RecyclerView>(R.id.rvAnotacoes)

        val listaAnotacoes = mutableListOf<Anotacao>(
            Anotacao(titulo = "Silvio Santos Ipsum ", texto = "Estamos em ritmo de festamm. Mah você não consegue né Moisés? Você não consegueam. Ha haeeee. Hi hi. Eu não queria perguntar isso publicamente, ma vou perguntar. Carla, você tem o ensino fundamentauam? É fácil ou não éam? Mah roda a roduamm. Ma vale dérreaisam?"),
            Anotacao(titulo = "Lorem Ipsum ", texto = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."),
            Anotacao(titulo = "Bacon ipsum ", texto = "Bacon ipsum dolor amet venison hamburger tongue bresaola flank prosciutto doner, pork capicola leberkas tenderloin turducken. Ball tip picanha tenderloin filet mignon fatback tongue, leberkas shankle shank frankfurter jowl prosciutto. Cow short ribs ground round meatloaf picanha chicken, chislic pork chop. Bacon ball tip alcatra frankfurter.")
        )

        rvAnotacoes.adapter = AnotacaoAdapter(listaAnotacoes)
        rvAnotacoes.layoutManager = GridLayoutManager(this, 2)
    }
}