package com.cl.swafoody.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cl.swafoody.databinding.ItemBinding

class CustomAdapter(
    private val savedFoods: ArrayList<item>,
    private val listener: (item, Int) -> Unit
) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(savedFoods[position])
        holder.itemView.setOnClickListener { listener(savedFoods[position], position) }
    }

    override fun getItemCount(): Int {
        return savedFoods.size
    }

    class ViewHolder(var itemBinding: ItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(savedFoods: item) {
            itemBinding.image.setImageResource(savedFoods.image)
            itemBinding.name.text = savedFoods.name
        }
    }
}


