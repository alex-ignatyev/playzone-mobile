package ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.path
import model.Game
import model.KtorSearchGame
import model.KtorSearchRequest

class KtorGamesDataSource(private val httpClient: HttpClient) {

    suspend fun fetchAllGames(): List<KtorSearchGame> {
        return httpClient.post {
            header("Bearer-Authorization", "2bac6ef1-ca6d-42ca-96f3-923c68e88eca")

            url {
                path("games/search")
                setBody(KtorSearchRequest(""))
            }
        }.body()
    }

    suspend fun searchGame(query: String): Game {
        return Game("", "")
    }
}