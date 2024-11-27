package edu.iesam.examaad1eval.features.ex2.core

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import edu.iesam.examaad1eval.features.ex2.data.local.Converters
import edu.iesam.examaad1eval.features.ex2.data.local.GameDao
import edu.iesam.examaad1eval.features.ex2.data.local.GameEntity

@Database(entities = [GameEntity::class], version = 1 , exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun gameDao(): GameDao
}