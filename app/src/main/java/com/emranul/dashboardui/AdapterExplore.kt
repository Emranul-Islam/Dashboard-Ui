package com.emranul.dashboardui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.emranul.dashboardui.databinding.ItemExploreBinding

class AdapterExplore : RecyclerView.Adapter<AdapterExplore.ExploreViewHolder>() {

    class ExploreViewHolder(val binding: ItemExploreBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreViewHolder {
        return ExploreViewHolder(
            ItemExploreBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) {

        holder.itemView.setOnClickListener {
            listener?.let {
                it()
            }
        }
    }
    private var listener: (() -> Unit)? = null
    fun onClick(click: () -> Unit) {
        listener = click
    }

    override fun getItemCount(): Int {
       return 10
    }
}