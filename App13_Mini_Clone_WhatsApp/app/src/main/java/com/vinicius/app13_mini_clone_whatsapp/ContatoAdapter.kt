package com.vinicius.app13_mini_clone_whatsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContatoAdapter(var listaContato: MutableList<Contato>):RecyclerView.Adapter<ContatoAdapter.ItemViewHolder>() {
    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val img: ImageView = view.findViewById(R.id.imgContato)
        val nome: TextView = view.findViewById(R.id.nomeContato)
        val mensagem: TextView = view.findViewById(R.id.mensagem)
        val data: TextView = view.findViewById(R.id.horario)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_conversa, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        listaContato[position].img?.let{
            holder.img.setImageDrawable(it)
        }
        holder.nome.text = listaContato[position].nome
        holder.mensagem.text = listaContato[position].mensagem
        holder.data.text = listaContato[position].data

    }

    override fun getItemCount(): Int {
        return listaContato.size
    }
}