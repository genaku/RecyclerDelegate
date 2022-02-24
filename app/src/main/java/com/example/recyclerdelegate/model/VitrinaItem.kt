package com.example.recyclerdelegate.model

interface VitrinaItem {
    val vitrinaItemId: Long
}

interface ShelfItem: VitrinaItem {
    val title: String
}

interface SuperShelfItem: ShelfItem
interface SquareSuperShelfItem: SuperShelfItem
interface RectSuperShelfItem: SuperShelfItem
interface OverlaySuperShelfItem: SuperShelfItem

interface MovieShelfItem: ShelfItem
interface SeriesShelfItem: ShelfItem

interface BannerShelfItem: ShelfItem
interface SimpleBannerShelfItem: BannerShelfItem
interface VideoBannerShelfItem: BannerShelfItem

interface VideoBlockShelfItem: ShelfItem

data class SquareSuperShelfItemData(override val title: String): SquareSuperShelfItem {
    override val vitrinaItemId: Long
        get() = title.hashCode().toLong()
}

data class RectSuperShelfItemData(override val title: String): RectSuperShelfItem {
    override val vitrinaItemId: Long
        get() = title.hashCode().toLong()
}