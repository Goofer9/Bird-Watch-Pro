package com.example.birdwatchpro.observation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.birdwatchpro.R


class ObservationListActivity : AppCompatActivity() {
    private lateinit var observationRecyclerView: RecyclerView
    private lateinit var observationAdapter: ObservationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_observation_list)

        // Initialize RecyclerView and Adapter
        observationRecyclerView = findViewById(R.id.observationRecyclerView)
        observationAdapter = ObservationAdapter()

        // Set up RecyclerView with LayoutManager and Adapter
        observationRecyclerView.layoutManager = LinearLayoutManager(this)
        observationRecyclerView.adapter = observationAdapter

        // Populate the RecyclerView with data (observe LiveData, fetch data, etc.)
        // For example, if you have a LiveData list of observations:
        // viewModel.observations.observe(this, { observations ->
        //     observationAdapter.submitList(observations)
        // })
    }
}

