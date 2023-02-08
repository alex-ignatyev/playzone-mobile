package feature.auth

import com.realcosmetology.android.utils.api.core.Answer
import feature.BaseRemoteDataSource
import feature.auth.model.LoginRequest
import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url

class RemoteAuthDataSourceBase(private val httpClient: HttpClient) : BaseRemoteDataSource() {

    suspend fun logIn(login: String, password: String): Answer<String> {
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
