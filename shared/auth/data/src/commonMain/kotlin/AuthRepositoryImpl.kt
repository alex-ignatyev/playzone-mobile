import bd.LocalDataSource
import ktor.RemoteAuthDataSource

class AuthRepositoryImpl(
    private val remote: RemoteAuthDataSource,
    private val local: LocalDataSource
) : AuthRepository {

    override suspend fun logIn() {
        remote.logIn()
    }

    override suspend fun forgotPassword() {
        remote.forgotPassword()
    }

    override suspend fun signIn() {
        remote.signIn()
    }
}
