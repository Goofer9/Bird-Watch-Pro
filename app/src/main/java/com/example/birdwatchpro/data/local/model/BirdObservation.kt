package com.example.embeddedmap.data.model

data class BirdObservation(
    val id: Int,
    val birdName: String,
    val latitude: Double,
    val longitude: Double,
    val observationTime: String
)
