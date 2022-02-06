package com.example.recyclerdelegate.adapters

import android.view.View
import com.example.recyclerdelegate.model.VitrinaItem
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class ShelfItemsAdapter(
    visibilityTracker: VisibilityTracker<View>
) : AsyncListDifferDelegationAdapter<VitrinaItem>(BaseDiffUtilItemCallback()) {

    init {
        delegatesManager
            .addDelegate(squareAdapterDelegate(visibilityTracker))
            .addDelegate(boxAdapterDelegate(visibilityTracker))
    }

    override fun getItemId(position: Int): Long {
        return items[position].vitrinaItemId
    }
}