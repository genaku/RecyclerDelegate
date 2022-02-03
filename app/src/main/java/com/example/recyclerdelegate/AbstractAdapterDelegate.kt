package com.example.recyclerdelegate

import androidx.recyclerview.widget.RecyclerView

abstract class AbstractAdapterDelegate : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    abstract fun supports(type: ShelfType): Boolean
}