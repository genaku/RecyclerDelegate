package com.example.recyclerdelegate.adapters

import android.util.Log
import android.view.View
import com.example.recyclerdelegate.databinding.BoxItemBinding
import com.example.recyclerdelegate.databinding.SquareItemBinding
import com.example.recyclerdelegate.model.RectSuperShelfItem
import com.example.recyclerdelegate.model.SquareSuperShelfItem
import com.example.recyclerdelegate.model.VitrinaItem
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun squareAdapterDelegate(
    visibilityTracker: VisibilityTracker<View>
) = adapterDelegateViewBinding<SquareSuperShelfItem, VitrinaItem, SquareItemBinding>(
    viewBinding = { layoutInflater, parent ->
        SquareItemBinding.inflate(
            layoutInflater,
            parent,
            false
        )
    }
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

fun rectAdapterDelegate(
    visibilityTracker: VisibilityTracker<View>
) = adapterDelegateViewBinding<RectSuperShelfItem, VitrinaItem, BoxItemBinding>(
    viewBinding = { layoutInflater, parent ->
        BoxItemBinding.inflate(
            layoutInflater,
            parent,
            false
        )
    }
) {
    bind {
        binding.textView.text = item.title
        visibilityTracker.addView(binding.root, TrackingInfo(item))
    }
    onViewRecycled {
        visibilityTracker.removeView(binding.root)
    }
}