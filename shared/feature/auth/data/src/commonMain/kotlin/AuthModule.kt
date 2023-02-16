import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider
import org.kodein.di.singleton
import settings.AuthSettings

val authModule = DI.Module("feature.auth.getAuthModule") {

    bind<AuthSettings>() with provider {
        SettingsAuthDataSource(instance())
    }

    bind<RemoteAuthDataSource>() with provider {
        RemoteAuthDataSource(instance(), instance())
    }

    bind<AuthRepository>() with singleton {
        AuthRepositoryImpl(instance(), instance())
    }
}
