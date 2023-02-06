package feature.auth

import AuthRepository
import bd.LocalDataSource

class AuthRepositoryImpl(
    private val remote: RemoteAuthDataSource,
    private val local: LocalDataSource
) : AuthRepository {

    override suspend fun logIn(login: String, password: String): String {
        return remote.logIn(login, password)
    }

    override suspend fun forgotPassword() {
        remote.forgotPassword()
    }

    override suspend fun signIn() {
        remote.signIn()
    }
}
