package com.example.recyclerdelegate.adapters

import android.util.Log
import android.view.View
import com.example.recyclerdelegate.databinding.BoxItemBinding
import com.example.recyclerdelegate.databinding.SquareItemBinding
import com.example.recyclerdelegate.model.VitrinaItem
import com.example.recyclerdelegate.model.Vod
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun squareAdapterDelegate(
    visibilityTracker: VisibilityTracker<View>
) = adapterDelegateViewBinding<Vod, VitrinaItem, SquareItemBinding>(
    viewBinding = { layoutInflater, parent ->
        SquareItemBinding.inflate(
            layoutInflater,
            parent,
            false
        )
    },
    on = { item, _, _ -> item.vitrinaItemId % 2 == 0L }
) {
    bind {
        Log.d("TAG", "bind item ${item.title}")
        binding.textView.text = item.title
        visibilityTracker.addView(binding.root, TrackingInfo(item))
    }
    onViewRecycled {
        visibilityTracker.removeView(binding.root)
    }
}

fun boxAdapterDelegate(
    visibilityTracker: VisibilityTracker<View>
) = adapterDelegateViewBinding<Vod, VitrinaItem, BoxItemBinding>(
    viewBinding = { layoutInflater, parent ->
        BoxItemBinding.inflate(
            layoutInflater,
            parent,
            false
        )
    },
    on = { item, _, _ -> item.vitrinaItemId % 2 == 1L }
) {
    bind {
        binding.textView.text = item.title
        visibilityTracker.addView(binding.root, TrackingInfo(item))
    }
    onViewRecycled {
        visibilityTracker.removeView(binding.root)
    }
}