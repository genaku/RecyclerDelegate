package com.example.recyclerdelegate.adapters

import android.os.Parcelable
import android.view.View
import com.example.recyclerdelegate.model.VitrinaItem
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class VitrinaAdapter(
    scrollStates: MutableMap<Int, Parcelable>,
    visibilityTracker: VisibilityTracker<View>
) : AsyncListDifferDelegationAdapter<VitrinaItem>(BaseDiffUtilItemCallback()) {
    init {
        delegatesManager
            .addDelegate(shelfAdapterDelegate(scrollStates, visibilityTracker))
    }
}