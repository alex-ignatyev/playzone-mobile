interface AuthRepository {
    suspend fun logIn(login: String, password: String): String
    suspend fun forgotPassword()
    suspend fun signIn()
}
