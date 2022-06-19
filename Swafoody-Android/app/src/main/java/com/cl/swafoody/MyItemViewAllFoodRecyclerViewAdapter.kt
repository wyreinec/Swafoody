package com.cl.swafoody

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cl.swafoody.databinding.ItemBinding
import com.cl.swafoody.placeholder.PlaceholderContent.PlaceholderItem
import com.cl.swafoody.recyclerView.item

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyItemViewAllFoodRecyclerViewAdapter(
    private val savedFoods: ArrayList<item>,
    private val listener: (item, Int) -> Unit

) : RecyclerView.Adapter<MyItemViewAllFoodRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyItemViewAllFoodRecyclerViewAdapter.ViewHolder {
        val v = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyItemViewAllFoodRecyclerViewAdapter.ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(savedFoods[position])
        holder.itemView.setOnClickListener { listener(savedFoods[position], position) }
    }

    override fun getItemCount(): Int = savedFoods.size


    class ViewHolder(var itemBinding: ItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(savedFoods: item) {
            itemBinding.image.setImageResource(savedFoods.image)
            itemBinding.name.text = savedFoods.name
        }
    }

}