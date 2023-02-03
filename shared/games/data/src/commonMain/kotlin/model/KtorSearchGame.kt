package model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class KtorSearchGame(
    @SerialName("gameId") val gameID: String,
    @SerialName("title") val title: String
)

fun KtorSearchGame.mapToGame(): Game =
    Game(
        gameId = gameID,
        title = title
    )
