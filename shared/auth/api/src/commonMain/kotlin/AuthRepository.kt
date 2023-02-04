interface AuthRepository {
    suspend fun logIn()
    suspend fun forgotPassword()
    suspend fun signIn()
}
