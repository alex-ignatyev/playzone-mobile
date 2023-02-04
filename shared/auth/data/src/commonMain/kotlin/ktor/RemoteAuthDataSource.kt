package ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class RemoteAuthDataSource(private val httpClient: HttpClient) {

    //FIXME разобраться с посотроением запросов
    suspend fun logIn() {
        return httpClient.get("games") {
            //header("Bearer-Authorization", "2bac6ef1-ca6d-42ca-96f3-923c68e88eca")
        }.body()
    }

    suspend fun forgotPassword() {

    }

    suspend fun signIn() {

    }
}
