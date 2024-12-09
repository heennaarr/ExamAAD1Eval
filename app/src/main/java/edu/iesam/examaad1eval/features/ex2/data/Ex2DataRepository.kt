package edu.iesam.examaad1eval.features.ex2.data

import edu.iesam.examaad1eval.features.ex2.data.local.GameDbLocalDataSource
import edu.iesam.examaad1eval.features.ex2.data.remote.Ex2Repository
import edu.iesam.examaad1eval.features.ex2.data.remote.Game
import edu.iesam.examaad1eval.features.ex2.data.remote.MockEx2RemoteDataSource

class Ex2DataRepository(
    private val localDataSource: GameDbLocalDataSource,
    private val remoteDataSource: MockEx2RemoteDataSource
) :Ex2Repository {
    override fun getGames(): List<Game> {
        val games = localDataSource.getGames()
        if (games.isEmpty()) {
            val remote = remoteDataSource.getGames()
            localDataSource.setGames(remote)
            return remote
        }
        return games
    }
}