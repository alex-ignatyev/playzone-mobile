package feature.auth

import AuthRepository
import bd.LocalDataSource
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider
import org.kodein.di.singleton

val authModule = DI.Module("feature.auth.getAuthModule") {

    bind<RemoteAuthDataSource>() with provider {
        RemoteAuthDataSource(instance())
    }

    bind<LocalDataSource>() with provider {
        LocalDataSource()
    }

    bind<AuthRepository>() with singleton {
        AuthRepositoryImpl(instance(), instance())
    }
}
