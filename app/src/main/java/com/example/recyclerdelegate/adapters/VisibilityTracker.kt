package com.example.recyclerdelegate.adapters

interface VisibilityTracker<T> {
    fun addView(view: T, trackingInfo: ViewTrackingInfo)
    fun removeView(view: T)
    fun startTracking()
    fun stopTracking()
}