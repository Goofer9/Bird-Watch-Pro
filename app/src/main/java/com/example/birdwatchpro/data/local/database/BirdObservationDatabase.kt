package com.example.birdwatchpro.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BirdObservationEntity::class], version = 1, exportSchema = false)
abstract class BirdObservationDatabase : RoomDatabase() {
    abstract fun birdObservationDao(): BirdObservationDao

    companion object {
        @Volatile
        private var INSTANCE: BirdObservationDatabase? = null

        fun getDatabase(context: Context): BirdObservationDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BirdObservationDatabase::class.java,
                    "bird_observation_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
