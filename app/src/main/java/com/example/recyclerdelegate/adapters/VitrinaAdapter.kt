package com.example.recyclerdelegate.adapters

import android.os.Parcelable
import com.example.recyclerdelegate.model.VitrinaItem
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class VitrinaAdapter(
    scrollStates: MutableMap<Int, Parcelable>
) : AsyncListDifferDelegationAdapter<VitrinaItem>(BaseDiffUtilItemCallback()) {
    init {
        delegatesManager
            .addDelegate(shelfAdapterDelegate(scrollStates))
    }
}