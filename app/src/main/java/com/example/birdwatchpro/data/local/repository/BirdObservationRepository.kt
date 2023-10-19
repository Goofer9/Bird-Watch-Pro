package com.example.embeddedmap.data.local.repository

import androidx.lifecycle.LiveData
import com.example.embeddedmap.data.local.database.BirdObservationDao
import com.example.embeddedmap.data.local.database.BirdObservationEntity

class BirdObservationRepository(private val birdObservationDao: BirdObservationDao) {
    val allObservations: LiveData<List<BirdObservationEntity>> = birdObservationDao.getAllObservations()

    suspend fun insert(observation: BirdObservationEntity) {
        birdObservationDao.insert(observation)
    }
}
