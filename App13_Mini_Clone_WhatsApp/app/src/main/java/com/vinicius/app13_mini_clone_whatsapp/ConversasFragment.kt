package com.vinicius.app13_mini_clone_whatsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ConversasFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_conversas, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rv =  view.findViewById<RecyclerView>(R.id.rvContatos)

        val listaContato = mutableListOf<Contato>(
            Contato(nome="Joseffe Barroso de Oliveira", data="12:15 da Tarde", mensagem="Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book"),
            Contato(nome="Vinicius Nascimento", data="11:47 da Manhã", mensagem="Lorem Ipsum is simply dummy text of the printing and typesetting industry."),
            Contato(nome="Pedro Henrique", data="10:22 da Manhã", mensagem="Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book"),
            Contato(nome="Vinicius Nascimento", data="11:47 da Manhã", mensagem="Lorem Ipsum is simply dummy text of the printing and typesetting industry."),
            Contato(nome="Vinicius Nascimento", data="11:47 da Manhã", mensagem="Lorem Ipsum is simply dummy text of the printing and typesetting industry."),
            Contato(nome="Vinicius Nascimento", data="11:47 da Manhã", mensagem="Lorem Ipsum is simply dummy text of the printing and typesetting industry."),
            Contato(nome="Vinicius Nascimento", data="11:47 da Manhã", mensagem="Lorem Ipsum is simply dummy text of the printing and typesetting industry."),
            Contato(nome="Vinicius Nascimento", data="11:47 da Manhã", mensagem="Lorem Ipsum is simply dummy text of the printing and typesetting industry."),
            Contato(nome="Vinicius Nascimento", data="11:47 da Manhã", mensagem="Lorem Ipsum is simply dummy text of the printing and typesetting industry."),
            Contato(nome="Vinicius Nascimento", data="11:47 da Manhã", mensagem="Lorem Ipsum is simply dummy text of the printing and typesetting industry.")

        )

        rv.adapter = ContatoAdapter(listaContato)
        rv.layoutManager = LinearLayoutManager(getContext())
    }
}