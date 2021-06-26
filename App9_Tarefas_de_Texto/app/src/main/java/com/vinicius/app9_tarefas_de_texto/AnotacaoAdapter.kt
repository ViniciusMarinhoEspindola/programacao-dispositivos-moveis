package com.vinicius.app9_tarefas_de_texto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class AnotacaoAdapter(var listaAnotacao: MutableList<Anotacao>):RecyclerView.Adapter<AnotacaoAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val titulo: TextView = view.findViewById(R.id.titulo)
        val texto: TextView = view.findViewById(R.id.texto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_anotacao, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.titulo.text = listaAnotacao[position].titulo
        holder.texto.text = listaAnotacao[position].texto

    }

    override fun getItemCount(): Int {
        return listaAnotacao.size
    }
}