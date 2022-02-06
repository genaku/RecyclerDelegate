package com.example.recyclerdelegate

import com.example.recyclerdelegate.model.VitrinaItem
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class ShelfItemsAdapter :
    AsyncListDifferDelegationAdapter<VitrinaItem>(BaseDiffUtilItemCallback()) {

    init {
        delegatesManager
            .addDelegate(squareAdapterDelegate())
            .addDelegate(boxAdapterDelegate())
    }

    override fun getItemId(position: Int): Long {
        return items[position].vitrinaItemId
    }
}