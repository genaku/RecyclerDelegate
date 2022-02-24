package com.example.recyclerdelegate

import android.os.Parcelable
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.recyclerdelegate.adapters.ViewTrackingInfo
import com.example.recyclerdelegate.adapters.VisibilityTracker
import com.example.recyclerdelegate.model.*

class MainViewModel : ViewModel() {

    val scrollStates: MutableMap<Int, Parcelable> = mutableMapOf()

    val visibilityTracker = object : VisibilityTracker<View> {
        override fun addView(view: View, trackingInfo: ViewTrackingInfo) {
            Log.d("TAG", "add view $view $trackingInfo")
        }

        override fun removeView(view: View) {
            Log.d("TAG", "remove view $view")
        }

        override fun startTracking() {
        }

        override fun stopTracking() {
        }
    }

    val shelves = listOf(
        Shelf(
            type = ShelfType.VOD,
            shelfId = 0,
            title = "First shelf",
            items = getShelfItems(1)
        ),
        Shelf(
            type = ShelfType.VOD,
            shelfId = 1,
            title = "Second shelf",
            items = getShelfItems(2)
        ),
        Shelf(
            type = ShelfType.VOD,
            shelfId = 2,
            title = "Third shelf",
            items = getShelfItems(3)
        ),
        Shelf(
            type = ShelfType.VOD,
            shelfId = 3,
            title = "Forth shelf",
            items = getShelfItems(4)
        )
    )

    private fun getShelfItems(shelfPos: Int): List<SuperShelfItem> {
        val result = mutableListOf<SuperShelfItem>()
        for (i in 0..5) {
            result.add(SquareSuperShelfItemData("sh:$shelfPos item:${2 * i + 1}"))
            result.add(RectSuperShelfItemData("sh:$shelfPos item:${i * 2 + 2}"))
        }
        return result
    }
}