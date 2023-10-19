package com.example.embeddedmap.data.local.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bird_observations")
data class BirdObservationEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val birdName: String,
    val latitude: Double,
    val longitude: Double,
    val observationTime: String
)

