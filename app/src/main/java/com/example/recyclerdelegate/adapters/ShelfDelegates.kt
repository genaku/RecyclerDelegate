package com.example.recyclerdelegate.adapters

import android.os.Parcelable
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerdelegate.databinding.ShelfItemBinding
import com.example.recyclerdelegate.model.Shelf
import com.example.recyclerdelegate.model.VitrinaItem
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun shelfAdapterDelegate(
    scrollStates: MutableMap<Int, Parcelable>,
    visibilityTracker: VisibilityTracker<View>
) = adapterDelegateViewBinding<Shelf, VitrinaItem, ShelfItemBinding>(
    viewBinding = { layoutInflater, parent ->
        ShelfItemBinding.inflate(
            layoutInflater,
            parent,
            false
        )
    }
) {
    val adapter = ShelfItemsAdapter(visibilityTracker)
    binding.rvShelf.adapter = adapter
    binding.rvShelf.layoutManager = LinearLayoutManager(context).apply {
        orientation = LinearLayoutManager.HORIZONTAL
    }

    bind {
        binding.tvTitle.text = item.title
        Log.d("TAG", "bind ${item.title} ${item.items}")
        adapter.items = item.items
        scrollStates[bindingAdapterPosition]?.run {
            binding.rvShelf.layoutManager?.onRestoreInstanceState(this)
            scrollStates.remove(bindingAdapterPosition)
        }
        visibilityTracker.addView(binding.root, TrackingInfo(item))
    }

    onViewRecycled {
        binding.rvShelf.layoutManager?.onSaveInstanceState()?.run {
            scrollStates[bindingAdapterPosition] = this
        }
        visibilityTracker.removeView(binding.root)
    }
}