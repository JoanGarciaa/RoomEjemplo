package com.example.roomexemple.listAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.roomexemple.R
import com.example.roomexemple.model.Client

class ClientRVAdapter : ListAdapter<Client, ClientRVAdapter.ClientHolder>(DiffCallback()) {

    class ClientHolder(view: View) : RecyclerView.ViewHolder(view)
    private lateinit var listener: RecyclerClickListener
    fun setItemListener(listener: RecyclerClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        val clientHolder = ClientHolder(v)


        val cliente = clientHolder.itemView.findViewById<CardView>(R.id.card_view)
        cliente.setOnClickListener {
            listener.onItemClick(clientHolder.adapterPosition)
        }

        return clientHolder
    }

    override fun onBindViewHolder(holder: ClientHolder, position: Int) {
        val currentItem = getItem(position)
        val nombre = holder.itemView.findViewById<TextView>(R.id.item_nombre)
        nombre.text = currentItem.nombre

        val edad = holder.itemView.findViewById<TextView>(R.id.item_edat)
        edad.text = currentItem.edad.toString()
    }

    class DiffCallback : DiffUtil.ItemCallback<Client>() {
        override fun areItemsTheSame(oldItem: Client, newItem: Client) =
            oldItem.nombre == newItem.nombre

        override fun areContentsTheSame(oldItem: Client, newItem: Client) =
            oldItem == newItem
    }
}