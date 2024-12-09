package edu.iesam.examaad1eval.features.ex2.data.local

import edu.iesam.examaad1eval.features.ex2.data.remote.Game


class GameDbLocalDataSource(private val gameDao: GameDao) {

    fun getGames(): List<Game> {
        return gameDao.getGames().map {
            it.toDomain()
        }
    }
    fun setGames(games: List<Game>) {
        gameDao.insertGame(*games.map { it.toEntity() }.toTypedArray())
    }



}