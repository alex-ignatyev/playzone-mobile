import model.LoginRequest
import model.TokenResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.HttpHeaders
import settings.AuthSettings

class RemoteAuthDataSource(
    private val httpClient: HttpClient,
    private val settings: AuthSettings
) : BaseRemoteDataSource() {

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
