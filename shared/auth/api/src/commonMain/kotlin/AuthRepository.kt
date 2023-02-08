import com.realcosmetology.android.utils.api.core.Answer

interface AuthRepository {
    suspend fun logIn(login: String, password: String): Answer<String>
    suspend fun forgotPassword(login: String, password: String): Answer<Unit>
    suspend fun signIn(login: String, password: String): Answer<Unit>
}
