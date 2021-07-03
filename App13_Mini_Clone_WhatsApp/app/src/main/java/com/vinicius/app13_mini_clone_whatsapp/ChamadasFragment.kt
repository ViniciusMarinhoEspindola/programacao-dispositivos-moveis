package com.vinicius.app13_mini_clone_whatsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ChamadasFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chamadas, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rv =  view.findViewById<RecyclerView>(R.id.rvChamadas)

        val listaContato = mutableListOf<Contato>(
            Contato(nome="Caio Rodrigues", data="23 de junho 12:15 da Tarde"),
            Contato(nome="Nicole Santana", data="15 de junho 11:47 da Noite"),
            Contato(nome="Pedro Henrique", data="10 de maio 10:22 da Manhã"),
            Contato(nome="Marcio Leonardo", data="9 de maio 11:43 da Manhã"),
            Contato(nome="Bianca Chaves", data="15 de abril 05:22 da Tarde"),
            Contato(nome="Leticia de Souza", data="08 de abril 09:12 da Noite"),
            Contato(nome="Rodrigo dos Santos", data="16 de março 08:22 da Manhã"),
            Contato(nome="Robson Rafael", data="19 de fevereiro 06:52 da Tarde"),
            Contato(nome="Carlos Andrade", data="16 de fevereiro 11:22 da Manhã"),
            Contato(nome="Nicole Santana", data="23 de janeiro 11:13 da Noite"),
            Contato(nome="Leticia de Souza", data="03 de janeiro 11:53 da Noite"),
            )

        rv.adapter = StatusAdapter(listaContato)
        rv.layoutManager = LinearLayoutManager(getContext())
    }
}