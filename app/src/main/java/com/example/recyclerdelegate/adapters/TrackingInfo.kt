package com.example.recyclerdelegate.adapters

import com.example.recyclerdelegate.model.VitrinaItem

data class TrackingInfo(
    val item: VitrinaItem,
    override val id: String = item.vitrinaItemId.toString()
) : ViewTrackingInfo