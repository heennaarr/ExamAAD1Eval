package edu.iesam.examaad1eval.features.ex2.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import edu.iesam.examaad1eval.features.ex2.data.remote.Player

class Converters {
    private val gson = Gson()
    @TypeConverter
    fun toEntity(json: String): List<Player> {
        return gson.fromJson(json, Array<Player>::class.java).toList()
    }
    @TypeConverter
    fun fromEntity(entity: List<Player>): String {
        return gson.toJson(entity)
    }



}