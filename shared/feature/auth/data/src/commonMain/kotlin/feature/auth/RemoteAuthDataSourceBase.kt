package feature.auth

import api.core.Answer
import feature.BaseRemoteDataSource
import api.model.LoginRequest
import api.model.TokenResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.HttpHeaders
import settings.AuthSettings

class RemoteAuthDataSourceBase(
    private val httpClient: HttpClient,
    private val settings: AuthSettings
) : BaseRemoteDataSource() {

    // "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJ1c2VycyIsImlzcyI6Imh0dHA6Ly8wLjAuMC4wOjgwODAiLCJleHAiOjE3MDc4Mzc4NjAsInVzZXJJZCI6IjYzZWE0MTMyN2ZmMjAyNzdlZmNlNmZkMyJ9.0DtU7Q3IkJl7SS_yUMkOcWfiLsNM06s7AcZt69YfCLM"

    suspend fun authenticate(): Answer<Unit> {
        return apiCall {
            httpClient.get {
                header(HttpHeaders.Authorization, settings.fetchToken())
                url("authenticate")
            }
        }
    }

    suspend fun logIn(login: String, password: String): Answer<TokenResponse> {
        return apiCall {
            httpClient.post {
                setBody(LoginRequest(login, password))
                url("login")
            }
        }
    }

    suspend fun forgotPassword(login: String, password: String): Answer<Unit> {
        return apiCall {
            httpClient.post {
                setBody(LoginRequest(login, password))
                url("forgot")
            }
        }
    }

    suspend fun signIn(login: String, password: String): Answer<Unit> {
        return apiCall {
            httpClient.post {
                setBody(LoginRequest(login, password))
                url("register")
            }
        }
    }
}
