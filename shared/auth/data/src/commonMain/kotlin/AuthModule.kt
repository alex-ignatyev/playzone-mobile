import bd.LocalDataSource
import ktor.RemoteAuthDataSource
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider
import org.kodein.di.singleton

val authModule = DI.Module("authModule") {

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
