package feature.auth

import AuthRepository
import api.core.Answer
import api.core.onSuccess
import api.model.TokenResponse
import bd.LocalDataSource
import settings.AuthSettings

class AuthRepositoryImpl(
    private val remote: RemoteAuthDataSourceBase,
    private val local: LocalDataSource,
    private val settings: AuthSettings
) : AuthRepository {

    override suspend fun authenticate(): Answer<Unit> {
        return remote.authenticate()
    }

    override suspend fun logIn(login: String, password: String): Answer<TokenResponse> {
        val answer = remote.logIn(login, password)
        answer.onSuccess {
            settings.saveToken(it.token)
        }
        return answer
    }

    override suspend fun forgotPassword(login: String, password: String): Answer<Unit> {
        return remote.forgotPassword(login, password)
    }

    override suspend fun signIn(login: String, password: String): Answer<Unit> {
        return remote.signIn(login, password)
    }
}
