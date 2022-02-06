package com.example.recyclerdelegate

import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerdelegate.model.ShelfType

abstract class AbstractAdapterDelegate : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    abstract fun supports(type: ShelfType): Boolean
}