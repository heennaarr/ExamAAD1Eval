package edu.iesam.examaad1eval.features.ex2.core

import android.content.Context
import androidx.room.Room

class DataBaseProvider() {
    fun dataBaseProvider(context: Context): AppDatabase {
        val db = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "database-name"
        ).fallbackToDestructiveMigration().build()
        return db

    }
}