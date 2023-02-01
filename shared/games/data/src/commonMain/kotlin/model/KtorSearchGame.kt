package model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class KtorSearchGame(
    @SerialName("gameID") val gameID: String,
    @SerialName("title") val title: String,
    @SerialName("description") val description: String,
    @SerialName("version") val version: String,
    @SerialName("size") val size: String,
)

fun KtorSearchGame.mapToGame(): Game =
    Game(
        gameId = gameID,
        title = title
    )
