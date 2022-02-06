package com.example.recyclerdelegate

import android.os.Parcelable
import androidx.lifecycle.ViewModel
import com.example.recyclerdelegate.model.Shelf
import com.example.recyclerdelegate.model.ShelfType
import com.example.recyclerdelegate.model.Vod

class MainViewModel: ViewModel() {

    private val shelfItems = listOf(
        Vod(1, "first"),
        Vod(2, "second"),
        Vod(3, "third"),
        Vod(4, "forth")
    )

    val scrollStates: MutableMap<Int, Parcelable> = mutableMapOf()

    val shelves = listOf(
        Shelf(
            type = ShelfType.VOD,
            shelfId = 0,
            title = "First shelf",
            items = shelfItems
        ),
        Shelf(
            type = ShelfType.VOD,
            shelfId = 1,
            title = "Second shelf",
            items = shelfItems
        ),
        Shelf(
            type = ShelfType.VOD,
            shelfId = 2,
            title = "Third shelf",
            items = shelfItems
        ),
        Shelf(
            type = ShelfType.VOD,
            shelfId = 3,
            title = "Forth shelf",
            items = shelfItems
        )
    )
}