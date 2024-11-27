package edu.iesam.examaad1eval.features.ex2.data.local

import androidx.room.Dao
import androidx.room.Query

@Dao
interface GameDao {
    @Query("SELECT * FROM $DATABASE_NAME")
    fun getGames(): List<GameEntity>


}