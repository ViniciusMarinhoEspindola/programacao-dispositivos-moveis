package com.vinicius.app8_pets_com_foto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PetAdapter(var listaPets: MutableList<Pet>):RecyclerView.Adapter<PetAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val img: ImageView = view.findViewById(R.id.imgPet)
        val nome: TextView = view.findViewById(R.id.nomePet)
        val tipo: TextView = view.findViewById(R.id.tipoPet)
        val raca: TextView = view.findViewById(R.id.racaPet)
        val idade: TextView = view.findViewById(R.id.idade)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pet, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        listaPets[position].img?.let{
            holder.img.setImageDrawable(it)
        }
        holder.nome.text = listaPets[position].nome
        holder.tipo.text = listaPets[position].tipo.nome
        holder.raca.text = listaPets[position].raca
        holder.idade.text = listaPets[position].idade

    }

    override fun getItemCount(): Int {
        return listaPets.size
    }
}