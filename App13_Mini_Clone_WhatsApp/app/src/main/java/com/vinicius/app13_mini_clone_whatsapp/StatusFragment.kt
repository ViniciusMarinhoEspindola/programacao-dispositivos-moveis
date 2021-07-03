package com.vinicius.app13_mini_clone_whatsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StatusFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_status, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rv =  view.findViewById<RecyclerView>(R.id.rvStatus)

        val listaContato = mutableListOf<Contato>(
            Contato(nome="Joseffe Barroso de Oliveira", data="12:15 da Tarde"),
            Contato(nome="Vinicius Nascimento", data="11:47 da Manhã"),
            Contato(nome="Marcio Leonardo", data="11:43 da Manhã"),
            Contato(nome="Bianca Chaves", data="11:22 da Manhã"),
            Contato(nome="Leticia de Souza", data="09:12 da Manhã"),
            Contato(nome="Rodrigo dos Santos", data="08:22 da Manhã"),
            Contato(nome="Pedro Henrique", data="07:22 da Manhã")

        )

        rv.adapter = StatusAdapter(listaContato)
        rv.layoutManager = LinearLayoutManager(getContext())
    }
}