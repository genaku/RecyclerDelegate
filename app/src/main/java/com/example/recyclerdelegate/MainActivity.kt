package com.example.recyclerdelegate

import android.os.Bundle
import android.os.Parcelable
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerdelegate.model.Shelf
import com.example.recyclerdelegate.model.ShelfType
import com.example.recyclerdelegate.model.Vod
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    private val adapter by lazy {
        VitrinaAdapter(
            viewModel.scrollStates
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRV()
    }

    private fun setupRV() {
        val rv = findViewById<RecyclerView>(R.id.rv)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter

        adapter.items = viewModel.shelves
    }

    override fun onStop() {
        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        (recyclerView.layoutManager as? LinearLayoutManager)?.let { lm ->
            val visibleRange = lm.findFirstVisibleItemPosition()..lm.findLastVisibleItemPosition()
            for (i in visibleRange) {
                val state = recyclerView.findViewHolderForAdapterPosition(i)
                    ?.itemView
                    ?.findViewById<RecyclerView>(R.id.rvShelf)
                    ?.layoutManager
                    ?.onSaveInstanceState()
                state?.let { viewModel.scrollStates[i] = it }
            }
        }
        super.onStop()
    }
}