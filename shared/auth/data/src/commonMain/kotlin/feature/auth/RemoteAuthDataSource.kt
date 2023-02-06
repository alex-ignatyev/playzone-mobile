package feature.auth

import feature.auth.model.LoginRequest
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url

class RemoteAuthDataSource(private val httpClient: HttpClient) {

    suspend fun logIn(login: String, password: String): String {
        return httpClient.post {
            setBody(LoginRequest(login, password))
            url("login")
        }.body()
    }

    suspend fun forgotPassword() {

    }

    suspend fun signIn() {

    }
}
