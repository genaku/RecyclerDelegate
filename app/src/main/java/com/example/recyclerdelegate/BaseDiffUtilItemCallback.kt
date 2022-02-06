package com.example.recyclerdelegate

import androidx.recyclerview.widget.DiffUtil
import com.example.recyclerdelegate.model.VitrinaItem

open class BaseDiffUtilItemCallback : DiffUtil.ItemCallback<VitrinaItem>() {

    override fun areItemsTheSame(oldItem: VitrinaItem, newItem: VitrinaItem): Boolean =
        oldItem.vitrinaItemId == newItem.vitrinaItemId

    override fun areContentsTheSame(oldItem: VitrinaItem, newItem: VitrinaItem): Boolean {
        return oldItem.equals(newItem)
    }
}