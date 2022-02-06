package com.example.recyclerdelegate

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerdelegate.model.Shelf
import com.example.recyclerdelegate.model.ShelfType

class DelegatedAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var shelves: List<Shelf> = emptyList()

    private var adapterDelegates: Set<AbstractAdapterDelegate> = emptySet()

    fun setAdapterDelegates(delegates: Set<AbstractAdapterDelegate>) {
        adapterDelegates = delegates
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        getAdapterDelegate(shelves[viewType].type)?.onCreateViewHolder(parent, viewType)!! // lets throw exception when proper delegate is not found

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        getAdapterDelegate(shelves[position].type)?.onBindViewHolder(holder, position)
    }

    override fun getItemCount(): Int =
        shelves.size

    private fun getAdapterDelegate(type: ShelfType): AbstractAdapterDelegate? =
        adapterDelegates.firstOrNull { it.supports(type) }
}