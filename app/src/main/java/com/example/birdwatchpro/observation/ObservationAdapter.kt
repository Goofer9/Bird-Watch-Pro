package com.example.birdwatchpro.observation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.birdwatchpro.R
import com.example.birdwatchpro.databinding.ObservationListItemBinding
import com.example.embeddedmap.data.local.database.BirdObservationEntity

class ObservationAdapter : ListAdapter<BirdObservationEntity, ObservationAdapter.ObservationViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObservationViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ObservationListItemBinding = DataBindingUtil.inflate(
            inflater, R.layout.observation_list_item, parent, false
        )
        return ObservationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ObservationViewHolder, position: Int) {
        val observation = getItem(position)
        holder.bind(observation)
    }

    class ObservationViewHolder(private val binding: ObservationListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(observation: BirdObservationEntity) {
            binding.observation = observation
            binding.executePendingBindings()
        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<BirdObservationEntity>() {
        override fun areItemsTheSame(oldItem: BirdObservationEntity, newItem: BirdObservationEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: BirdObservationEntity, newItem: BirdObservationEntity): Boolean {
            return oldItem == newItem
        }
    }
}

