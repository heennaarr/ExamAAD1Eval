package edu.iesam.examaad1eval.features.ex2.data.local


class GameDbLocalDataSource(private val gameDao: GameDao) {

    fun getGames(): List<GameEntity> {
        return gameDao.getGames()
    }

}