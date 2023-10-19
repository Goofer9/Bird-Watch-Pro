package com.example.birdwatchpro.data.local.model

data class BirdObservation(
    val id: Int,
    val birdName: String,
    val latitude: Double,
    val longitude: Double,
    val observationTime: String
)
