package feature.auth

import AuthRepository
import bd.LocalDataSource
import com.realcosmetology.android.utils.api.core.Answer

class AuthRepositoryImpl(
    private val remote: RemoteAuthDataSourceBase,
    private val local: LocalDataSource
) : AuthRepository {

    override suspend fun logIn(login: String, password: String): Answer<String> {
        return remote.logIn(login, password)
    }

    override suspend fun forgotPassword(login: String, password: String): Answer<Unit> {
        return remote.forgotPassword(login, password)
    }

    override suspend fun signIn(login: String, password: String): Answer<Unit> {
        return remote.signIn(login, password)
    }
}
