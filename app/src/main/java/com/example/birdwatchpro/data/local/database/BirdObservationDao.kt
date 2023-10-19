package com.example.embeddedmap.data.local.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.embeddedmap.data.local.database.BirdObservationEntity



@Dao
interface BirdObservationDao {
    @Insert
    fun insert(observation: BirdObservationEntity)

    @Query("SELECT * FROM bird_observation")
    fun getAllObservations(): LiveData<List<BirdObservationEntity>>
}