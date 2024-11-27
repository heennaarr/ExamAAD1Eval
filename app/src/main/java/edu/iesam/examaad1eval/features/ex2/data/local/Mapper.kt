package edu.iesam.examaad1eval.features.ex2.data.local

import edu.iesam.examaad1eval.features.ex2.data.remote.Game

fun Game.toEntity(): GameEntity {
    return GameEntity(
        id = id,
        title = title,
        player = player
    )
}

fun GameEntity.toDomain(): Game {
    return Game(
        id = id,
        title = title,
        player = player
    )
}