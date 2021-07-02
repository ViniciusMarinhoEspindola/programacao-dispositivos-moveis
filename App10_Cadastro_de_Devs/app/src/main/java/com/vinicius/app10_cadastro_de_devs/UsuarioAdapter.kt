package com.vinicius.app10_cadastro_de_devs

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import java.net.URI

class UsuarioAdapter(var listaUsuario: MutableList<Usuario>, var context: Context):RecyclerView.Adapter<UsuarioAdapter.ItemViewHolder>() {

    // Responsável por encontrar os componentes dentro do layout (item_usuario) e indicar que o
    //  layout será replicado na Recycler View
    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imgFoto: ImageView = view.findViewById(R.id.imgFoto)
        val txtNome: TextView = view.findViewById(R.id.txtNome)
        val txtStack: TextView = view.findViewById(R.id.txtStack)
        val txtSenioridade: TextView = view.findViewById(R.id.txtSenioridade)
    }

    // Responsável por inflar (fazer aparecer) o layout por exemplo na activity ou fragment ou dialog (tudo que extends View Group)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_usuario, parent, false)
        return ItemViewHolder(view)
    }

    // Vincula os componentes do layout (item_usuario) a um dado/propriedade/atributo da lista
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        listaUsuario[position].foto?.let{
            holder.imgFoto.setImageBitmap(it)
        }
        holder.txtNome.text = listaUsuario[position].nome
        holder.txtStack.text = listaUsuario[position].stack.nome
        holder.txtSenioridade.text = listaUsuario[position].senioridade.nome

        // Implementando o "click" do CardView para retornar um Toast como mensagem
        holder.itemView.setOnClickListener(){
            var texto = if (listaUsuario[position].empregado) {
                "Dev na ativa!"
            }
            else
            {
                "Dev procurando job!"
            }

            Toast.makeText(context, texto, Toast.LENGTH_SHORT).show()
        }
    }

    // Indica quantos registros/itens a lista possui
    override fun getItemCount(): Int {
        return listaUsuario.size
    }
}
