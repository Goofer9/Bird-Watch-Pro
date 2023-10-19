package com.example.birdwatchpro.data.local.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface BirdObservationDao {
    @Insert
    fun insert(observation: BirdObservationEntity)

    @Query("SELECT * FROM bird_observations")
    fun getAllObservations(): LiveData<List<BirdObservationEntity>>
}