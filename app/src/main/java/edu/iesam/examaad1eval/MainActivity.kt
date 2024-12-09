package edu.iesam.examaad1eval

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.examaad1eval.features.ex2.data.remote.MockEx2RemoteDataSource
import edu.iesam.examaad1eval.features.ex2.core.DataBaseProvider
import edu.iesam.examaad1eval.features.ex2.data.Ex2DataRepository
import edu.iesam.examaad1eval.features.ex2.data.local.GameDbLocalDataSource
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        executeExercise1()
        executeExercise2()
    }
    @OptIn(DelicateCoroutinesApi::class)
    private fun executeExercise1(){
        //Ejecutar el ejercicio 1 desde aquí llamando al Ex1DataRepository directamente
        val room = Ex2DataRepository(
            GameDbLocalDataSource(DataBaseProvider().dataBaseProvider(this).gameDao()),
            MockEx2RemoteDataSource()
        )
        GlobalScope.launch {
            val games = room.getGames()
            Log.d("@dev", games.toString())
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun executeExercise2(){
        //Ejecutar el ejercicio 2 desde aquí llamando al Ex2DataRepository directamente
        val room = GameDbLocalDataSource(DataBaseProvider().dataBaseProvider(this).gameDao())
        GlobalScope.launch {
            room.getGames()
        }
    }
}