package com.example.birdwatchpro.data.local.repository

import androidx.lifecycle.LiveData
import com.example.birdwatchpro.data.local.database.BirdObservationDao
import com.example.birdwatchpro.data.local.database.BirdObservationEntity

class BirdObservationRepository(private val birdObservationDao: BirdObservationDao) {
    val allObservations: LiveData<List<BirdObservationEntity>> = birdObservationDao.getAllObservations()

    suspend fun insert(observation: BirdObservationEntity) {
        birdObservationDao.insert(observation)
    }
}
