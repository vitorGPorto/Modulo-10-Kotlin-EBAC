package com.example.tarefa10

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tarefa10.databinding.ItemBinding

class ListAdapter (
    val listItems: MutableList<ContactInfo>,
    val listener: ListAdapterListener

        ): RecyclerView.Adapter<ListAdapter.ListItemViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
     return ListItemViewHolder (ItemBinding.inflate(LayoutInflater.from(parent.context),
          parent,
          false
      ))


    }

    override fun getItemCount(): Int {
      return listItems.size
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        val item = listItems[position]
        holder.position.text= position.toString()
        holder.conteudo.text = item.name+" "+item.phone

        holder.root.setOnClickListener {
            listener.onItemCliked(item.phone)
        }

    }

    class ListItemViewHolder(binding: ItemBinding): RecyclerView.ViewHolder(binding.root){
        var root = binding.root
        var position = binding.posicao
        var conteudo = binding.conteudo


    }
    interface ListAdapterListener{
        fun onItemCliked(content: String);
    }
}