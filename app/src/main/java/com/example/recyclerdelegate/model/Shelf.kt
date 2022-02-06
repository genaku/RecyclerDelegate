package com.example.recyclerdelegate.model

data class Shelf(
    val type: ShelfType,
    val shelfId: Long,
    val title: String,
    val items: List<VitrinaItem>
) : VitrinaItem {
    override val vitrinaItemId: Long
        get() = 31L * type.hashCode() + 31L * shelfId.hashCode() + title.hashCode().toLong()
}