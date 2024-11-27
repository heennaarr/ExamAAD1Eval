package edu.iesam.examaad1eval.features.ex2.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import edu.iesam.examaad1eval.features.ex2.data.remote.Player

const val DATABASE_NAME = "games"
const val DATABASE_ID = "id"

@Entity(tableName = DATABASE_NAME)
    data class GameEntity(
    @PrimaryKey @ColumnInfo(name = DATABASE_ID) val id: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "player") val player: List<Player>
    )
