import model.TokenResponse

interface AuthRepository {
    suspend fun authenticate(): Answer<Unit>
    suspend fun logIn(login: String, password: String): Answer<TokenResponse>
    suspend fun forgotPassword(login: String, password: String): Answer<Unit>
    suspend fun signIn(login: String, password: String): Answer<Unit>
}
